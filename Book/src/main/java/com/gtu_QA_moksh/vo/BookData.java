package com.gtu_QA_moksh.vo;

public class BookData {
	private double id;
	private double idOfUser;
	private String title;
	private String author;
	private String pubYear;
	private String additionalInfo;
	private	String bookCondition;
	private String address;
	
	public double getIdOfUser() {
		return idOfUser;
	}
	public void setIdOfUser(double idOfUser) {
		this.idOfUser = idOfUser;
	}
	public double getId() {
		return id;
	}
	public void setId(double id) {
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
