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


@WebServlet("/AdicionarAluno")

public class AdicionarAluno extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	ConnectionFactory conexao = new ConnectionFactory();
	
	Connection resp;
	
	protected	void	service	(HttpServletRequest	request,
					HttpServletResponse	response)
					throws	ServletException,	IOException	{
		
		String nome,curso,sexo;
		nome = request.getParameter("txtNome");
		curso = request.getParameter("txtCurso");
		sexo = request.getParameter("sexo");
		
		
		String codigo_d = (String)request.getSession().getAttribute("codigo");
		String mat = (String) request.getParameter("txtMatricula");
		
		int matricula = 0, codigo_disciplina = 0;
		
		if(StringUtils.isStrictlyNumeric(mat)){
			
			 codigo_disciplina = Integer.parseInt(codigo_d);
			
			 matricula = Integer.parseInt(mat);

			 
			 ConnectionFactory con = new ConnectionFactory();
			 con.getConnection();
			 con.ExecutaSql("select * from aluno_disciplina where aluno_disciplina.codigo_a = '"+matricula+"'"+"and aluno_disciplina.codigo_d ='"+codigo_disciplina+"'");

			
				try {
					if(con.resultset.first()){

					 	response.sendRedirect("sobre_disciplina.jsp");
					 }else {
						 ConnectionFactory conexao_teste = new ConnectionFactory();
						 resp = conexao_teste.getConnection();

						 conexao_teste.ExecutaSql("select * from aluno where aluno.matricula='"+matricula+"'");
							
						
						if(!conexao_teste.resultset.first()) {
						
							PreparedStatement pst = resp.prepareStatement("insert into aluno (nome,curso,matricula,sexo) values(?,?,?,?)");
							pst.setString(1,nome);
							pst.setString(2,curso);
							pst.setInt(3,matricula);
							pst.setString(4,sexo);
							pst.execute();
						}
					
						PreparedStatement pst2 = resp.prepareStatement("insert into aluno_disciplina (codigo_a,codigo_d) values(?,?)");
						
						pst2.setInt(1,matricula);
						pst2.setInt(2,codigo_disciplina);
						pst2.execute();
						
						response.sendRedirect("sobre_disciplina.jsp");
							
						}
				} catch (SQLException e) {
					
					e.printStackTrace();
				}
					 
					 
					 
					 
				 
			
		}else{
				response.sendRedirect("sobre_disciplina.jsp");
		}

	
		
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
