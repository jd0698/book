package com.gtu_QA_moksh.dao;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import java.sql.Connection;

import com.gtu_QA_moksh.vo.AdminData;
import com.gtu_QA_moksh.vo.BookData;
import com.gtu_QA_moksh.vo.UserData;

public class VerifyDB {
	
	/*
	String url="jdbc:mysql://localhost/bookexchange";
	String user="root";
	String password="root";
	*/	
	
	public boolean verify(AdminData adminData) {
		boolean verify=false;
		
		/*
		Connection  con=null;
		Statement stm=null;
		ResultSet rs=null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection(url, user, password);
			stm = con.createStatement();
			String sql = "SELECT * FROM ADMIN_DATA where USER_NAME='"+adminData.getUserName()+"' and password='"+adminData.getPassword()+"'";
			rs = stm.executeQuery(sql);
			
			if(rs.next()) {
				System.out.println(rs.getString("id"));
				verify=true;	
			}
		}catch(Exception e) {
			System.out.println("dao verify method "+e);
		}finally {
			try {
				rs.close();
				stm.close();
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		*/
		
		return verify;
	}
	
	
	public UserData verify(UserData userData) {
		UserData user = null;
		Configuration con = new Configuration().configure().addAnnotatedClass(UserData.class);
		SessionFactory sf = con.buildSessionFactory();
		Session session = sf.openSession();
		Transaction tran = session.beginTransaction();
		Query query = session.createQuery("FROM UserData WHERE email='"+userData.getEmail()+"' and password='"+userData.getPassword()+"'");
		ArrayList<UserData> list = (ArrayList<UserData>)query.list();
		if(!list.isEmpty()) {
			user = list.get(0);
		}
		tran.commit();
		session.close();
		
		return user;
		/*
		//boolean verify=false;
		
		Connection  con=null;
		Statement stm=null;
		ResultSet rs=null;
		UserData data=null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection(url,user,password);
			stm = con.createStatement();
			String sql = "SELECT * FROM USER_DATA where email='"+userData.getEmail()+"' and password='"+userData.getPassword()+"'";
			rs = stm.executeQuery(sql);
			
			if(rs.next()) {
				data = new UserData();
				data.setFirstName(rs.getString("firstName"));
				data.setLastName(rs.getString("lastName"));
				data.setId(rs.getInt("id"));
				data.setEmail(rs.getString("email"));
				data.setNumber(rs.getLong("number"));
				
				System.out.println(rs.getString("id"));
				//verify=true;	
			}
		}catch(Exception e) {
			System.out.println("dao verify method "+e);
		}finally {
			try {
				rs.close();
				stm.close();
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return data;
		*/
	}
}
