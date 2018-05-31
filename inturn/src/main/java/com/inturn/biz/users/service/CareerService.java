package com.inturn.biz.users.service;

import java.util.List;

import com.inturn.biz.users.vo.CareerVO;

public interface CareerService {
	public List<CareerVO> getUserCareer(String id);

	public int insertCareer(CareerVO vo);

	public int modifyCareer(CareerVO vo);

	public int deleteCareer(int num);

	public CareerVO getCareer(int num);
}
