package classes;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ConnectionFactory {
	
	public Statement statement;
	public ResultSet resultset;
	public Connection con = null;

	public	Connection	getConnection() {
		try	{
			
			DriverManager.registerDriver(new com.mysql.jdbc.Driver());
				con = DriverManager.getConnection("jdbc:mysql://localhost/ProjetoBD","root","root123");
		}	catch	(SQLException	e)	{
					e.printStackTrace();
						throw new	RuntimeException(e);
		}	
		 return con;
	}
	
	
	public void ExecutaSql(String sql) {
		
		try {
			statement = con.createStatement(resultset.TYPE_SCROLL_INSENSITIVE,resultset.CONCUR_READ_ONLY);
			resultset = statement.executeQuery(sql);
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
	}
}
