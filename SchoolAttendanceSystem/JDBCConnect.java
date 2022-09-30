package attendancesystem;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JDBCConnect {

	public  Statement jdbcConnection()  {



		try
		{
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection connection=DriverManager.getConnection("jdbc:mysql:"
					+ "//localhost:3306/students?useSSL=false",
					"root","James124@");
			connection.close();
			return connection.createStatement();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}

		return null;
  
	}

}
