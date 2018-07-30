<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
		<form	action="./CadastrarProfessor" method="Post">	
		
			
				<h3>Nome: <input type="txt" name="Nome" id="Nome"/></h3>
				<h3>Matricula: <input type="txt" name="Matricula" id="Matricula"/></h3>
				<h3>e-mail: <input type="txt" name="Email" id="Email"/></h3>
				
				<h3>data de nascimento: <input type="txt" name="DataDeNascimento" id="DataDeNascimento"/></h3>
				<h3>Titulação: <input type="txt" name="Titulacao" id="Titulacao"/></h3>
				<h3>Area de Formação: <input type="txt" name="AreaDeFormacao" id="AreaDeFormacao"/></h3>
				<h3>sexo: <input type="txt" name="Sexo" id="Sexo"/></h3>
				
				<h3>senha: <input type="password" name="Senha" id="Senha"/></h3>
								
				
			
			
				<input type="submit" value ="Salvar" name="btnSalvar"/>
				
			
		
	</form>
	<center>
	<form action="index.jsp" method="Post" >	
		<input type="submit" value ="Voltar" name="btnVoltar"/>
		
		</form>
	</center>
	</body>
</html>

 