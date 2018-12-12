<%@page import="java.util.ArrayList"%>
<%@page import="com.gtu_QA_moksh.vo.BookData"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="f"  uri="http://java.sun.com/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Manage your Books</title>
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
	<% ArrayList<BookData> listOfAllBooksByUser = (ArrayList<BookData>)request.getAttribute("listOfAllBooksByUser");
		if(listOfAllBooksByUser.isEmpty()){
	%>
	No Books!!
	<%	}
		else{
			//System.out.print("book");
	%>
			<table>
			  <tr>
			    <th>Title</th>
			    <th>pubYear</th>
			    <th>...</th>
			  </tr>
			  <% for (int i=0; i<listOfAllBooksByUser.size();i++){
				  BookData book = listOfAllBooksByUser.get(i);
				  %>
				  <tr>
				    <td><%=book.getTitle()%></td>
				    <td><%=book.getPubYear()%></td>
				    <td>
				    	<form action="ShowBookInfo">
				    		<input type="hidden" name="idOfBook" value="<%=book.getId()%>"/>
				    		<input type="submit" value="More Info"/>
				    	</form>
				    	<form action="removeBook">
				    		<input type="hidden" name="idOfBook" value="<%=book.getId()%>"/>
				    		<input type="submit" value="Remove Book"/>
				    	</form>
				    	<form action="updateBookData">
				    		<input type="hidden" name="idOfBook" value="<%=book.getId()%>"/>
				    		<input type="submit" value="Update Book Data"/>
				    	</form>
<%-- 				    	<a href="ShowBookInfo?idOfBook=<%=book.getId()%>"> --%>
<!-- 				    		<button type="button">More Infoooo</button> -->
<!-- 				    	</a> -->
				    </td>
				  </tr>  
				  <%
			  }
			  %>
			 </table>
	<%
		}
	%>
</body>
</html>