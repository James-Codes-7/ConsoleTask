package librarymanagement;

import java.util.ArrayList;

public class LoginController  extends  LibraryDatabaseConnextion{

      int adminId;
     String adminPassword;
     int userStart=10101;
     int bookIdStart=1001;
    	static ArrayList<BookList> bookList=new ArrayList<>();
     static ArrayList<Integer> userid=new ArrayList<>();
    public boolean bookIdCheck(int bookId)
    {
        for(BookList book:bookList)
        {
            if(book.BookId==bookId)
            {

                return true;
            }
        }
        return false;
    }
    public void adminLoad()
    {
        adminId=12345;
        adminPassword="Ruthrac123";
    }
    public int bookAutherCheck(String bookName, String autherName)
    {
        for(BookList book:bookList)
        {
            if(book.bookName.equals(bookName)&&book.bookAuther.equals(autherName))
            {
                return book.BookId;
            }
        }
        return bookList.size()+bookIdStart;
    }
    public boolean userIdCheck(int userId)
    {
        for(Integer user:userid)
        {
            if(user==userId)
            {
                System.out.println("The user Already here");return true;
            }
        }
        return false;
    }
}
