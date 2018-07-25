package classes;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;


public class ProvaDao	{
	//	a	conexão	com	o	banco	de	dados
	private Connection	connection;
	
	public	ProvaDao() {
					this.connection	=	new	ConnectionFactory().getConnection();
	}
	
	
	public	void	adiciona(Prova	prova) {
		String	sql	=	"insert	into	prova	"	+
										"(numero,assunto)"	+
										"	values	(?,?,?)";
		try	{
						//	prepared	statement	para	inserção
						PreparedStatement	stmt	=	connection.prepareStatement(sql);
						//	seta	os	valores
						stmt.setInt(1,prova.getNumero());
						stmt.setString(2,prova.getAssunto());
					
					    //	executa
						stmt.execute();
						stmt.close();
		}	catch	(SQLException	e)	{
						throw new	RuntimeException(e);
			}
	}
	
	public	void	remove(Prova prova) {
		try	{
						PreparedStatement	stmt	=	connection
														.prepareStatement("delete	from	alunos	where	numero=?");
						stmt.setInt(1,	prova.getNumero());
						stmt.execute();
						stmt.close();
		}	catch	(SQLException	e)	{
						throw new	RuntimeException(e);
			}	
	}
	
}