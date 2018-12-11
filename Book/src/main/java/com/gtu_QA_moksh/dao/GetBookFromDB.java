package com.gtu_QA_moksh.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import com.gtu_QA_moksh.vo.BookData;

public class GetBookFromDB {
	private String url="jdbc:mysql://localhost/gtu_qa";
	private String user="root";
	private String pass="root";
	
	public ArrayList<BookData> getAllBooks(){		
		ArrayList<BookData> listOfAllBook = new ArrayList<BookData>();
		Connection con = null;
		Statement stm = null;
		ResultSet rs = null;
		String sql="select * from book_data";
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection(url, user, pass);
			stm = con.createStatement();
			rs = stm.executeQuery(sql);
			
			while(rs.next()) {
				BookData data = new BookData();
				data.setTitle(rs.getString("title"));
				data.setAuthor(rs.getString("author"));
				data.setPubYear(rs.getString("pubYear"));
				data.setAdditionalInfo(rs.getString("additionalInfo"));
				data.setBookCondition(rs.getString("bookCondition"));
				data.setAddress(rs.getString("address"));
				data.setId(rs.getDouble("id"));
				data.setIdOfUser(rs.getDouble("idOfUser"));
				
				listOfAllBook.add(data);
			}
			
		}catch (Exception e) {
			System.out.println("getAllBooks Method "+e);
		}
		
		return listOfAllBook;
	}
	
	public BookData getBookById(double bookId) {
		BookData data = new BookData();
		Connection con = null;
		Statement stm = null;
		ResultSet rs = null;
		String sql="select * from book_data where id="+bookId;
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection(url, user, pass);
			stm = con.createStatement();
			rs = stm.executeQuery(sql);
			
			while(rs.next()) {
				data.setTitle(rs.getString("title"));
				data.setAuthor(rs.getString("author"));
				data.setPubYear(rs.getString("pubYear"));
				data.setAdditionalInfo(rs.getString("additionalInfo"));
				data.setBookCondition(rs.getString("bookCondition"));
				data.setAddress(rs.getString("address"));
				data.setId(rs.getDouble("id"));
				data.setIdOfUser(rs.getDouble("idOfUser"));
			}
			
		}catch (Exception e) {
			System.out.println("getAllBooks Method "+e);
		}
		
		return data;
	}
}
