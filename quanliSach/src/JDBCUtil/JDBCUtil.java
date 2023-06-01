package JDBCUtil;

import java.sql.Connection;
import java.sql.DriverManager;

public class JDBCUtil {
private static Connection c;
public static Connection getConnection()
{
	try {
		DriverManager.registerDriver(new com.microsoft.sqlserver.jdbc.SQLServerDriver());
		String url = "jdbc:sqlserver://MSI:1433;databaseName=quanlisach;integratedSecurity=true;";
		c = DriverManager.getConnection(url);
		
	} catch (Exception e) {
		// TODO: handle exception
	}	
	return c;
}

public void close()
{
	try {
		if(c != null)
		{
			c.close();
		}
	} catch (Exception e) {
		// TODO: handle exception
		e.printStackTrace();
	}
}
}
