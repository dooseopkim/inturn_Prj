package com.inturn.biz.board.service;

import java.util.HashMap;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.inturn.biz.board.dao.FileDAO;
import com.inturn.biz.board.dao.MenteeBoardDAO;
import com.inturn.biz.board.dao.ReplyDAO;
import com.inturn.biz.board.vo.FileGroupVO;
import com.inturn.biz.board.vo.FilesVO;
import com.inturn.biz.board.vo.MenteeBoardVO;

/**
 * 
 * @author youngseo
 * @since 2018.07.17
 *
 */
@Service("MenteeBoardService")
public class MenteeBoardServiceImpl implements MenteeBoardService {

	@Resource(name = "MenteeBoardDAO")
	MenteeBoardDAO tb_dao;
	@Resource(name = "FileDAO")
	FileDAO file_dao;
	@Resource(name = "ReplyDAO")
	ReplyDAO reply_dao;

	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public HashMap<String, Object> boardList(int page_num) {
		// 전체 게시판 개수를 가져옴
		int total_boards = tb_dao.countBoards();
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
		List<MenteeBoardVO> list = tb_dao.boardList(map);
		// 총 페이지수가 몇개인지도 보내줘야 하므로 Map구조로 put해서 result를 return
		result.put("list", list);
		result.put("count_page", count_page);
		result.put("thisPage", page_num);
		return result;
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public HashMap<String, Object> scBoardList(String condition, String search, int page_num) {
		// 전체 게시판 개수를 가져옴
		int total_boards = tb_dao.scCountBoards(condition, search);
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
		HashMap<String, Object> map = new HashMap<String, Object>();
		HashMap<String, Object> result = new HashMap<String, Object>();

		if (offset < 0)
			offset = 0; // 마지막 페이지일 경우 음수 값이 되므로 첫 번호를 0으로 만들어줌
		result.put("limit", limit + 1); // 미리 게시판 번호의 수를 넣어놓는다.
		limit -= offset; // 마지막과 첫 번호의 차를 구해 가져올 개수를 구함
		map.put("offset", offset); // 계시판 페이징의 시작 게시판 번호 값
		map.put("limit", limit); // 시작번호로 부터 몇개를 가져올지 계산한 값을 넣는다.
		map.put("condition", condition);
		map.put("search", search);
		// 결과값을 list에 넣는다.
		List<MenteeBoardVO> list = tb_dao.scBoardList(map);
		// 총 페이지수가 몇개인지도 보내줘야 하므로 Map구조로 put해서 result를 return
		result.put("list", list);
		result.put("count_page", count_page);
		result.put("thisPage", page_num);
		return result;
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public HashMap<String, Object> viewBoard(int tb_num) {
		tb_dao.countUp(tb_num);
		System.out.println("countup");
		HashMap<String, Object> result = new HashMap<String, Object>();
		MenteeBoardVO vo = tb_dao.viewBoard(tb_num);
		result.put("board", vo);
		result.put("prevtb_num", tb_dao.prevtb_num(tb_num));
		result.put("nexttb_num", tb_dao.nexttb_num(tb_num));
		return result;
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public HashMap<String, Object> scViewBoard(String condition, String search, int tb_num) {
		tb_dao.countUp(tb_num);
		HashMap<String, Object> result = new HashMap<String, Object>();
		MenteeBoardVO vo = tb_dao.viewBoard(tb_num);
		result.put("board", vo);
		result.put("prevtb_num", tb_dao.scPrevtb_num(condition, search, tb_num));
		result.put("nexttb_num", tb_dao.scNexttb_num(condition, search, tb_num));
		return result;
	}

	@Override
	public int countBoards() {
		return tb_dao.countBoards();
	}

	@Override
	public int findBoard(MenteeBoardVO vo) {
		return tb_dao.findBoard(vo);
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public int insertMenteeBoard(MenteeBoardVO vo) {
		int row = 0;
		int fileGroupNum = file_dao.findFileGroup(vo.getId());
		row += tb_dao.insertMenteeBoard(vo);
		System.out.println("서비스에서 "+vo.toString());
		if (fileGroupNum != 0) {
			row += file_dao.update_TB_FileGroup(new FileGroupVO(fileGroupNum, tb_dao.findBoard(vo)));
			row += file_dao.insertBoard(vo.getId());
		}
		return row;
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public int modifyMenteeBoard(MenteeBoardVO vo) {
		int row = 0;
		// 먼저 임시파일로 되어있는 놈을 제대로 DB에 넣어준다.
		int fileGroupNum = file_dao.findFileGroup(vo.getId());
		row += tb_dao.modifyMenteeBoard(vo);
		if (fileGroupNum != 0) {
			row += file_dao.update_TB_FileGroup(new FileGroupVO(fileGroupNum, tb_dao.findBoard(vo)));
			row += file_dao.insertBoard(vo.getId());
		}
		// 제대로 들어 갔으면 FileGroupNum을 맞춰주어야 하므로 그 부분을 upadate하기 위해 작업한다.
		int fileGroupNumMin = file_dao.findFileGroupNumMin(vo.getTb_num());
		int fileGroupNumMax = file_dao.findFileGroupNumMax(vo.getTb_num());
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
			for (int i = 0; i < list.size(); i++) {
				if (list.get(i).getFile_num() == fileNum)
					continue;
				else if (i == list.size() - 1)
					file_dao.delete_FB_Files(list.get(i).getFile_num());
			}
		}
		return row;
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public int deleteMenteeBoard(int tb_num) {
		int row = 0;
		int fileGroupNum = file_dao.findFileGroupNumMax(tb_num);
		if (fileGroupNum != 0) {
			row += file_dao.deleteFile(fileGroupNum);
			row += file_dao.delete_TB_FileGroup(tb_num);
		}
		row += reply_dao.deleteReplies(tb_num);
		row += tb_dao.deleteMenteeBoard(tb_num);
		return row;
	}

}
