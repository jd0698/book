package com.gtu_QA_moksh.service;

import com.gtu_QA_moksh.dao.VerifyDB;
import com.gtu_QA_moksh.vo.AdminData;
import com.gtu_QA_moksh.vo.UserData;

public class LoginService {
	public boolean verify(AdminData adminData) {
		
		VerifyDB verifyDB = new VerifyDB();
		boolean isAdmin = verifyDB.verify(adminData);
		
		if(isAdmin){
			return true;
		}
		return false;
	}
	
	public UserData verify(UserData userData) {
		VerifyDB verifyDB = new VerifyDB();
		UserData data = verifyDB.verify(userData);
		return data;
	}
}