package servelets;

import java.io.IOException;
import java.io.PrintWriter;
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


@WebServlet("/CadastrarProfessor")
public class CadastrarProfessor extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	ConnectionFactory conexao = new ConnectionFactory();
	Connection resp;
	
	protected	void	service	(HttpServletRequest	request,
					HttpServletResponse	response)
					throws	ServletException,	IOException	{
		
		String nome,email,matricula,dataNascimento,titulacao,areadeformacao,sexo,senha;
		nome = request.getParameter("Nome");
		email = request.getParameter("Email");
		matricula = request.getParameter("Matricula");
		dataNascimento = request.getParameter("DataDeNascimento");
		titulacao = request.getParameter("Titulacao");
		areadeformacao = request.getParameter("AreaDeFormacao");
		sexo = request.getParameter("Sexo");
		senha = request.getParameter("Senha");
		
		
		try {
			
			resp = conexao.getConnection();
		
		if(resp != null &&  StringUtils.isStrictlyNumeric(matricula)) {
			
			conexao.ExecutaSql("select * from professor where matricula='"+matricula+"'");
			
			if(!conexao.resultset.first()) {
				PreparedStatement pst = resp.prepareStatement("insert into professor (matricula,email,datanascimento,nome,areadeformacao,titulacao,sexo,senha) values(?,?,?,?,?,?,?,?)");
				pst.setString(4,nome);
				pst.setString(2,email);
				pst.setInt(1,Integer.parseInt(matricula));
				pst.setString(3,dataNascimento);
				pst.setString(6,titulacao);
				pst.setString(5,areadeformacao);
				pst.setString(7,sexo);
				pst.setString(8,senha);
				pst.execute();
				response.sendRedirect("login.jsp");
			}else {
				
				
				response.sendRedirect("falha_login.jsp");
			}
			
		}else {
			
			
			response.sendRedirect("falha_login.jsp");
		}
			} catch (SQLException e) {
				
				e.printStackTrace();
			
			
		}
		
	
	}
	
       
   
    public CadastrarProfessor() {
        super();
       
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
