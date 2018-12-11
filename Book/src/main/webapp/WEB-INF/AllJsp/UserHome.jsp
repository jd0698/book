<%@page import="com.gtu_QA_moksh.vo.UserData"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>UserHome</title>
</head>
<body>
		<%  String pageKey = (String)request.getParameter("pageKey");
			//System.out.println(pageKey);
			UserData userData = null;
			if(pageKey.equals("UserLoginRegister")){
				userData = (UserData)request.getAttribute("userData");
				session.setAttribute("userData", userData);
			}else{
				userData = (UserData)session.getAttribute("userData");
			}
		%>
		
		<%="Welcome  "+userData.getFirstName()+" "+userData.getLastName()%>
		<br><br><br><br>
		<form action="uploadBook" method="post">
    		<input type="submit" value="Upload Book" />
		</form>
		<form action="manageMyBooks" method="post">
    		<input type="submit" value="Manage My Book" />
		</form>
		<form action="showAllBooks">
    		<input type="submit" value="showAllBooks" />
		</form>
</body>
</html>