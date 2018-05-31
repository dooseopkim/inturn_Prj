package com.inturn.biz.users.dao;

import java.util.List;

import com.inturn.biz.users.vo.CareerVO;
import com.inturn.biz.users.vo.JobVO;

public interface JobDAO {
	public List<JobVO> getUserJob(String id);

	public int insertJob(JobVO vo);

	public int modifyJob(JobVO vo);

	public int deleteJob(int job_num);
	
	public JobVO getJob(int job_num);
}
