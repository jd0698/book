package com.bookExchange.service;

import com.bookExchange.dao.AdminDAO;
import com.bookExchange.model.AdminDataVO;

public class AdminService {
	public boolean verifyAdmin(AdminDataVO adminData) {
		AdminDAO adminDAO = new AdminDAO();
		boolean isAdmin = adminDAO.verifyAdmin(adminData);
		if(isAdmin){
			return true;
		}
		return false;
	}
}