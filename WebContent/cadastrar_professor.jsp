<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
		<form	action=".\CadastraDisciplina" method="Post">	
		<center>
			<div id="campos">
				<h3>Nome: <input type="txt" name="txtNome" id="Nome"/></h3>
				<h3>Matricula: <input type="txt" name="txtCodigo" id="Matricula"/></h3>
				<h3>e-mail: <input type="txt" name="txtCodigo" id="Email"/></h3>
				<h3>senha: <input type="password" name="txtCodigo" id="Senha"/></h3>
				<h3>data de nascimento: <input type="txt" name="txtCodigo" id="DataDeNascimento"/></h3>
				<h3>Titulação: <input type="txt" name="txtCodigo" id="Titulacao"/></h3>
				<h3>Area de Formação: <input type="txt" name="txtCodigo" id="AreaDeFormacao"/></h3>
				<h3>sexo: <input type="txt" name="txtCodigo" id="Sexo"/></h3>
								
			</div>		
			
			<div id ="botoes">
				<input type="submit" value ="Salvar" name="btnSalvar"/>
				
			</div>	
		</center>
	</form>
	</body>
</html>

 