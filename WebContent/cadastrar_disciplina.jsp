<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>Insert title here</title>
	</head>
<body>
	<form	action="./CadastraDisciplina" method="Post">	
		<center>
			<div id="campos">
				<h3>Nome: <input type="txt" name="txtNome" id="txtNome"/><br/><br/></h3>
				<h3>Código: <input type="txt" name="txtCodigo" id="txtCodigo"/><br/><br/></h3>
				<h3>Matricula Professor: <input type="txt" name="txtMatricula" id="txtMatricula"/><br/><br/></h3>
			</div>		
			
			<div id ="botoes">
				<input type="submit" value ="Salvar" name="btnSalvar"/>
				
			</div>	
		</center>
	</form>
</body>
</html>