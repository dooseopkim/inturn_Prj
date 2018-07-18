package com.inturn.biz.board.dao;

import java.util.HashMap;
import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.inturn.biz.board.vo.MenteeBoardVO;
/**
 * 
 * @author youngseo
 * @since 2018.07.17
 *
 */
@Repository("MenteeBoardDAO")
public class MenteeBoardDAOImple implements MenteeBoardDAO{

	@Autowired
	SqlSessionTemplate mybatis;
	
	@Override
	public List<MenteeBoardVO> boardList(HashMap<String, Integer> map) {
		return mybatis.selectList("MenteeBoardMapper.boardList", map);
	}

	@Override
	public List<MenteeBoardVO> scBoardList(HashMap<String, Object> map) {
		return mybatis.selectList("MenteeBoardMapper.scBoardList", map);
	}

	@Override
	public MenteeBoardVO viewBoard(int tb_num) {
		return mybatis.selectOne("MenteeBoardMapper.viewBoard", tb_num);
	}

	@Override
	public int countBoards() {
		return mybatis.selectOne("MenteeBoardMapper.countBoards");
	}

	@Override
	public int scCountBoards(String condition, String search) {
		HashMap<String, String> map = new HashMap<String, String>();
		map.put("condition", condition);
		map.put("search",search);
		return mybatis.selectOne("MenteeBoardMapper.scCountBoards", map);
	}

	@Override
	public int findBoard(MenteeBoardVO vo) {
		return mybatis.selectOne("MenteeBoardMapper.findBoard", vo);
	}

	@Override
	public int insertMenteeBoard(MenteeBoardVO vo) {
		System.out.println("디에이오에서 "+vo.toString());
		return mybatis.insert("MenteeBoardMapper.insertMenteeBoard", vo);
	}

	@Override
	public int modifyMenteeBoard(MenteeBoardVO vo) {
		return mybatis.update("MenteeBoardMapper.modifyMenteeBoard",vo);
	}

	@Override
	public int deleteMenteeBoard(int tb_num) {
		return mybatis.delete("MenteeBoardMapper.deleteMenteeBoard", tb_num);
	}

	@Override
	public int countUp(int tb_num) {
		return mybatis.update("MenteeBoardMapper.countUp",tb_num);
	}

	@Override
	public int prevtb_num(int tb_num) {
		return mybatis.selectOne("MenteeBoardMapper.prevtb_num", tb_num);
	}

	@Override
	public int nexttb_num(int tb_num) {
		return mybatis.selectOne("MenteeBoardMapper.nexttb_num", tb_num);
	}

	@Override
	public int scPrevtb_num(String condition, String search, int tb_num) {
		HashMap<String, Object> map = new HashMap<String, Object>();
		map.put("condition", condition);
		map.put("search", search);
		map.put("tb_num", tb_num);
		return mybatis.selectOne("MenteeBoardMapper.scPrevtb_num", map);
	}

	@Override
	public int scNexttb_num(String condition, String search, int tb_num) {
		HashMap<String, Object> map = new HashMap<String, Object>();
		map.put("condition", condition);
		map.put("search", search);
		map.put("tb_num", tb_num);
		return mybatis.selectOne("MenteeBoardMapper.scNexttb_num", map);
	}

}
