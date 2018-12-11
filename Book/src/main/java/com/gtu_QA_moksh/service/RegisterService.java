package com.gtu_QA_moksh.service;

import com.gtu_QA_moksh.dao.RegisterUserDB;
import com.gtu_QA_moksh.vo.UserData;

public class RegisterService {

	public void registerUser(UserData data) {
		
		RegisterUserDB db = new RegisterUserDB();
		db.registerUser(data);
		
	}
}
