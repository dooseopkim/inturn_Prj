package com.inturn.biz.users.dao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.inturn.biz.users.vo.JobVO;

@Repository("JobDAO")
public class JobDAOImpl implements JobDAO{
	@Autowired
	SqlSessionTemplate mybatis;

	@Override
	public List<JobVO> getUserJob(String id) {
		return mybatis.selectList("ProfileMapper.getUserJob",id);
	}

	@Override
	public int insertJob(JobVO vo) {
		int row = mybatis.insert("ProfileMapper.insertJob",vo);
		return row;
	}

	@Override
	public int modifyJob(JobVO vo) {
		int row = mybatis.update("ProfileMapper.modifyJob",vo);
		return row;
	}

	@Override
	public int deleteJob(int job_num) {
		int row = mybatis.delete("ProfileMapper.deleteJob", job_num);
		return row;
	}

	@Override
	public JobVO getJob(int job_num) {
		return mybatis.selectOne("ProfileMapper.getJob", job_num);
	}
}	