<?xml version="1.0" encoding="ISO-8859-1" ?>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<link rel="stylesheet" type="text/css" href="css/mystyles.css" media="screen" />
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1" />
<title>View all customers</title>
</head>
<body>
	<h2><fmt:message key="customer.list"/></h2>
      <table>
      	<thead>
			<tr>
				<th><fmt:message key="form.first.name"/></th>
      			<th><fmt:message key="form.last.name"/></th>
      			<th><fmt:message key="customer.percent.product"/></th>
      			<th><fmt:message key="form.delete"/></th>
      		</tr>
      	</thead>
      	<tbody>
	      <c:forEach items="${customerList}" var="cust">
	          <tr>
	              <td>${cust.name}</td>
	              <td>${cust.surname}</td>
	              <td>${cust.percentProduct} %</td>
	              <td><a href="<c:url value='/delete-customer/${emp.id}.do' />" ><fmt:message key="form.delete"/></a></td>
	          </tr>
	      </c:forEach>
      	</tbody>
      </table>
      <a href="home.do"><fmt:message key="web.back"/></a>
</body>
</html>