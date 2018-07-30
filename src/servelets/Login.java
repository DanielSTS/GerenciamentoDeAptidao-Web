package servelets;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mysql.cj.util.StringUtils;

import classes.ConnectionFactory;


@WebServlet("/Login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	ConnectionFactory conexao = new ConnectionFactory();
	Connection resp;
	
	protected	void	service	(HttpServletRequest	request,
					HttpServletResponse	response)
					throws	ServletException,	IOException	{
		
		
		String log = (String) request.getParameter("txtLog");
		String senha = (String)request.getParameter("txtSenha");
		
		int matricula = 0;
		
		
		try {
			
		resp = conexao.getConnection();
		
		if(resp != null && StringUtils.isStrictlyNumeric(log) ) {
			 
			 matricula = Integer.parseInt(log);
			 
			 conexao.ExecutaSql("select * from professor p where p.matricula = '"+matricula+"'"+"and p.senha ='"+senha+"'");
			
			
			if(conexao.resultset.first()) {
				request.getSession().setAttribute("matricula", log);
				response.sendRedirect("home.jsp");
				
			}else {
				response.sendRedirect("login_teste.jsp");
			}
			
		}else {
			response.sendRedirect("login_teste.jsp");
		}
			} catch (SQLException e) {
				
				e.printStackTrace();
			
			
		}
	
	}
	
	
	public Login() {
        super();
        
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
