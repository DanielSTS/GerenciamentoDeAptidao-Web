<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
	

	
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>LOGIN</title>
		
	</head>
	<body style="background-color: buttonface">
	
	<%@	page import="classes.*,
	java.sql.*,javax.*"%>
	<% 
	

	ConnectionFactory conexao = new ConnectionFactory();
	Connection con = conexao.getConnection();
	
	if (conexao != null){
		System.out.println("conectado");
	}else{
		System.out.println("Não conectado");

	}
	
	%>
	
	
	<center>
		<form action="login.jsp" method="post">
		<h2>Login</h2>
			<div id="campos">
			
					Matrícula: <input type="text" name="txtLog" value="" id="txtLog"/><br/><br/>
					
					Senha: <input type="password" name="txtSenha" value="" id="txtSenha"/><br/><br/>
					
				    <%session.setAttribute("matricula", request.getParameter("txtLog")); %>
				    <%session.setAttribute("senha", request.getParameter("txtSenha"));%>
				   
				    
					
					<%if (con!= null){
						
						
						if (request.getParameter("txtSenha")!= null) {
							System.out.println(request.getParameter("txtSenha"));							
				Statement st ;
				ResultSet rs;
				st = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.TYPE_FORWARD_ONLY);
				rs = st.executeQuery("select * from professor where matricula='" +request.getParameter("txtLog")+"' and senha='"+request.getParameter("txtSenha")+"'");
				
		
						if(rs.next()){
								
								response.sendRedirect("home.jsp");
							}
						
						}
					}else{
						out.println("Não foi possível logar!!");
					}
					%>
					<input type="submit" value="Entrar"/>
		</form>
			</div>
	</center>
	<form action="index.jsp" method="Post" >	
		<input type="submit" value ="Voltar" name="btnVoltar"/>
		
		
		</form>
	
	</body>
</html>