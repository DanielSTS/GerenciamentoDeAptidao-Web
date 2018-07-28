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



	 <table border=1> 
			<tr>
				<td>Matricula</td>
				<td>Nome</td>
				<td>Curso</td>
	
				
			</tr>
			<% 
			ConnectionFactory conexao = new ConnectionFactory();
			Connection resp = conexao.getConnection();
			conexao.ExecutaSql("select * from aluno order by nome" );
			conexao.resultset.first();
			
			 do {
			out.println("<tr>"); 
			out.println("<td>"+ conexao.resultset.getInt("matricula")+"</td>");
			out.println("<td>"+ conexao.resultset.getString("nome")+"</td>");
			out.println("<td>"+ conexao.resultset.getString("curso")+"</td>");
			
			
			out.println("</tr>");
				} while(conexao.resultset.next());
				%>
				</tr>
		</table>
		
		<form	action="./AdicionarAluno" method="Post">	
		
			<div id="campos">
				<h3>Nome: <input type="txt" name="txtNome" id="txtNome"/><br/><br/></h3>
				<h3>Curso: <input type="txt" name="txtCurso" id="txtCurso"/><br/><br/></h3>
				<h3>Matricula Aluno: <input type="txt" name="txtMatricula" id="txtMatricula"/><br/><br/></h3>
			</div>		
			
			<div id ="botoes">
				<input type="submit" value ="Salvar" name="btnSalvar"/><br/><br/>
				
			</div>	
		
	</form>
	
	
	<table border=1> 
			<tr>
				<td>Número</td>
				<td>Assunto</td>
				
	
				
			</tr>
			<% 
			ConnectionFactory conexao_prova = new ConnectionFactory();
			Connection resp_prova = conexao_prova.getConnection();
			conexao_prova.ExecutaSql("select assunto,numero from prova order by numero" );
			conexao_prova.resultset.first();
			
			 do {
			out.println("<tr>"); 
			
			out.println("<td>"+ conexao_prova.resultset.getInt("numero")+"</td>");
			out.println("<td>"+ conexao_prova.resultset.getString("assunto")+"</td>");
			
			
			
			
			out.println("</tr>");
				} while(conexao_prova.resultset.next());
				%>
				</tr>
		</table>
		
		<form	action="./AdicionarProva" method="Post">	
		
			<div id="camposProva">
				<h3>Número: <input type="txt" name="txtNumero" id="txtNumero"/><br/><br/></h3>
				<h3>Assunto: <input type="txt" name="txtAssunto" id="txtAssunto"/><br/><br/></h3>
				
			</div>		
			
			<div id ="botoesProva">
				<input type="submit" value ="Salvar" name="btnSalvarProva"/>
				
			</div>	
		
	</form>
		
		<center>
		<form action="home.jsp" method="Post" >	
		<input type="submit" value ="Voltar" name="btnVoltar"/>
		</center>
		</form>
	
</body>
</html>