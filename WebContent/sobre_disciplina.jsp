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

<% String mat = (String) session.getAttribute("matricula"); 
   int matricula = Integer.parseInt(mat);	

String teste = (String) session.getAttribute("codigo");

int codigo_disciplina = 0 ;

if(StringUtils.isStrictlyNumeric(teste)){
	
 codigo_disciplina = Integer.parseInt(teste);

 
 ConnectionFactory con = new ConnectionFactory();
 con.getConnection();
 con.ExecutaSql("select * from disciplina where disciplina.matricula_professor = '"+matricula+"'"+"and disciplina.codigo ='"+codigo_disciplina+"'");

 if(!con.resultset.first()){

 	response.sendRedirect("opcoes_disciplina.jsp");
 }
}else{
	response.sendRedirect("opcoes_disciplina.jsp");
}

 %>
 
 
 
 


	 <table border=1> 
			<tr>
				<td>Matricula</td>
				<td>Nome</td>
				<td>Curso</td>
	
				
			</tr>
	<% 
	ConnectionFactory conexao_teste = new ConnectionFactory();
	conexao_teste.getConnection();
	conexao_teste.ExecutaSql("select a.* from aluno a , aluno_disciplina ad where a.matricula = ad.codigo_a and ad.codigo_d = '"+codigo_disciplina+"'");
	
	if(conexao_teste.resultset.first()){
		ConnectionFactory conexao = new ConnectionFactory();
		Connection resp = conexao.getConnection();
		conexao.ExecutaSql("select a.* from aluno a , aluno_disciplina ad where a.matricula = ad.codigo_a and ad.codigo_d = '"+codigo_disciplina+"'order by a.matricula");
		conexao.resultset.first();
		
		 do {
		out.println("<tr>"); 
		out.println("<td>"+ conexao.resultset.getInt("matricula")+"</td>");
		out.println("<td>"+ conexao.resultset.getString("nome")+"</td>");
		out.println("<td>"+ conexao.resultset.getString("curso")+"</td>");
		
		
		out.println("</tr>");
			} while(conexao.resultset.next());
	 }
				%>
				</tr>
		</table>
		
		<form	action="./AdicionarAluno" method="Post">	
		
			
				<h3>Nome: <input type="txt" name="txtNome" id="txtNome"/><br/><br/></h3>
				<h3>Curso: <input type="txt" name="txtCurso" id="txtCurso"/><br/><br/></h3>
				<h3>Matricula Aluno: <input type="txt" name="txtMatricula" id="txtMatricula"/><br/><br/></h3>
			
				<input type="submit" value ="Salvar" name="btnSalvar"/><br/><br/>
				
		</form>
	
	
	<table border=1> 
			<tr>
				<td>Número</td>
				<td>Assunto</td>
				<td>Material</td>
				
	
				
			</tr>
			<% 
			ConnectionFactory conexao_teste_prova = new ConnectionFactory();
			conexao_teste_prova.getConnection();
			conexao_teste_prova.ExecutaSql("select * from prova where prova.codigo_d = '"+codigo_disciplina+"'");
			
			
			if(conexao_teste_prova.resultset.first()){

				ConnectionFactory conexao_prova = new ConnectionFactory();
				Connection resp_prova = conexao_prova.getConnection();
				conexao_prova.ExecutaSql("select numero,assunto,material from prova where prova.codigo_d = '"+codigo_disciplina+"'order by prova.numero");
				conexao_prova.resultset.first();
				
				 do {
				out.println("<tr>"); 
				
				out.println("<td>"+ conexao_prova.resultset.getInt("numero")+"</td>");
				out.println("<td>"+ conexao_prova.resultset.getString("assunto")+"</td>");
				out.println("<td>"+ conexao_prova.resultset.getString("material")+"</td>");
				
				
				
				
				out.println("</tr>");
					} while(conexao_prova.resultset.next());
			}%>
				</tr>
		</table>
		
		
		<form	action="./AdicionarProva" method="Post">	
		
			
				<h3>Número Prova: <input type="txt" name="txtNumeroP" id="txtNumeroP"/><br/><br/></h3>
				<h3>Assunto: <input type="txt" name="txtAssuntoP" id="txtAssuntoP"/><br/><br/></h3>
				<h3>Material: <input type="txt" name="txtMaterialP" id="txtMaterialP"/><br/><br/></h3>
				
			
			
			
				<input type="submit" value ="Salvar" name="btnSalvarProva"/>
				
			
		
	</form>
	
	<form	action="salva_num.jsp" method="Post">	
		
			
				<h3>Número Prova: <input type="txt" name="txtNumeroP" id="txtNumeroP"/><br/><br/></h3>
				<input type="submit" value ="Adicionar Notas" name="btnSalvarProva"/>
				<%  %>
	</form>
		
		
		
		<table border=1> 
			<tr>
			<br><br><td>Número</td>
				<td>Assunto</td>
				<td>Material</td>
				
				
	
				
			</tr>
			<% 
			ConnectionFactory conexao_teste_aula = new ConnectionFactory();
			conexao_teste_aula.getConnection();
			conexao_teste_aula.ExecutaSql("select * from aula where aula.codigo_d = '"+codigo_disciplina+"'");
			
			
			if(conexao_teste_aula.resultset.first()){

				ConnectionFactory conexao_aula = new ConnectionFactory();
				Connection resp_aula = conexao_aula.getConnection();
				conexao_aula.ExecutaSql("select numero,assunto,material from aula where aula.codigo_d = '"+codigo_disciplina+"'order by aula.numero");
				conexao_aula.resultset.first();
				
				 do {
				out.println("<tr>"); 
				
				out.println("<td>"+ conexao_aula.resultset.getInt("numero")+"</td>");
				out.println("<td>"+ conexao_aula.resultset.getString("assunto")+"</td>");
				out.println("<td>"+ conexao_aula.resultset.getString("material")+"</td>");
				
				
				
				
				out.println("</tr>");
					} while(conexao_aula.resultset.next());
			}%>
				</tr>
		</table>
		
		
		<form	action="./AdicionarAula" method="Post">	
		
			
				<h3>Número Aula: <input type="txt" name="txtNumeroA" id="txtNumeroA"/><br/><br/></h3>
				<h3>Assunto: <input type="txt" name="txtAssuntoA" id="txtAssuntoA"/><br/><br/></h3>
				<h3>Material: <input type="txt" name="txtMaterialA" id="txtMaterialA"/><br/><br/></h3>
				

			
			
				<input type="submit" value ="Salvar" name="btnSalvarProva"/>
				
			
	</form>
		
		
		
		
		
		
		
		
		
		
		
		
		<center>
		<form action="opcoes_disciplina.jsp" method="Post" >	
		<input type="submit" value ="Voltar" name="btnVoltar"/>
		</center>
		</form>
	
</body>
</html>