<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Login</title>
</head>
<body>
	<%
		String str = "Login!";
		out.println(str);
	%>
	<form action="<%=request.getContextPath()%>/LoginLet" method="get">
		userName:<input type="text" name="username" /> <br /> 
		password:<input type="password" name="password" /> <br /> 
		<input type="submit"value="Login" /> 
		<input type="reset" value="Reset" />
	</form>
</body>
</html>