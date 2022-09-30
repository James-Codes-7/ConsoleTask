package librarymanagement;

import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Scanner;

public class ManageUser  extends UserList{

      ArrayList<UserList> userLists=new ArrayList<>();

    public ManageUser() {
        super();
    }

    public void assignBookToUser()
    {

        Scanner scan=new Scanner(System.in);
        System.out.println("Enter the user Id");
        int userId=scan.nextInt();
        if(!userIdCheck(userId)) {System.out.println("Cannot Identify user Id");return;}

        System.out.println("Enter the Book Id");
        int bookId=scan.nextInt();
        if(bookIdCheck(bookId)) {System.out.println("Cannot Identify the book");return;}

              int count=jdbcUpdate("insert into bookassignlist(bookid,userid,bookassigndate)"
                + " values("+bookId+","+userId+",'"+(java.time.LocalDate.now()).toString()+"')");
        System.out.println("SuccessFully assign");
    }
    public void addUser()
    {
        Scanner scan=new Scanner(System.in);
        System.out.println("Enter the user Id");
        int Id=scan.nextInt();
        if(userIdCheck(Id)) System.out.println("Cannot add");
        scan.nextLine();
        System.out.println("Enter the user name");
        String userName=scan.nextLine();
        System.out.println("Enter the user Mobile number");
        long mobileno=scan.nextLong();

        Statement st=jdbcConnection();

        int count=jdbcUpdate("insert into libraryuser values("+(userid.size()+userStart)+",'"
                              + userName+"',"+mobileno+")");

        System.out.println("SucessFully added");
    }
     private void viewUser()
     {
         Scanner scan=new Scanner(System.in);
         System.out.println("Enter the user Id");
         int userId=scan.nextInt();
          if(userId==userid.get(userId-userStart))
          { System.out.println("The Id is wrong"); return;}
          UserList user=userLists.get(userId-userStart);
         System.out.println("User ID:"+user.userId+" User Name:"+user.userName+" User phoneno:"+user.mobileno);
     }
     private void viewUserList()
     {
         for(UserList user:userLists)
         {
             System.out.println("User ID:"+user.userId+" User Name:"+user.userName+" User phoneno:"+user.mobileno);
         }
     }
    public void manageUser()
    {
        Scanner scan=new Scanner(System.in);
        boolean bool=true;
        byte option=0;

        while(bool)
        {
            System.out.println("View User                   Press 1");
            System.out.println("Add User                    Press 2");
            System.out.println("Assign Book User            Press 3");
            System.out.println("View User List              Press 4");
            System.out.println("Exit                        Press 5");
            System.out.println("Enter the option");
            option=scan.nextByte();
            if(option==5){bool=false;return;}
            switch (option)
            {
                case 1:viewUser();
                break;
                case 2:addUser();
                break;
                case 3:assignBookToUser();
                break;
                case 4:viewUserList();
                break;
                default:
                    System.out.println("Enter the valid one");

            }
        }
    }

}
