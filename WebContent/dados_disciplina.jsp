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
		
		<center>
		<form action="home.jsp" method="Post" >	
		<input type="submit" value ="Voltar" name="btnVoltar"/>
		</center>
		</form>
	
</body>
</html>