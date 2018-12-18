<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="f" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Book Exchange.com</title>
</head>
<body>
<form action="verifyUser" method="post">
<input type="hidden" name="pageKey" value="UserLoginRegister"/>
Enter email:<input type="text" name="email"></input><br>
Enter password:<input type="password" name="password"></input><br>
<input type="submit" value="Log In"></input>
</form>

<br><br><br><br><br><br> 

<%-- <form action="registerUser" method="post"> --%>
<!-- <!-- <input type="hidden" name="pageKey" value="UserLoginRegister"/> --> 
<!-- Enter First Name:<input type="text" name="firstName"></input><br> -->
<!-- Enter Last Name:<input type="text" name="lastName"></input><br> -->
<!-- Enter Email:<input type="text" name="email"></input><br> -->
<!-- Enter password:<input type="password" name="password"></input><br> -->
<!-- Enter Number:<input type="text" name="number"></input> -->
<!-- <input type="submit" value="Register"></input> -->
<%-- </form> --%>

	<f:form modelAttribute="userDataRegForm" action="registerUser" method="post">
		<table>
			<tr>
				<td>Enter First Name:</td>
				<td><f:input path="firstName"/></td>		
			</tr>
			<tr>
				<td>Enter Last Name:</td>
				<td><f:input path="lastName"/></td>		
			</tr>
			<tr>
				<td>Enter Email:</td>
				<td><f:input path="email"/></td>		
			</tr>
			<tr>
				<td>Enter password:</td>
				<td><f:password path="password"/></td>		
			</tr>
			<tr>
				<td>Enter Number:</td>
				<td><f:input path="number"/></td>		
			</tr>
			<tr>
				<td>
					<input type="reset" value="Reset"></input>
					<input type="submit" value="Register"></input>
				</td>
			</tr>
		</table>
	</f:form>
	
</body>
</html>