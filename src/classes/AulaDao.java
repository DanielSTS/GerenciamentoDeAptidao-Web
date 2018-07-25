package classes;

import java.util.List;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;


public class AulaDao	{
	//	a	conexão	com	o	banco	de	dados
	private Connection	connection;
	
	public	AulaDao() {
					this.connection	=	new	ConnectionFactory().getConnection();
	}
	
	
	public	void	adiciona(Aula	aula) {
		String	sql	=	"insert	into	aula	"	+
										"(numero,assunto,material)"	+
										"	values	(?,?,?)";
		try	{
						//	prepared	statement	para	inserção
						PreparedStatement	stmt	=	connection.prepareStatement(sql);
						//	seta	os	valores
						stmt.setInt(1,aula.getNumero());
						stmt.setString(2,aula.getAssunto());
						stmt.setString(3,aula.getMaterial());
					
					
					
						//	executa
						stmt.execute();
						stmt.close();
		}	catch	(SQLException	e)	{
						throw new	RuntimeException(e);
			}
	}
	
	public	void	remove(Aula aula) {
		try	{
						PreparedStatement	stmt	=	connection
														.prepareStatement("delete	from	alunos	where	numero=?");
						stmt.setInt(1,	aula.getNumero());
						stmt.execute();
						stmt.close();
		}	catch	(SQLException	e)	{
						throw new	RuntimeException(e);
			}	
	}
	
}