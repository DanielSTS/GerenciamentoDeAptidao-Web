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
	
<% String mat = (String) session.getAttribute("matricula"); 
   int matricula = Integer.parseInt(mat);	
%>	

	 <a href="cadastrar_disciplina.jsp" >Criar Disciplina</a>
	 <a href="editar_disciplina.jsp" > EditarDisciplina</a>
	 <a href="excluir_disciplina.jsp" >Excluir Disciplina</a>
	 
	 <table border=1> 
			<tr>
				<td>Código</td>
				<td>Nome</td>
	
				
			</tr>
			
			<%
			ConnectionFactory conexao = new ConnectionFactory();
			Connection resp = conexao.getConnection();
			conexao.ExecutaSql("select * from disciplina where matricula_professor='"+matricula+"'");
			conexao.resultset.first();
			
			
			
			 do {
			out.println("<tr>"); 
			out.println("<td>"+ conexao.resultset.getInt("codigo")+"</td>");
			out.println("<td>"+ conexao.resultset.getString("nome")+"</td>");
			
			
			
			 session.setAttribute("codigo_disciplina","pinta"); 
			
			
			out.println("<form action='dados_disciplina.jsp' method='Post' >");	
			out.println("<td><input type='submit' value ='Ir' name='btnIr' /></td>");
			
			out.println("</form>");
			
			out.println("</tr>");
				} while(conexao.resultset.next());
				%>
				</tr>
		</table>
		<center>
		<form action="home.jsp" method="Post" >	
		<input type="button" value ="Voltar" name="btnVoltar" />
		</center>
		</form>
	
</body>
</html>