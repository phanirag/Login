package com.app.dao;

import com.app.model.UserModel;

public interface IUserModelDao {

	int addUserModel(UserModel usermodel);

	UserModel login(String name, String password);
	
}
