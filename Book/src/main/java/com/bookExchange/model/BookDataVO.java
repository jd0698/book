package com.bookExchange.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="book_data")
public class BookDataVO {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	private int idOfUser;
	private String title;
	private String author;
	private String pubYear;
	private String additionalInfo;
	private	String bookCondition;
	private String address;
	
	public int getIdOfUser() {
		return idOfUser;
	}
	public void setIdOfUser(int idOfUser) {
		this.idOfUser = idOfUser;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public String getPubYear() {
		return pubYear;
	}
	public void setPubYear(String pubYear) {
		this.pubYear = pubYear;
	}
	public String getAdditionalInfo() {
		return additionalInfo;
	}
	public void setAdditionalInfo(String additionalInfo) {
		this.additionalInfo = additionalInfo;
	}
	public String getAddress() {
		return address;
	}
	public String getBookCondition() {
		return bookCondition;
	}
	public void setBookCondition(String bookCondition) {
		this.bookCondition = bookCondition;
	}
	public void setAddress(String address) {
		this.address = address;
	}
}
