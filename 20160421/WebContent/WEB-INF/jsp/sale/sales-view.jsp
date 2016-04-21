<?xml version="1.0" encoding="ISO-8859-1" ?>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<link rel="stylesheet" type="text/css" href="css/mystyles.css" media="screen" />
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1" />
<title>View all sales</title>
</head>
<body>
	<h2>Sales list</h2>
      <table>
      	<thead>
			<tr>
				<th>Product</th>
      			<th>Customer</th>
      			<th>Quantity</th>
      			<th>Buy date</th>
      		</tr>
      	</thead>
      	<tbody>
	      <c:forEach items="${saleList}" var="sale">
	          <tr>
	              <td>${sale.key.product.name}</td>
	              <td>${sale.key.customer.name}</td>
	              <td>${sale.cantidad}</td>
	              <td>${sale.key.buyDate}</td>
	          </tr>
	      </c:forEach>
      	</tbody>
      </table>
      <a href="home.do">Back</a>
</body>
</html>