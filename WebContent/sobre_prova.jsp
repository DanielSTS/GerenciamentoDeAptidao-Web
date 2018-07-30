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
 
 

		
			
		<form	action="./AdicionarNota" method="Post">	
				
				
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
	ConnectionFactory conexao = new ConnectionFactory();
	conexao.getConnection();
	conexao.ExecutaSql("select a.* from aluno a , aluno_disciplina ad where a.matricula = ad.codigo_a and ad.codigo_d = '"+codigo_disciplina+"'");
	
	ResultSet teste  = conexao.resultset;
	
	
	if(teste.first()){
		
		conexao.getConnection();
		conexao.ExecutaSql("select a.* from aluno a , aluno_disciplina ad where a.matricula = ad.codigo_a and ad.codigo_d = '"+codigo_disciplina+"'order by a.matricula");
		conexao.resultset.first();
		ResultSet aux  = conexao.resultset;
		
		conexao.getConnection();
		conexao.ExecutaSql("select pad.* from prova_aluno_disciplina pad where pad.codigo_d = '"+codigo_disciplina+"'"+" and pad.codigo_p = '"+numero_prova+"'order by pad.codigo_a ");
		conexao.resultset.first();
		ResultSet nota = conexao.resultset;
		
		 do {
		out.println("<tr>"); 
		out.println("<td>"+ aux.getInt("matricula")+"</td>");
		out.println("<td>"+ aux.getString("nome")+"</td>");
		int matricula_aux = aux.getInt("matricula");
		out.println("<td>"+ aux.getString("curso")+"</td>");
		
		
		if(nota.first() && nota.getInt("codigo_a") == matricula_aux){
			out.println("<td>"+ conexao.resultset.getDouble("nota")+"</td>");
			nota.next();

		}else{
			out.println("<td> </td>");
			
		}
		
		out.println("</tr>");
			} while(aux.next());
	 }
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