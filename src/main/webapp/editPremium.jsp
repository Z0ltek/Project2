<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Edit Premium</title>
</head>
<body>

<h1>Please choose username to edit premium:</br></h1>
<form action="PremiumEditServlet" method="get">
<table>
<tr><td>Username: </td><td><input type="text"  name="username"/></td></tr>
<tr><td><input type="submit" value="Toggle Premium"/></td><td></td></tr>
</table>
</form>

</br>
<a href="/index.jsp">Home</a>
</body>
</html>