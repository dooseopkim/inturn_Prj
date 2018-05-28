package com.inturn.biz.board.service;

import java.util.HashMap;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.inturn.biz.board.dao.FileDAO;
import com.inturn.biz.board.dao.FreeBoardDAO;
import com.inturn.biz.board.vo.FileGroupVO;
import com.inturn.biz.board.vo.FreeBoardVO;

/**
 * 
 * @author 박현호
 * @version 1.0
 * @since 2018.05.28
 * @see 자유게시판 관련 서비스 함수
 */
@Service("FreeBoardService")
public class FreeBoardServiceImpl implements FreeBoardService{
	@Resource(name="FreeBoardDAO")
	FreeBoardDAO fb_dao;
	@Resource(name="FileDAO")
	FileDAO file_dao;
	
	/**
	 * @param FreeBoardVO로 받아서 관련된 임시저장파일과 게시글 정보를 통해 DB에 저장
	 */
	@Override
	@Transactional(propagation=Propagation.REQUIRED)
	public int insertFreeBoard(FreeBoardVO vo) {
		int row = 0;
		int fileGroupNum = file_dao.findFileGroup(vo.getId());
		row += fb_dao.insertFreeBoard(vo);
		row += file_dao.insert_FB_files(new FileGroupVO(fileGroupNum,fb_dao.findBoard(vo)));
		row += file_dao.insertBoard(vo.getId());
		return row;
	}

	/**
	 * @param 임시저장된 상태의 파일정보를 가져오고, 새로입력 된 파일들의 정보를 가져온다.
	 * 
	 */
	@Override
	@Transactional(propagation=Propagation.REQUIRED)
	public int modifyFreeBoard(FreeBoardVO vo) {
		return fb_dao.modifyFreeBoard(vo);
	}
	
	/**
	 * @param fb_num을 통해 해당 게시글에 저장된 파일을 모두 삭제 후 게시글 삭제
	 */
	@Override
	@Transactional(propagation=Propagation.REQUIRED)
	public int deleteFreeBoard(int fb_num) {
		int row = 0;
		int fileGroupNum = file_dao.findFileGroupNum(fb_num);
		if(fileGroupNum != 0) {
			row += file_dao.deleteFile(fileGroupNum);
			row += file_dao.delete_FB_Files(fb_num);
		}
		row += fb_dao.deleteFreeBoard(fb_num);
		return row;
	}

	/**
	 * @param id, content, title을 통해 찾고자 하는 게시글을 찾는 함수
	 * insertBoard에서 FilGroup을 설정할 때, 막 입력한 게시글의 번호를 가져오기 위해 사용한다.
	 */
	@Override
	public int findBoard(FreeBoardVO vo) {
		return fb_dao.findBoard(vo);
	}
	
	/**
	 * @param page_num 게시판 목록에서 현재 보고있는 페이지
	 * 게시판 목록을 반환하는 함수
	 */
	@Override
	@Transactional(propagation=Propagation.REQUIRED)
	public HashMap<String,Object> boardList(int page_num) {
		// 전체 게시판 개수를 가져옴
		int total_boards = fb_dao.countBoards();
		// 게시판을 10개씩 페이징 처리했을 때, 총 몇개의 목록이 나오는지 계산
		int count_page = (total_boards + 9) / 10;
		// 만약 마지막 페이지의 게시글이 1개 인데 삭제된 경우
		if(count_page < page_num)
			page_num--;
		// 마지막 페이지의 개수를 계산
		int reminder = total_boards % 10;
		if(reminder == 0)
			reminder = 10;
		// 클릭한 해당 페이지의 처음 번호와, 마지막번호를 계산
		int limit = (count_page - page_num)*10 + reminder;	// 마지막번호
		int offset = (count_page - (page_num + 1))*10 + reminder;	// 첫 번호
		// 결과를 계산, 반환하기 위한 Map 정의
		HashMap<String, Integer> map = new HashMap<String, Integer>();
		HashMap<String, Object> result = new HashMap<String, Object>();

		if(offset < 0) offset = 0;	// 마지막 페이지일 경우 음수 값이 되므로 첫 번호를 0으로 만들어줌
		result.put("limit", limit + 1);	// 미리 게시판 번호의 수를 넣어놓는다.
		limit -= offset;	// 마지막과 첫 번호의 차를 구해 가져올 개수를 구함
		map.put("offset", offset);	// 계시판 페이징의 시작 게시판 번호 값
		map.put("limit", limit); // 시작번호로 부터 몇개를 가져올지 계산한 값을 넣는다.
		// 결과값을 list에 넣는다.
		List<FreeBoardVO> list = fb_dao.boardList(map);
		// 총 페이지수가 몇개인지도 보내줘야 하므로 Map구조로 put해서 result를 return
		result.put("list", list);
		result.put("count_page",count_page);
		result.put("thisPage",page_num);
		return result;
	}

	/**
	 * 현재 게시글이 몇개가 있는지 파악하기 위해 쓰는 함수
	 * 페이징 처리를 위해 사용한다.
	 */
	@Override
	public int countBoards() {
		return fb_dao.countBoards();
	}

	/**
	 * @param 현재 게시판 번호를 통해 게시판의 정보를 담아 반환하는 함수
	 */
	@Override
	@Transactional(propagation=Propagation.REQUIRED)
	public HashMap<String, Object> viewBoard(int fb_num) {
		fb_dao.countUp(fb_num);
		HashMap<String, Object> result = new HashMap<String, Object>();
		FreeBoardVO vo = fb_dao.viewBoard(fb_num);
		//여기에 이제, 댓글도 result에 put해서 보내주어야함.
		result.put("board", vo);
		result.put("prevfb_num", fb_dao.prevfb_num(fb_num));
		result.put("nextfb_num", fb_dao.nextfb_num(fb_num));
		return result;
	}
}
