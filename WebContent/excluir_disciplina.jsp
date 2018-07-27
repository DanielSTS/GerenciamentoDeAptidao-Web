<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

<%@	page import="classes.*,servelets.*,
	java.sql.*,javax.*"%>
	
<form	action="./ExcluirDisciplina" method="Post">	
<center>
	<h1>Excluir Disciplina</h1>
	
	<div id="Tabela">
	<h3>Informe o código da disciplina : <input type="text" name="txtCod" value="" id="txtCod"/></h3>
		<table border=1> 
			<tr>
				<td>Código</td>
				<td>Nome</td>
	
				
			</tr>
			
			<%
			ConnectionFactory conexao = new ConnectionFactory();
			Connection resp = conexao.getConnection();
			conexao.ExecutaSql("select * from disciplina order by codigo" );
			conexao.resultset.first();
			
			
			
			 do {
			out.println("<tr>"); 
			out.println("<td>"+ conexao.resultset.getInt("codigo")+"</td>");
			out.println("<td>"+ conexao.resultset.getString("nome")+"</td>");
			
			out.println("</tr>");
				} while(conexao.resultset.next());
				%>
				</tr>
		</table>
		<br><a></a><input type="submit" value ="Confirmar" name="btnConfirmar"/>
		
			</div>
		</center>
		</form>
		
		</center>
		</form>
		
		<form action="opcoes_disciplina.jsp" method="Post" >	
		<input type="submit" value ="Voltar" name="btnVoltar"/>
		
		</form>
	</body>
</html>