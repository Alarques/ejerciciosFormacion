<?xml version="1.0" encoding="ISO-8859-1" ?>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1" />
<title>View all products</title>
</head>
<body>
	<h2>Products list</h2>
      <table>
      	<thead>
			<tr>
				<th>Name</th>
      			<th>Description</th>
      		</tr>
      	</thead>
      	<tbody>
	      <c:forEach items="${productList}" var="prod">
	          <tr>
	              <td>${prod.name}</td>
	              <td>${prod.description}</td>
	          </tr>
	      </c:forEach>
      	</tbody>
      </table>
      <a href="home.do">Back</a>
</body>
</html>