package com.gtu_QA_moksh.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;


import com.gtu_QA_moksh.vo.BookData;

public class GetBookFromDB {
	private String url="jdbc:mysql://localhost/bookexchange";
	private String user="root";
	private String pass="root";
	
	public ArrayList<BookData> getAllBooks() {		
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
		}finally {
			try {
				rs.close();
				stm.close();
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		return listOfAllBook;
	}
	
	public BookData getBookById(double bookId) {      // when more Info is clicked
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
	}
	
	public ArrayList<BookData> getAllBooksOfUser(double userId){
		ArrayList<BookData> allBooksOfUser = new ArrayList<BookData>();
		Connection connection = null;
		Statement statement = null;
		ResultSet resultSet = null;
		String sql="select * from book_data where idOfUser="+userId;
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			connection = DriverManager.getConnection(url, user, pass);
			statement = connection.createStatement();
			resultSet = statement.executeQuery(sql);
			
			while(resultSet.next()) {
				BookData data = new BookData();
				data.setTitle(resultSet.getString("title"));
				data.setAuthor(resultSet.getString("author"));
				data.setPubYear(resultSet.getString("pubYear"));
				data.setAdditionalInfo(resultSet.getString("additionalInfo"));
				data.setBookCondition(resultSet.getString("bookCondition"));
				data.setAddress(resultSet.getString("address"));
				data.setId(resultSet.getDouble("id"));
				data.setIdOfUser(resultSet.getDouble("idOfUser"));
				
				allBooksOfUser.add(data);
			}
			
		}catch (Exception e) {
			System.out.println("getAllBooks Method "+e);
		}finally {
			try {
				resultSet.close();
				statement.close();
				connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		return allBooksOfUser;
	}
	
	public void removeBookById(double bookId){
		Connection connection = null;
		Statement statement = null;
		String sql="Delete from book_data where id="+bookId;
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			connection = DriverManager.getConnection(url, user, pass);
			statement = connection.createStatement();
			statement.executeUpdate(sql);
			
		}catch (Exception e) {
			System.out.println("removeBookById Method "+e);
		}finally {
			try {
				statement.close();
				connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
}
