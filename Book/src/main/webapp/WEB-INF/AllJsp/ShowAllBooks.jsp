<%@page import="com.gtu_QA_moksh.vo.BookData"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
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
		<input type="hidden" name="pageKey" value="ShowAllBooks"/>
		<input type="submit" value="Home Page"/>
	</form>
	<br><br>
	<% ArrayList<BookData> listOfAllBooks = (ArrayList<BookData>)request.getAttribute("listOfAllBooks");
		if(listOfAllBooks.isEmpty()){
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
			  <% for (int i=0; i<listOfAllBooks.size();i++){
				  BookData book = listOfAllBooks.get(i);
				  %>
				  <tr>
				    <td><%=book.getTitle()%></td>
				    <td><%=book.getPubYear()%></td>
				    <td>
				    	<form action="ShowBookInfo">
				    		<input type="hidden" name="idOfBook" value="<%=book.getId()%>"/>
				    		<input type="submit" value="More Info"/>
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