<?xml version="1.0" encoding="ISO-8859-1" ?>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1" />
<title>View all customers</title>
</head>
<body>
	<h2>Customers list</h2>
      <table>
      	<thead>
			<tr>
				<th>Name</th>
      			<th>Surname</th>
      			<th>Percent product</th>
      		</tr>
      	</thead>
      	<tbody>
	      <c:forEach items="${customerList}" var="cust">
	          <tr>
	              <td>${cust.name}</td>
	              <td>${cust.surname}</td>
	              <td>${cust.percentProduct} %</td>
	          </tr>
	      </c:forEach>
      	</tbody>
      </table>
      <a href="home.do">Back</a>
</body>
</html>