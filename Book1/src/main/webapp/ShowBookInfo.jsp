<%@page import="com.gtu_QA_moksh.vo.BookData"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Book Details</title>
<style>
table, th, td {
  border: 1px solid black;
  border-collapse: collapse;
}
th, td {
  padding: 5px;
  text-align: left;
}
</style>
</head>
<body>
	<% BookData bookData = (BookData)request.getAttribute("bookDetails");%>
		
		
	<table style="width:60%">
  		<tr>
    		<th>Title:</th>
    		<td><%=bookData.getTitle()%></td>
  		</tr>
  		<tr>
    		<th>Author:</th>
    		<td><%=bookData.getAuthor()%></td>
  		</tr>
  		<tr>
    		<th>Publication Year:</th>
    		<td><%=bookData.getPubYear()%></td>
  		</tr>
  		<tr>
    		<th>Book Condition:</th>
    		<td><%=bookData.getBookCondition()%></td>
  		</tr>
  		<tr>
    		<th>Additional Info:</th>
    		<td><%=bookData.getAdditionalInfo()%></td>
  		</tr>
  		<tr>
    		<th>Available @</th>
    		<td><%=bookData.getAddress()%></td>
  		</tr>
	</table>
	<br><br><br><br>
	<form action="homePage">
    	<input type="submit" value="Home Page" />
	</form>
	
</body>
</html>