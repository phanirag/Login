package com.app.service;

import com.app.model.UserModel;

public interface IUserModelService {

	int addUserModel(UserModel userModel);

	UserModel login(String name, String password);
}
