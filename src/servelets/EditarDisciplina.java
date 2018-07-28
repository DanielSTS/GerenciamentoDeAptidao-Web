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


@WebServlet("/EditarDisciplina")
public class EditarDisciplina extends HttpServlet {
	private static final long serialVersionUID = 1L;
	ConnectionFactory conexao = new ConnectionFactory();
	Connection resp;
    
	protected	void	service	(HttpServletRequest	request,
			HttpServletResponse	response)
			throws	ServletException,	IOException	{
		
		String nome = request.getParameter("txtNome");
		String codigo = request.getParameter("txtCod");
		
		
		
		
		if(codigo != null && !nome.equals("") && StringUtils.isStrictlyNumeric(codigo)) {
			try {
			resp = conexao.getConnection();

			if(resp!= null) {
				PreparedStatement pst;
				pst = resp.prepareStatement("update disciplina  set codigo =?, nome =? where codigo=? ");
				pst.setInt(1,Integer.parseInt(codigo));
				pst.setString(2,nome);
				pst.setInt(3,Integer.parseInt(codigo));
				pst.execute();
				response.sendRedirect("editar_disciplina.jsp");
			}
			
			}catch (SQLException e) {
				e.printStackTrace();
			}
			
		}else {
			response.sendRedirect("falha_cadastro.jsp");

		}
		
		
		
		
		
		PrintWriter	out	=	response.getWriter();
		
		//out.println("<html>");
		//out.println("<body>");
		out.println("Primeira	servlet");
		//out.println("</body>");
		//out.println("</html>");
		}
	
       
   
    public EditarDisciplina() {
        super();
       
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		doGet(request, response);
	}

}
