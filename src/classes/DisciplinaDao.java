package classes;

import java.util.List;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;


public class DisciplinaDao	{
	//	a	conexão	com	o	banco	de	dados
	private Connection	connection;
	
	public	DisciplinaDao() {
					this.connection	=	new	ConnectionFactory().getConnection();
	}
	
	
	public	void	adiciona(Disciplina	disciplina) {
		String	sql	=	"insert	into	disciplina	"	+
										"(nome,codigo)"	+
										"	values	(?,?)";
		try	{
						//	prepared	statement	para	inserção
						PreparedStatement	stmt	=	connection.prepareStatement(sql);
						//	seta	os	valores
						stmt.setString(1,disciplina.getNome());
						stmt.setInt(2,disciplina.getCodigo());
					
					
						//	executa
						stmt.execute();
						stmt.close();
		}	catch	(SQLException	e)	{
						throw new	RuntimeException(e);
			}
	}
	
	public	void	remove(Disciplina disciplina) {
		try	{
						PreparedStatement	stmt	=	connection
														.prepareStatement("delete	from	alunos	where	codigo=?");
						stmt.setInt(1,disciplina.getCodigo());
						stmt.execute();
						stmt.close();
		}	catch	(SQLException	e)	{
						throw new	RuntimeException(e);
			}	
	}
	
}