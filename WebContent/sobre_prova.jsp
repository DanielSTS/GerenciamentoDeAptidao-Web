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
	java.sql.*,javax.*,com.mysql.cj.util.StringUtils"%>

<% 
String mat = (String) session.getAttribute("matricula"); 

int matricula_aluno = Integer.parseInt(mat);	

String codigo = (String) session.getAttribute("codigo");

String numero = (String) session.getAttribute("numero");

int numero_prova = 0 , codigo_disciplina = 0 ;

if(StringUtils.isStrictlyNumeric(numero)){
	
 numero_prova = Integer.parseInt(numero);
 codigo_disciplina = Integer.parseInt(codigo);

 
 ConnectionFactory con = new ConnectionFactory();
 con.getConnection();
 con.ExecutaSql("select * from prova where prova.numero = '"+numero_prova+"'"+"and prova.codigo_d ='"+codigo_disciplina+"'");

 if(!con.resultset.first()){

 	response.sendRedirect("sobre_disciplina.jsp");
 }
}else{
	response.sendRedirect("sobre_disciplina.jsp");
}

 %>
 
 

		
			
		<form	action="./AdicionarNota" method="post">	
				
				
				<h3>Matricula Aluno: <input type="txt" name="txtMatriculaP" id="txtMatriculaP"/><br/><br/></h3>
				<h3>Nota: <input type="txt" name="txtNotaP" id="txtNotaP"/><br/><br/></h3>
				<input type="submit" value ="Salvar" name="btnSalvar"/><br/><br/>
				
		</form>
		
		
		<table border=1> 
			<tr>
				<td>Matricula</td>
				<td>Nome</td>
				<td>Curso</td>
				<td>Nota</td>
	
				
			</tr>
	<% 
	ConnectionFactory conexao_teste = new ConnectionFactory();
	conexao_teste.getConnection();
	conexao_teste.ExecutaSql("select * from prova_aluno_disciplina  where prova_aluno_disciplina.codigo_a = '"+matricula_aluno+"'");
	
	
	
		ConnectionFactory conexao = new ConnectionFactory();
		Connection resp = conexao.getConnection();
		conexao.ExecutaSql("select al.matricula,al.nome,al.curso,pad.nota from aluno al, prova_aluno_disciplina pad ,disciplina di where pad.codigo_a = al.matricula and pad.codigo_d = '"+codigo_disciplina+"'");
		conexao.resultset.first();
		
		 do {
			 
			 if(conexao_teste.resultset.first()){
		out.println("<tr>"); 
		out.println("<td>"+ conexao.resultset.getInt("matricula")+"</td>");
		out.println("<td>"+ conexao.resultset.getString("nome")+"</td>");
		out.println("<td>"+ conexao.resultset.getString("curso")+"</td>");
		out.println("<td>"+ conexao.resultset.getDouble("nota")+"</td>");
		
		
		out.println("</tr>");
			 }
			} while(conexao.resultset.next());
	
			%>
				</tr>
		</table>
		
		
		
		
		
		
		
		
		<center>
		<form action="sobre_disciplina.jsp" method="Post" >	
		<input type="submit" value ="Voltar" name="btnVoltar"/>
		</center>
		</form>
	

</body>
</html>