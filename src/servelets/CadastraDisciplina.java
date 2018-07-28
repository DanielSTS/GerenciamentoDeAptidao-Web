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


@WebServlet("/CadastraDisciplina")
public class CadastraDisciplina extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
     
	ConnectionFactory conexao = new ConnectionFactory();
	Connection resp;
	
	protected	void	service	(HttpServletRequest	request,
					HttpServletResponse	response)
					throws	ServletException,	IOException	{
		
		String nome,codigo;
		nome = request.getParameter("txtNome");
		codigo = request.getParameter("txtCodigo");
		
		String matricula = (String)request.getSession().getAttribute("matricula");
		
	
		
		
		
		try {
			
		resp = conexao.getConnection();
		
		if(resp != null && StringUtils.isStrictlyNumeric(codigo) ) {
			conexao.ExecutaSql("select * from disciplina where codigo='"+codigo+"'");
			
			
			if(!conexao.resultset.first() ) {
				PreparedStatement pst = resp.prepareStatement("insert into disciplina (codigo,nome,matricula_professor) values(?,?,?)");
				pst.setInt(1,Integer.parseInt(codigo));
				pst.setString(2,nome);
				pst.setInt(3,Integer.parseInt(matricula));

				
				pst.execute();
				response.sendRedirect("opcoes_disciplina.jsp");
			}else {
				response.sendRedirect("falha_cadastro.jsp");
			}
			
		}else {
			response.sendRedirect("falha_cadastro.jsp");
		}
			} catch (SQLException e) {
				
				e.printStackTrace();
				
		}
		
		PrintWriter	out	=	response.getWriter();
		
	
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
