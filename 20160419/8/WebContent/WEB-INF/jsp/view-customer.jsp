<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1" />
<title>View customer</title>
</head>
<body>
	<h2>New customer added successfully!</h2>
      <table>
          <tr>
              <td>First Name:</td>
              <td>${customer.name}</td>
          </tr>
          <tr>
              <td>Last Name:</td>
              <td>${customer.surname}</td>
          </tr>
      </table>
      <a href="home.do">Back</a>
</body>
</html>