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
	
	<% session.setAttribute("codigo", request.getParameter("cod"));%>
	<% response.sendRedirect("sobre_disciplina.jsp"); 
	//out.println(session.getAttribute("codigo"));
//	out.println(session.getAttribute("matricula"));%>
	
	
</body>
</html>