<%@page import="com.gtu_QA_moksh.vo.BookData"%>
<%@page import="com.gtu_QA_moksh.vo.UserData"%>
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
	
<%-- <form action="saveBookData" method="post"> --%>
<!-- 	<input type="hidden" name="pageKey" value="UploadBook"/> -->
<%-- 	<input type="hidden" name="idOfUser" value="<%=userData.getId()%>"/> --%>
<%-- 	Enter Title:<input type="text" name="bookTitle" value=<%=bookData.getTitle()%>/><br> --%>
<!-- 	Enter Name of Author:<input type="text" name="authorName"><br> -->
<!-- 	Publication Year:<input type="text" name="pubYear"><br> -->
<!-- 	Additional Info:<textarea name="additionalInfo" rows="10" cols="30"></textarea><br> -->
<!-- 	Book Condition:<input type="radio" name="bookCondition" value="Fine" checked> Fine  -->
<!--   					<input type="radio" name="bookCondition" value="As New"> As New  -->
<!--   					<input type="radio" name="bookCondition" value="Good"> Good  -->
<!-- 					<input type="radio" name="bookCondition" value="Poor"> Poor<br> -->
<!-- 	Address:<textarea name="address" rows="4" cols="20"></textarea><br> -->
<!-- 	<input type="reset"/> -->
<!-- 	<input type="submit" value="Submit"/> -->
<%-- </form> --%>

<!-- <br><br><br><br> -->

<form:form action="saveBookData" method="post" modelAttribute="bookData">
	<input type="hidden" name="pageKey" value="UploadBookData"/>
	<form:hidden path="idOfUser"/>
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