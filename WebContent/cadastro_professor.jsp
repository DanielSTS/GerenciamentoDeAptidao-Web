<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%@	page import="classes.*,
	java.sql.*,javax.*"%>

	
	
		<h1>Cadastro de Usuário</h1>
		<hr	/>
		<form	action="home.jsp" method="Post">
			Nome:	<input	type="text" name="nome" id="nome"	/><br	/>
			E-mail:	<input	type="text" name="email"	/><br	/>
			Senha:	<input	type="text" name="endereco"	/><br	/>
			DataNascimento: <input	type="text" name="dataNascimento"	/><br	/>
			
			<%
			System.out.println(request.getParameter("nome") + "24");
			%>
						
			<input	type="submit" value="Gravar"	/>
		</form>
	</body>
</html>