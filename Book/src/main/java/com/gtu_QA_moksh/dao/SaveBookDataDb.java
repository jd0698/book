package com.gtu_QA_moksh.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.gtu_QA_moksh.vo.BookData;

public class SaveBookDataDb {
	/* private String url="jdbc:mysql://localhost/bookexchange";
	private String user="root";
	private String password="root";*/
	public void saveBookData(BookData data) {
		/*Connection con=null;
		Statement stm=null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection(url, user, password);
			stm = con.createStatement();
			String sql = "insert into book_data (title,author,pubYear,additionalInfo,bookCondition,address,idOfUser)" +
						 "values ('"+data.getTitle()+"','"+data.getAuthor()+"', '"+data.getPubYear()+"', '"+data.getAdditionalInfo()+"' , '"+data.getBookCondition()+"' , '"+data.getAddress()+"' , "+data.getIdOfUser()+");" ;
			stm.execute(sql);
		}catch (SQLException e ) {
			System.out.println("saveBookData method"+ e);
		}catch (ClassNotFoundException e) {
			System.out.println("saveBookData method"+ e);
		}finally {
			try {
				stm.close();
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}*/
	Configuration con = new Configuration().configure().addAnnotatedClass(BookData.class);
	SessionFactory sf = con.buildSessionFactory();
	Session session = sf.openSession();
	Transaction transaction = session.beginTransaction();
	session.save(data);
	transaction.commit();
	}
}
