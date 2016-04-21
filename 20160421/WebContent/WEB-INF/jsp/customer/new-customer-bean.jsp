<?xml version="1.0" encoding="ISO-8859-1" ?>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1" />
<title>New customer BEAN</title>
<link rel="stylesheet" type="text/css" href="css/mystyles.css" media="screen" />
</head>
<body>
	<h1>New customer BEAN</h1>
	<form:form action="add-customer-bean.do" commandName="customer" method="post">
      <table>
          <tr>
              <td>First Name:</td>
              <td><form:input path="name" /></td>
          </tr>
          <tr>
              <td>Last Name:</td>
              <td><form:input path="surname" /></td>
          </tr>
          <tr>
              <td>Employee:</td>
              <td><form:select items="${employeeList}" path="employeeId" itemValue="id" itemLabel="name" /></td>
          </tr>
          <tr>
              <td colspan="2">
                  <input type="submit" value="Save changes" />
                  <a href="home.do">Back</a>
              </td>
          </tr>
      </table>
  </form:form>
</body>
</html>