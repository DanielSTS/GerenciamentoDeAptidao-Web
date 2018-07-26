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


@WebServlet("/CadastraDisciplina")
public class CadastraDisciplina extends HttpServlet {
	private static final long serialVersionUID = 1L;
     
	ConnectionFactory conexao = new ConnectionFactory();
	Connection resp;
	
	protected	void	service	(HttpServletRequest	request,
					HttpServletResponse	response)
					throws	ServletException,	IOException	{
		
		String nome,codigo,achaDisciplina = "nenhum";
		nome = request.getParameter("txtNome");
		codigo = request.getParameter("txtCodigo");
		
		try {
			
		resp = conexao.getConnection();
		if(resp != null) {
			conexao.ExecutaSql("select * from disciplina where nome='"+nome+"'");
			
			
			if(!conexao.resultset.first()) {
				PreparedStatement pst = resp.prepareStatement("insert into disciplina (codigo,nome) values(?,?)");
				pst.setString(1,codigo);
				pst.setString(2,nome);
				pst.execute();
				response.sendRedirect("sucesso_cadastro.jsp");
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
	
	
    
    public CadastraDisciplina() {
        super();
        
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
