package com.inturn.biz.board.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.inturn.biz.board.dao.FileDAO;
import com.inturn.biz.board.dao.FreeBoardDAO;
import com.inturn.biz.board.vo.FileGroupVO;
import com.inturn.biz.board.vo.FilesVO;
import com.inturn.biz.board.vo.FreeBoardVO;

/**
 * 
 * @author 박현호
 * @version 1.0
 * @since 2018.05.28
 * @see 자유게시판 관련 서비스 함수
 */
@Service("FreeBoardService")
public class FreeBoardServiceImpl implements FreeBoardService {
	@Resource(name = "FreeBoardDAO")
	FreeBoardDAO fb_dao;
	@Resource(name = "FileDAO")
	FileDAO file_dao;

	/**
	 * @param FreeBoardVO로
	 *            받아서 관련된 임시저장파일과 게시글 정보를 통해 DB에 저장
	 */
	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public int insertFreeBoard(FreeBoardVO vo) {
		int row = 0;
		int fileGroupNum = file_dao.findFileGroup(vo.getId());
		row += fb_dao.insertFreeBoard(vo);
		if (fileGroupNum != 0) {
			row += file_dao.update_FB_FileGroup(new FileGroupVO(fileGroupNum, fb_dao.findBoard(vo)));
			row += file_dao.insertBoard(vo.getId());
		}
		return row;
	}

	/**
	 * @param 수정된 게시판 VO
	 * 먼저 게시판 수정 시 새로운 파일을 추가적으로 저장한다면 그 부분에 대해 저장시킨다.
	 * 이 후 지우고 저장했다면, FileGroup이 하나 더 생성되었으므로, 기존의 FileGroupNum으로 맞춰준다.
	 * 마지막으로 삭제된 파일이 있을 수 있으므로, content에서 img태그의 src를 가져온다
	 * 파일의 file_num으로 저장되어있으므로 해당 게시물이 DB에 저장되어있는 파일번호랑 비교한 후
	 * DB에서 현재 Content에 없는 파일을 모두 지운다.
	 */
	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public int modifyFreeBoard(FreeBoardVO vo) {
		int row = 0;
		// 먼저 임시파일로 되어있는 놈을 제대로 DB에 넣어준다.
		int fileGroupNum = file_dao.findFileGroup(vo.getId());
		row += fb_dao.modifyFreeBoard(vo);
		if (fileGroupNum != 0) {
			row += file_dao.update_FB_FileGroup(new FileGroupVO(fileGroupNum, fb_dao.findBoard(vo)));
			row += file_dao.insertBoard(vo.getId());
		}
		// 제대로 들어 갔으면 FileGroupNum을 맞춰주어야 하므로 그 부분을 upadate하기 위해 작업한다.
		int fileGroupNumMin = file_dao.findFileGroupNumMin(vo.getFb_num());
		int fileGroupNumMax = file_dao.findFileGroupNumMax(vo.getFb_num());
		// 파일 추가 없이 삭제만 했을 경우
		if (fileGroupNumMin != fileGroupNumMax) {
			HashMap<String, Integer> map = new HashMap<>();
			map.put("min", fileGroupNumMin);
			map.put("max", fileGroupNumMax);
			row += file_dao.modify_FB_files(map);
			row += file_dao.deleteFileGroup(fileGroupNumMax);
		}
		List<FilesVO> list = file_dao.findFiles(fileGroupNumMin);
		// content의 img태그에서 src만 가져오기
		Pattern nonValidPattern = Pattern.compile("<img[^>]*src=[\"']?([^>\"']+)[\"']?[^>]*>");
		Matcher matcher = nonValidPattern.matcher(vo.getContent());
		while (matcher.find()) {
			int fileNum = Integer.parseInt(matcher.group(1).substring(30, matcher.group(1).indexOf(".")));
			for (int i=0; i<list.size(); i++) {
				if (list.get(i).getFile_num() == fileNum)
					continue;
				else if (i == list.size() - 1)
					file_dao.delete_FB_Files(list.get(i).getFile_num());
			}
		}
		return row;
	}

	/**
	 * @param fb_num을
	 *            통해 해당 게시글에 저장된 파일을 모두 삭제 후 게시글 삭제
	 */
	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public int deleteFreeBoard(int fb_num) {
		int row = 0;
		int fileGroupNum = file_dao.findFileGroupNumMax(fb_num);
		if (fileGroupNum != 0) {
			row += file_dao.deleteFile(fileGroupNum);
			row += file_dao.delete_FB_FileGroup(fb_num);
		}
		row += fb_dao.deleteFreeBoard(fb_num);
		return row;
	}

	/**
	 * @param id,
	 *            content, title을 통해 찾고자 하는 게시글을 찾는 함수 insertBoard에서 FilGroup을 설정할
	 *            때, 막 입력한 게시글의 번호를 가져오기 위해 사용한다.
	 */
	@Override
	public int findBoard(FreeBoardVO vo) {
		return fb_dao.findBoard(vo);
	}

	/**
	 * @param page_num
	 *            게시판 목록에서 현재 보고있는 페이지 게시판 목록을 반환하는 함수
	 */
	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public HashMap<String, Object> boardList(int page_num) {
		// 전체 게시판 개수를 가져옴
		int total_boards = fb_dao.countBoards();
		// 게시판을 10개씩 페이징 처리했을 때, 총 몇개의 목록이 나오는지 계산
		int count_page = (total_boards + 9) / 10;
		// 만약 마지막 페이지의 게시글이 1개 인데 삭제된 경우
		if (count_page < page_num)
			page_num--;
		// 마지막 페이지의 개수를 계산
		int reminder = total_boards % 10;
		if (reminder == 0)
			reminder = 10;
		// 클릭한 해당 페이지의 처음 번호와, 마지막번호를 계산
		int limit = (count_page - page_num) * 10 + reminder; // 마지막번호
		int offset = (count_page - (page_num + 1)) * 10 + reminder; // 첫 번호
		// 결과를 계산, 반환하기 위한 Map 정의
		HashMap<String, Integer> map = new HashMap<String, Integer>();
		HashMap<String, Object> result = new HashMap<String, Object>();

		if (offset < 0)
			offset = 0; // 마지막 페이지일 경우 음수 값이 되므로 첫 번호를 0으로 만들어줌
		result.put("limit", limit + 1); // 미리 게시판 번호의 수를 넣어놓는다.
		limit -= offset; // 마지막과 첫 번호의 차를 구해 가져올 개수를 구함
		map.put("offset", offset); // 계시판 페이징의 시작 게시판 번호 값
		map.put("limit", limit); // 시작번호로 부터 몇개를 가져올지 계산한 값을 넣는다.
		// 결과값을 list에 넣는다.
		List<FreeBoardVO> list = fb_dao.boardList(map);
		// 총 페이지수가 몇개인지도 보내줘야 하므로 Map구조로 put해서 result를 return
		result.put("list", list);
		result.put("count_page", count_page);
		result.put("thisPage", page_num);
		return result;
	}

	/**
	 * 현재 게시글이 몇개가 있는지 파악하기 위해 쓰는 함수 페이징 처리를 위해 사용한다.
	 */
	@Override
	public int countBoards() {
		return fb_dao.countBoards();
	}

	/**
	 * @param 현재
	 *            게시판 번호를 통해 게시판의 정보를 담아 반환하는 함수
	 */
	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public HashMap<String, Object> viewBoard(int fb_num) {
		fb_dao.countUp(fb_num);
		HashMap<String, Object> result = new HashMap<String, Object>();
		FreeBoardVO vo = fb_dao.viewBoard(fb_num);
		// 여기에 이제, 댓글도 result에 put해서 보내주어야함.
		result.put("board", vo);
		result.put("prevfb_num", fb_dao.prevfb_num(fb_num));
		result.put("nextfb_num", fb_dao.nextfb_num(fb_num));
		return result;
	}
}
