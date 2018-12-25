<%@page import="com.bookExchange.model.BookDataVO"%>
<%@page import="java.util.ArrayList"%>
<%@taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" isELIgnored="false"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>All Books</title>
<style>
table {
  font-family: arial, sans-serif;
  border-collapse: collapse;
  width: 100%;
}

td, th {
  border: 1px solid #dddddd;
  text-align: left;
  padding: 8px;
}

tr:nth-child(even) {
  background-color: #dddddd;
}
</style>
</head>
<body>
	<br>
	<form action="homePage">
		<input type="submit" value="Home Page"/>
	</form>
	<br><br>
	<c:choose>
		<c:when test="empty ${requestScope.listOfAllBooks}">
			No Books!!
		</c:when>
		<c:otherwise>
			<table>
				<tr>
			    	<th>Title</th>
			    	<th>pubYear</th>
			    	<th>...</th>
			  	</tr>
			<c:forEach items="${requestScope.listOfAllBooks}" var="book">
				<tr>
				    <td>${book.title}</td>
				    <td>${book.pubYear}</td>
				    <td>
				    	<form action="ShowBookInfo">
				    		<input type="hidden" name="idOfBook" value="${book.id}"/>
				    		<input type="submit" value="More Info"/>
				    	</form>
				    </td>
				</tr>
			</c:forEach>  	
			</table>
		</c:otherwise>
	</c:choose>
</body>
</html>