package com.inturn.biz.users.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.inturn.biz.users.dao.JobDAO;
import com.inturn.biz.users.vo.JobVO;

@Service("JobService")
public class JobServiceImpl implements JobService{
	@Resource(name="JobDAO")
	JobDAO dao;

	@Override
	public List<JobVO> getUserJob(String id) {
		return dao.getUserJob(id);
	}

	@Override
	public int insertJob(JobVO vo) {
		return dao.insertJob(vo);
	}

	@Override
	public int modifyJob(JobVO vo) {
		return dao.modifyJob(vo);
	}

	@Override
	public int deleteJob(int job_num) {
		return dao.deleteJob(job_num);
	}

	@Override
	public JobVO getJob(int job_num) {
		return dao.getJob(job_num);
	}

}
