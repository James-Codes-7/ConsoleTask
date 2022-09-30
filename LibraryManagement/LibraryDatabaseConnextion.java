package librarymanagement;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class LibraryDatabaseConnextion
{
    Statement statement=null;
    public  Statement jdbcConnection()  {



        try
        {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection connection= DriverManager.getConnection("jdbc:mysql:"
                            + "//localhost:3306/library?useSSL=false",
                    "root","James124@");
            if (statement==null)
            {
                statement=connection.createStatement() ;return statement;}
            return statement;
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }

        return null;

    }

    public ResultSet jdbcRetrive(String query)
    {
        if(statement==null){ System.out.println("Data base not connect");return null;}
        try {
            return statement.executeQuery(query);
        }
        catch (Exception e)
        {
           e.printStackTrace();
        }
        return null;
    }

    public int jdbcUpdate(String query)
    {
        if(statement==null){ System.out.println("Data base not connect");return 0;}
        try {
            return statement.executeUpdate(query);
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
       return 0;
    }
}
