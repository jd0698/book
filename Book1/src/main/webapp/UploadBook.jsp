<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Upload Book</title>
</head>
<body>
<form action="saveBookData" method="post">

	Enter Title:<input type="text" name="bookTitle"/><br>
	Enter Name of Author:<input type="text" name="authorName"><br>
	Publication Year:<input type="text" name="pubYear"><br>
	Additional Info:<textarea name="additionalInfo" rows="10" cols="30"></textarea><br>
	Book Condition:<input type="radio" name="bookCondition" value="Fine" checked> Fine 
  					<input type="radio" name="bookCondition" value="As New"> As New 
  					<input type="radio" name="bookCondition" value="Good"> Good 
					<input type="radio" name="bookCondition" value="Poor"> Poor<br>
	Address:<textarea name="address" rows="4" cols="20"></textarea><br>
	<input type="reset"/>
	<input type="submit" value="Submit"/>
</form>

</body>
</html>