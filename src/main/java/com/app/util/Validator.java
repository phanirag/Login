package com.app.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.app.model.UserModel;

@Component
public class Validator {
	
	@Autowired
	private CoDecUtil codec;
	
	public boolean isPwdAndTokenValid(String reqPwd,UserModel user){
		boolean flag=false;
		
		//Get enCoded password from DB
		String enPwd=user.getPassword();
		
		//Decode Pwd
		String dbPwd=codec.genetareDecode(enPwd);

		//Compare decoded values with requested Pwd and Token
		flag=reqPwd.equals(dbPwd);
		
		return flag;
	}
}
