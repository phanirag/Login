package com.app.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.dao.IUserModelDao;
import com.app.model.UserModel;
import com.app.service.IUserModelService;

@Service
public class UserModelService implements IUserModelService{

	@Autowired
	private IUserModelDao dao;
	
	@Override
	public int addUserModel(UserModel usermodel) {
		return dao.addUserModel(usermodel);
	}
	
	@Override
	public UserModel login(String name, String password) {
		return dao.login(name,password);
	}

	
}
