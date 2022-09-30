package librarymanagement;

public class UserList  extends BookList{
    int userId;
    String userName;
    long mobileno;
    UserList(int userId,String userName,long mobileno)
    {

        this.userId=userId;
        this.userName=userName;
        this.mobileno=mobileno;
    }

    public UserList() {

    }
}
