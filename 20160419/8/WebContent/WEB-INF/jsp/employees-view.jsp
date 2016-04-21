<?xml version="1.0" encoding="ISO-8859-1" ?>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1" />
<title>View all employees</title>
</head>
<body>
	<h2>Employees list</h2>
      <table>
      	<thead>
			<tr>
				<th>First name</th>
      			<th>Surname</th>
      			<th>Birthday</th>
      		</tr>
      	</thead>
      	<tbody>
	      <c:forEach items="${employeeList}" var="emp">
	          <tr>
	              <td>${emp.name}</td>
	              <td>${emp.surname}</td>
	              <td>${emp.birthday}</td>
	          </tr>
	      </c:forEach>
      	</tbody>
      </table>
      <a href="home.do">Back</a>
</body>
</html>