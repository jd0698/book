<%@page import="com.bookExchange.model.BookDataVO"%>
<%@page import="com.bookExchange.model.UserDataVO"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Update Your Book Data</title>
</head>
<body>

	<br>
	<form action="homePage">
		<input type="hidden" name="pageKey" value="ShowAllBooks"/>
		<input type="submit" value="Home Page"/>
	</form>
	<br><br>
	
<form:form action="updateBookData" method="post" modelAttribute="bookDataUpdateForm">
	<input type="hidden" name="pageKey" value="UploadBookData"/>
	<form:hidden path="idOfUser"/>
	<form:hidden path="id"/>
	<table>
		<tr>
			<td><form:label path="title">Enter Title:</form:label></td>
			<td><form:input path="title"/></td>
		</tr>
		<tr>
			<td><form:label path="author">Enter Name of Author:</form:label></td>
			<td><form:input path="author"/></td>
		</tr>
		<tr>
			<td><form:label path="pubYear">Publication Year:</form:label></td>
			<td><form:input path="pubYear"/></td>
		</tr>
		<tr>
			<td><form:label path="additionalInfo">Additional Info:</form:label></td>
			<td><form:textarea path="additionalInfo" rows="10" cols="30"></form:textarea></td>
		</tr>
		<tr>
			<td><form:label path="bookCondition">Book Condition:</form:label></td>
			<td>
				<form:radiobutton path="bookCondition" value="Fine"/>Fine
               	<form:radiobutton path="bookCondition" value="As New"/>As New
               	<form:radiobutton path="bookCondition" value="Good"/>Good
               	<form:radiobutton path="bookCondition" value="Poor"/>Poor
            </td>
		</tr>
		<tr>
			<td><form:label path="address">Address:</form:label></td>
			<td><form:textarea path="address" rows="10" cols="30"></form:textarea></td>
		</tr>
		<tr>
			<td>
				<input type="submit" value="Submit"/>
				<input type="reset" value="Reset"/>
			</td>
		</tr>
	</table>
</form:form>

</body>
</html>