<%@page import="com.bookExchange.model.UserDataVO"%>
<%@taglib prefix="f" uri="http://www.springframework.org/tags/form"%>
<%@taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" isELIgnored="false"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Upload Book</title>
</head>
<body>

	<br>
	<form action="homePage">
<!-- 		<input type="hidden" name="pageKey" value="UploadBook"/> -->
		<input type="submit" value="Home Page"/>
	</form>
	<br><br>
	<f:form action="saveBookData" method="post" modelAttribute="bookDataForm">
<!-- 		<input type="hidden" name="pageKey" value="UploadBook"/> -->
		<f:hidden path="idOfUser" value="${sessionScope.userData.id}"/>
		<table>
			<tr>
				<td>Enter Title:</td>
				<td><f:input path="title"/></td>
			</tr>
			<tr>
				<td>Enter Name of Author:</td>
				<td><f:input path="author"/></td>
			</tr>
			<tr>
				<td>Additional Info:</td>
				<td><f:textarea path="additionalInfo" rows="10" cpls="30"/></td>
			</tr>
			<tr>
				<td>Publication Year:</td>
				<td><f:input path="pubYear"/></td>
			</tr>
			<tr>
				<td>Book Condition:</td>
				<td>
					<f:radiobutton path="bookCondition" value="Fine"/>Fine
					<f:radiobutton path="bookCondition" value="As New"/>As New
					<f:radiobutton path="bookCondition" value="Good"/>Good
					<f:radiobutton path="bookCondition" value="Poor"/>Poor
				</td>
			</tr>
			<tr>
				<td>Address:</td>
				<td><f:textarea path="address" rows="4" cols="20"></f:textarea></td>
			</tr>
			<tr>
				<td>
					<input type="reset" value="Reset"/>
					<input type="submit" value="Submit"/>
				</td>
			</tr>
		</table>
	</f:form>

</body>
</html>