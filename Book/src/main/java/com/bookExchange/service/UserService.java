package com.bookExchange.service;

import com.bookExchange.dao.UserDAO;
import com.bookExchange.model.UserDataVO;

public class UserService {
	public void registerUser(UserDataVO data) {
		UserDAO UserDAO = new UserDAO();
		UserDAO.registerUser(data);
	}

	public UserDataVO verifyUser(UserDataVO userData) {
		UserDAO userDAO = new UserDAO();
		UserDataVO data = userDAO.verifyUser(userData);
		return data;
	}
}
