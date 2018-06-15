package com.inturn.biz.board.service;

import java.util.HashMap;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.inturn.biz.board.dao.CsBoardDAO;
import com.inturn.biz.board.vo.CsBoardVO;
import com.inturn.biz.board.vo.FreeBoardVO;

@Service("CsBoardService")
public class CsBoardServiceImpl implements CsBoardService{
	@Resource(name="CsBoardDAO")
	CsBoardDAO cs_dao;

	/**
	 * @param page_num
	 *            게시판 목록에서 현재 보고있는 페이지 게시판 목록을 반환하는 함수
	 */
	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public HashMap<String, Object> boardList(int page_num) {
		// 전체 게시판 개수를 가져옴
		int total_boards = cs_dao.countBoards();
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
		List<CsBoardVO> list = cs_dao.boardList(map);
		// 총 페이지수가 몇개인지도 보내줘야 하므로 Map구조로 put해서 result를 return
		result.put("list", list);
		result.put("count_page", count_page);
		result.put("thisPage", page_num);
		return result;
	}

	@Override
	public HashMap<String, Object> scBoardList(String condition, String search, int page_num) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public HashMap<String, Object> viewBoard(int cs_num) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public HashMap<String, Object> scViewBoard(String condition, String search, int cs_num) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int countBoards() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int findBoard(CsBoardVO vo) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int insertCsBoard(CsBoardVO vo) {
		System.out.println("insertCsBoard 서비스임플 거쳐가여");
		return cs_dao.insertCsBoard(vo);
	}

	@Override
	public int modifyCsBoard(CsBoardVO vo) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int deleteCsBoard(int cs_num) {
		// TODO Auto-generated method stub
		return 0;
	}
	
}
