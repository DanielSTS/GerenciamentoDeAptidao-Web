<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>

<link href="css/style.css" rel="stylesheet">

</head>
<body>


<form action="./Login" method="post">
		<h1>Login</h1>
			
			Matrícula: <input type="text" name="txtLog" value="" id="txtLog"/><br/><br/>
					
			Senha: <input type="password" name="txtSenha" value="" id="txtSenha"/><br/><br/>

			<input type="submit" value="Entrar"/>

</form>

<center>
<form action="index.jsp" method="Post" >	
		<input type="submit" value ="Voltar" name="btnVoltar"/>
		
</form>			
</center>			
	
</body>
</html>