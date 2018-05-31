package com.inturn.biz.users.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.inturn.biz.users.dao.CareerDAO;
import com.inturn.biz.users.vo.CareerVO;

@Service("CareerService")
public class CareerServiceImpl implements CareerService{
	@Resource(name="CareerDAO")
	CareerDAO dao;

	@Override
	public List<CareerVO> getUserCareer(String id) {
		return dao.getUserCareer(id);
	}

	@Override
	public int insertCareer(CareerVO vo) {
		return dao.insertCareer(vo);
	}

	@Override
	public int modifyCareer(CareerVO vo) {
		return dao.modifyCareer(vo);
	}

	@Override
	public int deleteCareer(int num) {
		return dao.deleteCareer(num);
	}

	@Override
	public CareerVO getCareer(int num) {
		return dao.getCareer(num);
	}
}
