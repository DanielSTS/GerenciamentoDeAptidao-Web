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

<% String num = (String) session.getAttribute("numero"); 
   int numero_prova = Integer.parseInt(num);	

   String cod = (String) session.getAttribute("codigo"); 
   int codigo_disciplina = Integer.parseInt(cod);
 %>



<table border=1> 
			<tr>
				<td>Número da Prova</td>
				<td>Média da Turma</td>
				
	
				
			</tr>

<% 
	ConnectionFactory conexao_teste = new ConnectionFactory();
	conexao_teste.getConnection();
	conexao_teste.ExecutaSql("select p.numero, AVG(pad.nota) from prova_aluno_disciplina pad, disciplina d, prova p where pad.codigo_p = p.numero and pad.codigo_d = '"+codigo_disciplina +"'group by p.numero");
	
	if(conexao_teste.resultset.first()){
		ConnectionFactory conexao = new ConnectionFactory();
		Connection resp = conexao.getConnection();
		conexao.ExecutaSql("select p.numero, AVG(pad.nota) from prova_aluno_disciplina pad, disciplina d, prova p where pad.codigo_p = p.numero and pad.codigo_d = '"+codigo_disciplina +"'group by p.numero");
		conexao.resultset.first();
		
		 do {
		out.println("<tr>"); 
		out.println("<td>"+ conexao.resultset.getInt("numero")+"</td>");
		out.println("<td>"+ conexao.resultset.getString("AVG(pad.nota)")+"</td>");
		
		
		
		out.println("</tr>");
			} while(conexao.resultset.next());
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