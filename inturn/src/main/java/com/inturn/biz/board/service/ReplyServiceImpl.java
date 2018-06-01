package com.inturn.biz.board.service;

import java.sql.Date;
import java.util.HashMap;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.inturn.biz.board.dao.ReplyDAO;
import com.inturn.biz.board.vo.ReplyVO;

@Service("ReplyService")
public class ReplyServiceImpl implements ReplyService {
	@Resource(name = "ReplyDAO")
	ReplyDAO dao;

	@Override
	public int insertFBReply(ReplyVO vo) {
		java.util.Date udate = new java.util.Date();
		Date regDate = new Date(udate.getTime());
		vo.setRegDate(regDate);
		return dao.insertFBReply(vo);
	}

	@Override
	@Transactional(propagation=Propagation.REQUIRED)
	public int insertFBReReply(ReplyVO vo) {
		int row = 0;
		row += dao.upPosition(dao.getPosition(vo.getParentNum()));
		row += dao.insertFBReReply(vo);
		return row;
	}

	@Override
	@Transactional(propagation=Propagation.REQUIRED)
	public HashMap<String, Object> getFBReplies(int page_num) {
		// 전체 게시판 개수를 가져옴
		int total_boards = dao.countReplies();
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
		// 결과값을 list에 넣는다.
		List<ReplyVO> list = dao.getFBReplies(map);
		// 총 페이지수가 몇개인지도 보내줘야 하므로 Map구조로 put해서 result를 return
		result.put("list", list);
		result.put("count_page", count_page);
		result.put("thisPage", page_num);
		return result;
	}

	@Override
	public int modifyReply(ReplyVO vo) {
		return dao.modifyReply(vo);
	}

	@Override
	public int upPosition(int position) {
		return dao.upPosition(position);
	}

	@Override
	public int downPosition(int position) {
		return dao.downPosition(position);
	}

	@Override
	@Transactional(propagation=Propagation.REQUIRED)
	public int deleteReply(int rp_num) {
		int row = 0;
		ReplyVO vo = dao.getReply(rp_num);
		row += dao.downPosition(vo.getPosition());
		row += dao.deleteReply(rp_num);
		return row;
	}
}
