<?xml version="1.0" encoding="ISO-8859-1" ?>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1" />
<title>Home</title>
</head>
<body>
	<div style="text-align:center">
		<h2>
			Enterprise Spring MVC - Managing app
		</h2>
		<ul>
			<b>Empleados</b>
			<li><a href="new-employee-creation.do">Alta de empleado</a></li>
			<li><a href="employees-view.do">Consulta de empleados</a></li>
			<br></br><b>Clientes</b>
			<li><a href="new-customer-creation.do">Alta de cliente</a></li>
			<li><a href="customers-view.do">Consulta de clientes</a></li>
			<br></br><b>Productos</b>
			<li><a href="products-view.do">Consulta de productes</a></li>
			<br></br><b>Ventas</b>
			<li><a href="sales-view.do">Consulta de ventas</a></li>
		</ul>
	</div>
</body>
</html>