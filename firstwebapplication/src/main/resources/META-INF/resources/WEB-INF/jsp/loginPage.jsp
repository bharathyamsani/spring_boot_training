<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Login Page</title>
</head>
<body>
<p>Welcome to the Login Page</p>
<form method="post">
<br><br>
Username:<input type='text' value="" name='name'>
<br>
<br>
Password:<input type='password' value="" name='password'>
<br><br>
<button> Submit</button>
</form>
<p>${errorMessage }</p>
</body>
</html>