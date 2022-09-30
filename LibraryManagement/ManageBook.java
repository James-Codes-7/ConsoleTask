package librarymanagement;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class ManageBook extends ManageUser {



    public ManageBook() {
        super();
    }

    private void addBook() {
        Scanner scan = new Scanner(System.in);
        int bookId = 0;
        System.out.println("Enter the book Id");
        bookId = scan.nextInt();
        scan.nextLine();
        System.out.println("Enter the Book Name");
        String bookName = scan.nextLine();

        System.out.println("Enter the Auther name");
        String autherName = scan.nextLine();
        bookId = bookAutherCheck(bookName, autherName);
        System.out.println("Enter the quatity");
        int quantity = scan.nextInt();

        if (bookId > bookList.size() + bookIdStart - 1) {
            System.out.println();

            System.out.println("Enter the book rate");
            int rate = scan.nextInt();

            int count = jdbcUpdate("insert into booklist values(" + bookId + ",'" + bookName + "','" + autherName + "',"
                    + quantity + "," + rate + ")");
            bookList.add(new BookList(bookId, bookName, autherName, quantity, rate));
        } else {
            int count = jdbcUpdate("update booklist set stack=" + (bookList.get(bookId - 1001).bookStack + quantity)
                    + " where bookid=" + bookId);
        }

        System.out.println("Sucess Fully deleted");
        System.out.println();

    }

    private void deleteBook(){
        Scanner scan=new Scanner(System.in);
        System.out.println("Enter the book Id");
        int bookId=scan.nextInt();

            if(bookIdCheck(bookId))
            {
                int count=jdbcUpdate("delete from booklist where bookid="+bookId);
                System.out.println("SuccessFully Deleted");return;
            }
        System.out.println("Not Deleted");

    }

    private void showBookList() {

            System.out.println();
            try {

                ResultSet result =  jdbcRetrive("select * from booklist");
                while (result.next()) {
                    System.out.printf("Book Id:" + result.getInt(1) + "\t\tBook Name:" + result.getString(2) + ""
                            + "\t\tAuther Name:" + result.getString(3) + "\t\tBook Stack:" + result.getInt(4) + ""
                            + "\t\tBook Rate:" + result.getInt(5) + "\n");
                    System.out.println();
                }

            } catch (SQLException e) {

                e.printStackTrace();
            }

        }

    public void manageBook()
    {
        Scanner scan=new Scanner(System.in);
        boolean bool=true;
        byte option=0;
        while (bool)
        {
            System.out.println("View Book List          Press 1");
            System.out.println("Add  book               Press 2");
            System.out.println("Delete the Book         Press 3");
            System.out.println("Exit                    Press 4");
            option=scan.nextByte();
            if(option==4){bool=false;return;}
            switch (option)
            {
                case 1:showBookList();break;
                case 2:addBook();break;
                case 3:deleteBook();break;
                default:
                    System.out.println("Enter the valid one");
            }
        }
    }

}
