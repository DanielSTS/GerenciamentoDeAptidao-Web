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


@WebServlet("/ExcluirDisciplina")
public class ExcluirDisciplina extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	ConnectionFactory conexao = new ConnectionFactory();
	Connection resp;
    
	protected	void	service	(HttpServletRequest	request,
			HttpServletResponse	response)
			throws	ServletException,	IOException	{
		
		String codigo = request.getParameter("txtCod");
		String matricula = (String)request.getSession().getAttribute("matricula");
		
		if(!codigo.equals("") && StringUtils.isStrictlyNumeric(codigo)) {
			try {
			resp = conexao.getConnection();

			if(resp!= null) {
				PreparedStatement pst;
				pst = resp.prepareStatement("delete from disciplina where codigo =? and matricula_professor=?");
				pst.setInt(1,Integer.parseInt(codigo));
				pst.setInt(2,Integer.parseInt(matricula));
				pst.execute();
				response.sendRedirect("excluir_disciplina.jsp");
			}
			}catch (SQLException e) {
				e.printStackTrace();
			}
			
		}else {
			response.sendRedirect("excluir_disciplina.jsp");
			}
		
	}
		

	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ExcluirDisciplina() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
