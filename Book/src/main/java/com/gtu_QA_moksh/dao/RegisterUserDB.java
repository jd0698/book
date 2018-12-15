package com.gtu_QA_moksh.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.gtu_QA_moksh.vo.UserData;

public class RegisterUserDB {
	
	/*String url="jdbc:mysql://localhost/bookexchange";
	String user="root";
	String password="root";*/
	public void registerUser(UserData data) {
		/*Connection  con=null;
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
		}finally {
			try {
				stm.close();
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}*/
		Configuration con = new Configuration().configure().addAnnotatedClass(UserData.class);
		SessionFactory sf = con.buildSessionFactory();
		Session session = sf.openSession();
		Transaction transaction = session.beginTransaction();
		session.save(data);
		transaction.commit();
	}
}
