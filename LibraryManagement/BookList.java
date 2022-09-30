package librarymanagement;

public class BookList extends  LoginController{

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
    public BookList(){}

}
