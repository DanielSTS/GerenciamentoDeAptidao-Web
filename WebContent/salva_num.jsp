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
	
	<% 
	
		session.setAttribute("numero", request.getParameter("txtNumeroP"));
		response.sendRedirect("sobre_prova.jsp"); 
	
	
	//out.println(session.getAttribute("codigo"));
	//out.println(session.getAttribute("matricula"));
	//out.println(session.getAttribute("numero"));%>
	
	
</body>
</html>