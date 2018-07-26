<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
	<%@	page import="classes.*" %>

	<% 
	 
	ContatoDao cd = new ContatoDao();
	
	%>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>LOGIN</title>
		<link rel="stylesheet" href="/css/style.css">
	</head>
	<body style="background-color: buttonface">
	
		<center>
			<div id="campos">
			<h2>Login</h2>
				<form action="home.jsp" method="post">
					Login: <input type="text" name="usuario.usuario"/>
					<br/><br/>
					Senha: <input type="password" name="usuario.senha"/>
					<br/><br/>
					<input type="submit" value="Logar-se"/>
				</form>
			</div>
		</center>
	</body>
</html>