package librarymanagement;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Scanner;

public class Admin  extends ManageBook
{




    public Admin() {
        super();
    }

    public void admin()
        {
            Scanner scan=new Scanner(System.in);
            System.out.println("Enter the admin Id");
            boolean bool=true;
            int adminid=0;
            String password="";
            f1:while(bool)
            {
                adminid=scan.nextInt();
                while(adminid==adminId)
                {
                    System.out.println("Enter the password");
                    password=scan.next();
                    if(adminPassword.equals(password))
                    {
                        System.out.println("Welcome to Admin Page");
                        bool=false;
                        break f1;
                    }
                    else System.out.println("Wrong Pssword");
                }
                System.out.println("Enter the correct Id");

            }

            bool=true;
            byte option=0;

            while(bool)
            {

                System.out.println("Manage Book                  Press 1");
                System.out.println("Manage User                  Press 2");
                System.out.println("Exit                         Press 3");
                option=scan.nextByte();
                if(option==3) {bool=false;break;}
                switch(option)
                {
                    case 1:manageBook();
                        break;
                    case 2:manageUser();
                    break;
                    default:System.out.println("Enter the valid one");
                }
            }
        }
        public void libraryStart()
        {
            Statement statement=jdbcConnection();
            try {
                ResultSet result=statement.executeQuery("select * from booklist");
                while(result.next())
                {
                    bookList.add(new BookList(result.getInt(1),result.getString(2),result.getString(3)
                            ,result.getInt(4),result.getInt(5)));
                }
                result=statement.executeQuery("select * from libraryuser");
                while(result.next())
                {
                    userid.add(result.getInt(1));
                    userLists.add(new UserList(result.getInt(1),result.getString(2),result.getLong(3)
                    ));
                }
            } catch (SQLException e) {

                e.printStackTrace();
            }
        }
    }
