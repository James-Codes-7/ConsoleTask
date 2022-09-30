package libraryManagement;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Scanner;

public class Admin extends LibraryDatabaseConnextion {

	static int adminId;
	static String adminPassword;
	static int userStart=10101;
	static int bookIdStart=1001;
    private	static ArrayList<BookList>  bookList=new ArrayList<>();
	private static ArrayList<Integer> userid=new ArrayList<>();
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

			System.out.println("Deleting the book            Press 1");
			System.out.println("Adding book                  Press 2");
			System.out.println("Delete the Book              Press 3");
			System.out.println("Add the user                 Press 4");
			System.out.println("Assign the book to user      Press 5");
			System.out.println("Exit                         Press 6");
			option=scan.nextByte();
			if(option==5) {bool=false;break;}
			switch(option)
			{
			case 1:showBookList();
			break;
			case 2:addBook();
			break;
			case 3:deleteBook();
			break;
			case 4:addUser();
			break;
			case 5:assignBookToUser();
			break;
			default:System.out.println("Enter the valid one");
			}
		}
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
		
		Statement statement=jdbcConnection();
		try
		{
		int count =statement.executeUpdate("insert into bookassignlist(bookid,userid,bookassigndate)"
				+ " values("+bookId+","+userId+","+java.time.LocalDate.now()+")");
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
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
		try
		{
				int count=st.executeUpdate("insert into libraryuser values("+(userid.size()+userStart)+",'"
						+ userName+"',"+mobileno+")");
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		System.out.println("SucessFully added");
	}
	public void deleteBook()
	{
		Scanner scan=new Scanner(System.in);
		System.out.println("Enter the book Id");
		int bookId=scan.nextInt();
		Statement statement=jdbcConnection();
		try
		{
			if(bookIdCheck(bookId))
			{
			int count=statement.executeUpdate("delete from booklist where bookid="+bookId);
			System.out.println("SuccessFully Deleted");return;
			}
		}catch(Exception e)
		{
			e.printStackTrace();
		}
        System.out.println("Not Deleted");

	}
	public void showBookList()
	{
		Statement statement=jdbcConnection();
		System.out.println();
		try {
			ResultSet result=statement.executeQuery("select * from booklist");

			while(result.next())
			{
				System.out.printf("Book Id:"+result.getInt(1)+"\tBook Name:"+result.getString(2)+""
						+ "\tAuther Name:"+result.getString(3)+"\tBook Stack:"+result.getInt(4)+""
						+ "\tBook Rate:"+result.getInt(5)+"\n");
				System.out.println();
			}

		} catch (SQLException e) {

			e.printStackTrace();
		}

	}
	public void addBook()
	{
		Scanner scan=new Scanner(System.in);


		int bookId=0;

		System.out.println("Enter the book Id");
		bookId=scan.nextInt();
		scan.nextLine();
		System.out.println("Enter the Book Name");
		String bookName=scan.nextLine();

		System.out.println("Enter the Auther name");
		String autherName=scan.nextLine();
		bookId=bookAutherCheck(bookName,autherName);
		System.out.println("Enter the quatity");
		int quantity=scan.nextInt();

		Statement st=jdbcConnection();


		try
		{
			if(bookId>bookList.size()+bookIdStart-1)
			{
				System.out.println();

				System.out.println("Enter the book rate");
				int rate=scan.nextInt();

				int count=st.executeUpdate("insert into booklist values("+bookId+",'"+bookName+"','"+autherName+"',"
						+quantity+","+rate+")");
				bookList.add(new BookList(bookId, bookName, autherName, quantity, rate));
			}
			else
			{
				int count=st.executeUpdate("update booklist set stack="+(bookList.get(bookId-1001).bookStack+quantity)
						+" where bookid="+bookId);	
			}
			;
		}catch(Exception e)
		{
			e.printStackTrace();
		}


		System.out.println("Sucess Fully deleted");
		System.out.println();

	}
	//world history 
	//Dhyeya
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
	public void adminLoad()
	{
		adminId=12345;
		adminPassword="Ruthrac123";
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
			}
		} catch (SQLException e) {

			e.printStackTrace();
		}
	}

}
class BookList
{
	int BookId;
	String bookName;
	int bookStack;
	int bookrate;
	String bookAuther;

	public BookList(int bookId,String bookName
			,String bookAuther,int bookStatck,int bookrate)
	{
		this.BookId=bookId;
		this.bookName=bookName;
		this.bookAuther=bookAuther;
		this.bookStack=bookStatck;
		this.bookrate=bookrate;
	}

}
