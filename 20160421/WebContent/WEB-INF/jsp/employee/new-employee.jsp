<?xml version="1.0" encoding="ISO-8859-1" ?>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1" />
<title>New employee</title>
<link rel="stylesheet" type="text/css" href="css/mystyles.css" media="screen" />
</head>
<body>
	<h1><fmt:message key="employee.create" /></h1>
	<form:form action="add-employee.do" commandName="employee" method="post">
      <table>
          <tr>
              <td><fmt:message key="form.first.name" />:</td>
              <td><form:input path="name" value="${employee.name}"/></td>
          </tr>
          <tr>
              <td><fmt:message key="form.last.name" />:</td>
              <td><form:input path="surname" /></td>
          </tr>
          <tr>
              <td><fmt:message key="form.birthday"/>:</td>
              <td><form:input path="birthday" /></td>
          </tr>
          <tr>
              <td colspan="2">
                  <input type="submit"/>
                  <a href="home.do"><fmt:message key="web.back"/></a>
              </td>
          </tr>
      </table>
  </form:form>
</body>
</html>