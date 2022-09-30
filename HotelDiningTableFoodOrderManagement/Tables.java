package hotalSystem;

import java.util.ArrayList;
import java.util.Scanner;

public class Tables extends  FoodOrder{



    public void table1(ArrayList<Foods> foodDetails, ArrayList<Bills> bills, String tables)
    {

        tableOrderDetails(foodDetails,tables,bills);

    }
    private void tableOrderDetails(ArrayList<Foods> foodDetails,String table, ArrayList<Bills> bills)
    {
        System.out.println("View  Food  Details");
        boolean bool=true;
        int option=0;
        int totalAmount=0;
        conform=0;
        Scanner scan=new Scanner(System.in);
        ArrayList<FoodOrderDetails> foodOrder=new ArrayList<>();
        int check=0;
        while(bool)
        {
            System.out.println();
            System.out.println("Food Order    Press 1");
            System.out.println("Pay Bill      Press 2");
            System.out.println("Exit          Press 3");
            option=scan.nextByte();
            switch(option)
            {
                case 1:totalAmount+=foodOrder(foodDetails,foodOrder);break;
                case 2:if(conform>0)payBill(foodOrder,bills,totalAmount,table);
                else  System.out.println("Order First");
                    break;
                case 3:if(conform!=0) {System.out.println("Please Pay the Bill");}
                else {bool=false;return;}
            }
        }
    }
}
