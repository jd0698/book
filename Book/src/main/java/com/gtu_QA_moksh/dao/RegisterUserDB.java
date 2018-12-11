package com.gtu_QA_moksh.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

import com.gtu_QA_moksh.vo.UserData;

public class RegisterUserDB {
	
	String url="jdbc:mysql://localhost/gtu_qa";
	String user="root";
	String password="root";
	public void registerUser(UserData data) {
		Connection  con=null;
		Statement stm=null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection(url, user, password);
			stm = con.createStatement();
			String sql = "INSERT INTO "
					+ "user_data (firstName, lastName, email, number, password)" + 
					"VALUES ('"+data.getFirstName()+"', '"+data.getLastName()+"', '"+data.getEmail()+"', "+data.getNumber()+", '"+data.getPassword()+"');";
			stm.execute(sql);
		}catch(Exception e) {
			System.out.println("dao registerUser method "+e);
		}
	}
}
