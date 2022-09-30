package hotalSystem;

import java.time.LocalDateTime;
import java.util.ArrayList;

public class Billing extends  FoodOrderDetails {
   int  conform=0;
    static int billId=0;
    public Billing() {
        super();
    }

    public void payBill(ArrayList<FoodOrderDetails> foodOrder, ArrayList<Bills> bills,
                        int totalAmount, String table)
    {
        bills.add(new Bills(++billId, table, totalAmount, foodOrder,java.time.LocalDateTime.now()));
        System.out.println("Your Bill");
        showBill(bills,1);
        conform=0;

    }
    public void showBill(ArrayList<Bills> bills, int i)
    {
        if(i==1)
        {
            Bills bill=bills.get(billId-1);
            System.out.println("Your Bill Id :"+bill.billId);
            System.out.println("Your Table   :"+bill.tableName);
            System.out.println("Date And Time:"+bill.date);
            System.out.println();
            foodLineView(bill.foodorders);
            System.out.println("Your Total bill Amount:"+bill.totalBillAmount);
            conform=0;
        }
        else
        {
            System.out.println();
            for(Bills bill:bills)
            {
                System.out.println("Your Bill Id :"+bill.billId);
                System.out.println("Your Table   :"+bill.tableName);
                System.out.println("Date And Time:"+bill.date);
                System.out.println();
                foodLineView(bill.foodorders);
                System.out.println("Your Total bill Amount:"+bill.totalBillAmount);
            }
        }
    }
    public void foodLineView(ArrayList<FoodOrderDetails> foodorders)
    {
        System.out.println("Food Id         Food Name       Food Rate       foodQuentity       amount");
        for(FoodOrderDetails foods:foodorders)
        {
            System.out.printf(foods.foodId+"\t\t\t"+foods.foodName+
                    "\t\t\t"+foods.foodrate+"\t\t\t"+foods.foodQuentity+"\t\t\t"+foods.totalRate+"\n");
        }
    }
}
