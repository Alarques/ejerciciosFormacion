<?xml version="1.0" encoding="ISO-8859-1" ?>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1" />
<title>Search sale</title>
<link rel="stylesheet" type="text/css" href="css/mystyles.css" media="screen" />
</head>
<body>
	<h1>Search sale</h1>
	<form:form action="search-sale.do" commandName="saleSearch" method="post">
      <table>
          <tr>
              <td>Customer:</td>
              <td><form:select items="${customerList}" path="key.customer.id" itemValue="id" itemLabel="name" /></td>
          </tr>
          <tr>
              <td colspan="4">
                  <input type="submit" value="Search" />
                  <a href="home.do">Back</a>
              </td>
          </tr>
      </table>
  </form:form>
  <h3>Sale list</h3>
	<table>
	    <thead>
			<tr>
				<th>Customer</th>
	    		<th>Product</th>
	    		<th>Quantity</th>
	    		<th>Buy date</th>
	    	</tr>
	    </thead>
	    <tbody>
	    	<c:forEach items="${saleList}" var="sal">
	        	<tr>
	            	<td>${sal.key.customer.name}</td>
	             	<td>${sal.key.product.name}</td>
	             	<td>${sal.cantidad}</td>
	             	<td>${sal.key.buyDate}</td>
	         	</tr>
	     	</c:forEach>
	    </tbody>
    </table>
</body>
</html>