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


@WebServlet("/AdicionarAula")

public class AdicionarAula extends HttpServlet{
private static final long serialVersionUID = 1L;
    
	ConnectionFactory conexao = new ConnectionFactory();
	Connection resp;
	
	protected	void	service	(HttpServletRequest	request,
					HttpServletResponse	response)
					throws	ServletException,	IOException	{
		
		String assunto,material;
		
		assunto = request.getParameter("txtAssuntoA");
		material = request.getParameter("txtMaterialA");
		
		String num = (String) request.getParameter("txtNumeroA");
		String codigo_d = (String)request.getSession().getAttribute("codigo");
		int codigo_disciplina = Integer.parseInt(codigo_d);
		int numero = 0 ;
		
		
		
		
		
		try {
			
		resp = conexao.getConnection();
		
		if(resp != null && StringUtils.isStrictlyNumeric(num) ) {
			 numero = Integer.parseInt(num);
			 conexao.ExecutaSql("select * from aula where aula.numero = '"+numero+"'"+"and aula.codigo_d ='"+codigo_disciplina+"'");
			
			
			if(!conexao.resultset.first()) {
				
				PreparedStatement pst = resp.prepareStatement("insert into aula (numero,assunto,material,codigo_d) values(?,?,?,?)");
				pst.setInt(1,numero);
				pst.setString(2,assunto);
				pst.setString(3,material);
				pst.setInt(4,codigo_disciplina);
				pst.execute();
				response.sendRedirect("sobre_disciplina.jsp");
			}else {
				response.sendRedirect("sobre_disciplina.jsp");
			}
			
		}else {
			response.sendRedirect("sobre_disciplina.jsp");
		}
			} catch (SQLException e) {
				
				e.printStackTrace();
			
			
		}
	
	}
	
	
    
    public AdicionarAula() {
        super();
        
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}
