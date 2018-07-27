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

import classes.ConnectionFactory;


@WebServlet("/AdicionarAluno")

public class AdicionarAluno extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	ConnectionFactory conexao = new ConnectionFactory();
	Connection resp;
	
	protected	void	service	(HttpServletRequest	request,
					HttpServletResponse	response)
					throws	ServletException,	IOException	{
		
		String nome,curso,matricula;
		nome = request.getParameter("txtNome");
		curso = request.getParameter("txtCurso");
		matricula = request.getParameter("txtMatricula");
		
		
		
		try {
			
		resp = conexao.getConnection();
		
		if(resp != null) {
			conexao.ExecutaSql("select * from disciplina where matricula='"+matricula+"'");
			
			
			if(!conexao.resultset.first()) {
				PreparedStatement pst = resp.prepareStatement("insert into disciplina (matricula,curso,nome) values(?,?,?)");
				pst.setString(2,curso);
				pst.setString(3,nome);
				pst.setInt(1,Integer.parseInt(matricula));

				
				pst.execute();
				response.sendRedirect("opcoes_disciplina.jsp");
			}else {
				response.sendRedirect("falha_cadastro.jsp");
			}
			
		}
			} catch (SQLException e) {
				
				e.printStackTrace();
			
			
		}
		
		PrintWriter	out	=	response.getWriter();
		
		//out.println("<html>");
		//out.println("<body>");
		//out.println("Primeira	servlet" +achaDisciplina);
		//out.println("</body>");
		//out.println("</html>");
	}
	
	
    
    public AdicionarAluno() {
        super();
        
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
