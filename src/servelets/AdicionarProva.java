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


@WebServlet("/AdicionarProva")

public class AdicionarProva extends HttpServlet{
private static final long serialVersionUID = 1L;
    
	ConnectionFactory conexao = new ConnectionFactory();
	Connection resp;
	
	protected	void	service	(HttpServletRequest	request,
					HttpServletResponse	response)
					throws	ServletException,	IOException	{
		
		String assunto,numero,matricula_professor,codigo_d;
		assunto = request.getParameter("txtAssunto");
		numero = request.getParameter("txtNumero");
		matricula_professor = request.getParameter("txtMatricula_Professor");
		codigo_d = request.getParameter("txtCodigo_D");
		
		
		
		try {
			
		resp = conexao.getConnection();
		
		if(resp != null) {
			conexao.ExecutaSql("select * from disciplina where numero='"+numero+"'");
			
			
			if(!conexao.resultset.first()) {
				PreparedStatement pst = resp.prepareStatement("insert into disciplina (assunto,numero,matricula_professor,codigo_d) values(?,?,?,?)");
				pst.setString(1,assunto);
				pst.setInt(3,Integer.parseInt(numero));
				pst.setInt(3,Integer.parseInt(matricula_professor));
				pst.setInt(4,Integer.parseInt(codigo_d));
				
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
	
	
    
    public AdicionarProva() {
        super();
        
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}
