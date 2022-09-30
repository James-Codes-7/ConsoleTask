package hotalSystem;

import java.time.LocalDateTime;
import java.util.ArrayList;

public class Bills extends Foods {
    int billId;
    String tableName;
    LocalDateTime date;
    int totalBillAmount;
    ArrayList<FoodOrderDetails> foodorders;

    public Bills(int billId,String tableName,int totalBillAmount,
                 ArrayList<FoodOrderDetails>  foodorders,LocalDateTime loc)
    {
        this.billId=billId;
        this.tableName=tableName;
        this.totalBillAmount=totalBillAmount;
        this.foodorders=foodorders;
        this.date=loc;

    }

    public Bills() {}
}
