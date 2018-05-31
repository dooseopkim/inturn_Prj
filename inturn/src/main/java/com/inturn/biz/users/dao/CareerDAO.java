package com.inturn.biz.users.dao;

import java.util.List;

import com.inturn.biz.users.vo.CareerVO;
import com.inturn.biz.users.vo.EducationalLevelVO;

public interface CareerDAO {
	public List<CareerVO> getUserCareer(String id);

	public int insertCareer(CareerVO vo);

	public int modifyCareer(CareerVO vo);

	public int deleteCareer(int num);

	public CareerVO getCareer(int num);
}
