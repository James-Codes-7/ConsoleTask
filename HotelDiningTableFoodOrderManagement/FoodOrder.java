package hotalSystem;

import java.util.ArrayList;
import java.util.Scanner;

public class FoodOrder  extends  Billing{
    public FoodOrder() {
        super();
    }

    public int foodOrder(ArrayList<Foods> foodDetails,
                         ArrayList<FoodOrderDetails> foodOrder)
    {
        Scanner scan=new Scanner(System.in);
        int foodId=0,foodQuanity=0;
        boolean  bool=true;
        System.out.println();

        viewFoodDetails(foodDetails);
        byte option=1;
        int totalAmount=0;
        while(bool)
        {
            System.out.println("Enter the food Id");
            foodId=scan.nextInt();
            if(foodId<1001||foodId>foodDetails.size()+1000) {System.out.println("Wrong "
                    + "food id");continue;}
            System.out.println("Enter the Food Quantity");
            foodQuanity=scan.nextInt();
            if(foodQuentityCheck(foodDetails, foodQuanity, foodId)) {System.out.println("Actual food quantity Less than"
                    + "Your order quantity Sorry");continue;}
            Foods order=foodDetails.get(foodId-1001);
            foodOrder.add(new FoodOrderDetails(order.foodId, order.foodName, order.rate,foodQuanity
                    ,foodQuanity*order.rate));
            order.quantity-=foodQuanity;
            totalAmount+=foodQuanity*order.rate;

            System.out.println("Continue Order Press 1");
            option=scan.nextByte();
            if(option==1)continue;
            else break;
        }
        System.out.println("Order SuccessFull");

        System.out.println("Get Your Food");
        conform++;
        return totalAmount;

    }


}
