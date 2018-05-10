package com.intrun.biz.users.service;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.inturn.biz.users.dao.CareerDAO;

@Service("CareerService")
public class CareerServiceImpl implements CareerService{
	@Resource(name="CareerDAO")
	CareerDAO dao;
}
