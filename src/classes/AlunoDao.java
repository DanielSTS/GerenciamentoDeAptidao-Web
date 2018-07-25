package classes;

import java.util.List;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;


public class AlunoDao	{
	//	a	conexão	com	o	banco	de	dados
	private Connection	connection;
	
	public	AlunoDao() {
					this.connection	=	new	ConnectionFactory().getConnection();
	}
	
	
	public	void	adiciona(Aluno	aluno) {
		String	sql	=	"insert	into	aluno	"	+
										"(nome,matricula,curso)"	+
										"	values	(?,?,?)";
		try	{
						//	prepared	statement	para	inserção
						PreparedStatement	stmt	=	connection.prepareStatement(sql);
						//	seta	os	valores
						stmt.setString(1,aluno.getNome());
						stmt.setInt(2,aluno.getMatricula());
						stmt.setString(3,aluno.getCurso());
					
					
						//	executa
						stmt.execute();
						stmt.close();
		}	catch	(SQLException	e)	{
						throw new	RuntimeException(e);
			}
	}
	
	public	void	remove(Aluno aluno) {
		try	{
						PreparedStatement	stmt	=	connection
														.prepareStatement("delete	from	alunos	where	matricula=?");
						stmt.setInt(1,	aluno.getMatricula());
						stmt.execute();
						stmt.close();
		}	catch	(SQLException	e)	{
						throw new	RuntimeException(e);
			}	
	}
	
}