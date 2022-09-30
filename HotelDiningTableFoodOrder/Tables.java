package hotaldiningtablefoodordermanagement;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Scanner;

public class Tables extends Foods {


	static int conform=0;
	static int billId=0;

	public void table1(ArrayList<Foods> foodDetails, ArrayList<Bills> bills, String tables)
	{

		tableOrderDetails(foodDetails,tables,bills);

	}
	public void tableOrderDetails(ArrayList<Foods> foodDetails,String table, ArrayList<Bills> bills)
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
	public void payBill(ArrayList<FoodOrderDetails> foodOrder, ArrayList<Bills> bills, 
			int totalAmount, String table)
	{
		bills.add(new Bills(++billId, table, totalAmount, foodOrder,java.time.LocalDateTime.now()));
		System.out.println("Your Bill");
		showBill(bills,1);

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
			System.out.printf(foods.foodId+"\t\t"+foods.foodName+
					"\t\t"+foods.foodrate+"\t\t"+foods.foodQuentity+"\t\t"+foods.totalRate+"\n");
		}
	}
	public int foodOrder(ArrayList<Foods> foodDetails, 
			ArrayList<FoodOrderDetails> foodOrder)
	{
		Scanner scan=new Scanner(System.in);
		int foodId=0,foodQuanity=0;
		boolean  bool=true;
		System.out.println();
		System.out.println("Food Id         Food Name       Food Rate       foodQuentity");
		for(Foods foods:foodDetails)
		{
			System.out.printf(foods.foodId+"\t\t"+foods.foodName+
					"\t\t"+foods.rate+"\t\t"+foods.quantity+"\n");
		}
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
	public void viewFoodDetails(ArrayList<Foods> foodDetails)
	{
	  System.out.println();
		System.out.println("Food Id         Food Name       Food Rate       foodQuentity");
		for(Foods foods:foodDetails)
		{
			System.out.printf(foods.foodId+"\t\t"+foods.foodName+
					"\t\t"+foods.rate+"\t\t"+foods.quantity+"\n");
		}
	}
	public boolean   foodQuentityCheck(ArrayList<Foods> foodDetails, int foodQuanity, int foodId)
	{
		Foods foods=foodDetails.get(foodId-1001);
		return foods.quantity<=foodQuanity;
	}
}
class FoodOrderDetails
{
	int foodId;
	String foodName;
	int foodrate;
	int foodQuentity;
	int totalRate;

	public FoodOrderDetails(int foodid,String FoodName,int foodrate,int foodQuentity,
			int totalRate)
	{
		this.foodId=foodid;
		this.foodName=FoodName;
		this.foodrate=foodrate;
		this.foodQuentity=foodQuentity;
		this.totalRate=totalRate;
	}
}
class Bills
{
	int billId;
	String tableName;
	LocalDateTime date;
	int totalBillAmount;
	ArrayList<FoodOrderDetails>  foodorders;

	public Bills(int billId,String tableName,int totalBillAmount,
			ArrayList<FoodOrderDetails>  foodorders,LocalDateTime loc)
	{
		this.billId=billId;
		this.tableName=tableName;
		this.totalBillAmount=totalBillAmount;
		this.foodorders=foodorders;
		this.date=loc;

	}


}