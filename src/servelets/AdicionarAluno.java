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
	ConnectionFactory conexao_teste = new ConnectionFactory();
	Connection resp;
	
	protected	void	service	(HttpServletRequest	request,
					HttpServletResponse	response)
					throws	ServletException,	IOException	{
		
		String nome,curso,mat;
		nome = request.getParameter("txtNome");
		curso = request.getParameter("txtCurso");
		mat = request.getParameter("txtMatricula");
		
		String codigo_d = (String)request.getSession().getAttribute("codigo");
		
		int matricula = Integer.parseInt(mat);
		int codigo_disciplina = Integer.parseInt(codigo_d);
		
		//int codigo_disciplina = Integer.parseInt(codigo_d);
		
		
		try {
			
		resp = conexao.getConnection();
		
		if(resp != null ) {
			
			
			conexao.ExecutaSql("select * from aluno_disciplina where aluno_disciplina.codigo_a='"+matricula+"'" );
			//			conexao.ExecutaSql("select * from aluno_disciplina where aluno_disciplina.codigo_a='"+matricula+"'" +"and aluno_disciplina.codigo_d='"+codigo_disciplina+"'" );
			
			
			
			if(!conexao.resultset.first()){
				
				conexao_teste.ExecutaSql("select * from aluno where aluno.matricula='"+matricula+"'");
				PreparedStatement pst = resp.prepareStatement("insert into aluno (matricula,curso,nome) values(?,?,?)");
				
				pst.setInt(1,matricula);
				pst.setString(2,curso);
				pst.setString(3,nome);
				pst.execute();
			}
				
				
			PreparedStatement pst2 = resp.prepareStatement("insert into aluno_disciplina (codigo_a,codigo_d) values(?,?)");
			
			pst2.setInt(1,matricula);
			pst2.setInt(2,codigo_disciplina);
			pst2.execute();
			
			response.sendRedirect("sobre_disciplina.jsp");
				
		}else {
			response.sendRedirect("falha_cadastro.jsp");
		}
		
		
	}catch (SQLException e) {
				
				response.sendRedirect("falha_cadastro.jsp");
				e.printStackTrace();
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
