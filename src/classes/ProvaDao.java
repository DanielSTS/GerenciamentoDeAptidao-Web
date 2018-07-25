package classes;

import java.util.List;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;


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
	
}