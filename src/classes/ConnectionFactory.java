package classes;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import com.mysql.jdbc.Driver;

public class ConnectionFactory {

	public	Connection	getConnection() {
		try	{
			
			DriverManager.registerDriver(new com.mysql.jdbc.Driver());
				return	DriverManager.getConnection("jdbc:mysql://localhost/ProjetoBD","root",	"root123");
		}	catch	(SQLException	e)	{
					e.printStackTrace();
			throw new	RuntimeException(e);
		}	

	}
}
