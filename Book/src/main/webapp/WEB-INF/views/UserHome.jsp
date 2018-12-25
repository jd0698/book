<%@page import="com.bookExchange.model.UserDataVO"%>
<%@taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>UserHome</title>
</head>
<body> 
		<%  //String pageKey = (String)session.getAttribute("pageKey");
			//session.removeAttribute("pageKey");
			//System.out.println("PAGE KEY ::: " + pageKey);
			//UserDataVO userDataVO  = (UserDataVO)session.getAttribute("userData");
			//System.out.println("PAGE KEY ::: " + userDataVO);
		%>
		Welcome	${sessionScope.userData.firstName}  ${sessionScope.userData.lastName}
		<br><br><br><br>
		<form action="uploadBook">
    		<input type="submit" value="Upload Book" />
		</form>
		<form action="manageMyBooks">
    		<input type="submit" value="Manage My Book" />
		</form>
		<form action="showAllBooks">
    		<input type="submit" value="showAllBooks" />
		</form>
		<br><br><br>
		<form action="logout">
    		<input type="submit" value="log Out" />
		</form>
</body>
</html>