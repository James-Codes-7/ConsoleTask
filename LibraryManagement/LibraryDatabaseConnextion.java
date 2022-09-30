package libraryManagement;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class LibraryDatabaseConnextion {

	Statement statement=null;
	public  Statement jdbcConnection()  {


         
		try
		{
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection connection=DriverManager.getConnection("jdbc:mysql:"
					+ "//localhost:3306/library?useSSL=false",
					"root","James124@");
			 return statement ;
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}

		return null;

	}

}
