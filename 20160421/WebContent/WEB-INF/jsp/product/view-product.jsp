<?xml version="1.0" encoding="ISO-8859-1" ?>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<link rel="stylesheet" type="text/css" href="css/mystyles.css" media="screen" />
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1" />
<title>View product</title>
</head>
<body>
	<h2><fmt:message key="product.added.ok"/>!</h2>
      <table>
          <tr>
              <td><fmt:message key="form.first.name"/>:</td>
              <td>${product.name}</td>
          </tr>
          <tr>
              <td><fmt:message key="form.description"/>:</td>
              <td>${product.description}</td>
          </tr>
      </table>
      <a href="home.do"><fmt:message key="web.back"/></a>
</body>
</html>