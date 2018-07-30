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


@WebServlet("/AdicionarNota")
public class AdicionarNota extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	ConnectionFactory conexao = new ConnectionFactory();
	Connection resp;
	
	
	protected	void	service	(HttpServletRequest	request,
					HttpServletResponse	response)
					throws	ServletException,	IOException	{
		
		
		String numero = (String)request.getSession().getAttribute("numero");
		String matricula = (String) request.getParameter("txtMatriculaP");
		String codigo_d = (String)request.getSession().getAttribute("codigo");
		String nota = (String) request.getParameter("txtNotaP");
		
		int codigo_disciplina = Integer.parseInt(codigo_d);
		int numero_prova = Integer.parseInt(numero);
		int matricula_aluno = 0;
		double  nota_aluno = 0;
		
		try {
			
			resp = conexao.getConnection();
			
			if(resp != null && StringUtils.isStrictlyNumeric(matricula) && StringUtils.isStrictlyNumeric(nota)) {
				 matricula_aluno = Integer.parseInt(matricula);
				 nota_aluno = Double.parseDouble(nota);

				 conexao.ExecutaSql("select * from prova_aluno_disciplina  pad where pad.codigo_p = '"+numero_prova+"'"+"and pad.codigo_d = '"+codigo_disciplina+"'"+"and pad.codigo_a =  '"+matricula_aluno+"'");
			
				
				if(!conexao.resultset.first()) {
					
					PreparedStatement pst = resp.prepareStatement("insert into prova_aluno_disciplina (codigo_p,codigo_a,codigo_d,nota) values(?,?,?,?)");
					pst.setInt(1,numero_prova);
					pst.setInt(2,matricula_aluno);
					pst.setInt(3,codigo_disciplina);
					pst.setDouble(4,nota_aluno);
					pst.execute();
					response.sendRedirect("sobre_prova.jsp");
				}else {
					response.sendRedirect("sobre_prova.jsp");
				}
				
			}else {
				response.sendRedirect("sobre_prova.jsp");
			}
				} catch (SQLException e) {
					
					e.printStackTrace();
				
				
			}
		
		
		
	}
	
	
	
   
    public AdicionarNota() {
        super();
       
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
