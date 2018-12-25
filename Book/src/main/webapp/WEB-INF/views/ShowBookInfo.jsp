<%@page import="com.bookExchange.model.BookDataVO"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" isELIgnored="false"%>
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
	<br>
	<form action="homePage">
<!-- 		<input type="hidden" name="pageKey" value="showBookInfo"/> -->
    	<input type="submit" value="Home Page" />
	</form>
	<br><br><br>
		
	<table style="width:60%">
  		<tr>
    		<th>Title:</th>
    		<td>${requestScope.bookDetails.title}</td>
  		</tr>
  		<tr>
    		<th>Author:</th>
    		<td>${requestScope.bookDetails.author}</td>
  		</tr>
  		<tr>
    		<th>Publication Year:</th>
    		<td>${requestScope.bookDetails.pubYear}</td>
  		</tr>
  		<tr>
    		<th>Book Condition:</th>
    		<td>${requestScope.bookDetails.bookCondition}</td>
  		</tr>
  		<tr>
    		<th>Additional Info:</th>
    		<td>${requestScope.bookDetails.additionalInfo}</td>
  		</tr>
  		<tr>
    		<th>Available @</th>
    		<td>${requestScope.bookDetails.address}</td>
  		</tr>
	</table>
	
</body>
</html>