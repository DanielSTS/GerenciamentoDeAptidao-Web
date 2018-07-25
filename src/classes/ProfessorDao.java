package classes;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;


public class ProfessorDao	{
	//	a	conexão	com	o	banco	de	dados
	private Connection	connection;
	
	public	ProfessorDao() {
					this.connection	=	new	ConnectionFactory().getConnection();
	}
	
	
	public	void	adiciona(Professor	professor) {
		String	sql	=	"insert	into	professor	"	+
										"(nome,email,matricula,dataNascimento,titulacao,sexo,areaDeFormacao,senha)"	+
										"	values	(?,?,?,?,?,?,?,?)";
		try	{
						//	prepared	statement	para	inserção
						PreparedStatement	stmt	=	connection.prepareStatement(sql);
						//	seta	os	valores
						stmt.setString(1,professor.getNome());
						stmt.setString(2,professor.getEmail());
						stmt.setInt(3,professor.getMatricula());
						stmt.setString(4,professor.getDataNascimento());
						stmt.setString(5,professor.getTitulacao());
						stmt.setString(6,professor.getSexo());
						stmt.setString(7,professor.getAreaDeFormacao());
						stmt.setString(8,professor.getSenha());
					
						//	executa
						stmt.execute();
						stmt.close();
		}	catch	(SQLException	e)	{
						throw new	RuntimeException(e);
			}
	}
	
}