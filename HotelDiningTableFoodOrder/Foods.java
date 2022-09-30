package hotaldiningtablefoodordermanagement;

import java.util.ArrayList;

public class Foods {

	int foodId=0;
	String foodName;
	int quantity;
	int rate;
	
	
	public ArrayList<Foods> foodFill()
	{
		ArrayList<Foods> foods=new ArrayList<>();
		foods.add(new Foods(1001,"Idly",50,10));
		foods.add(new Foods(1002,"Dhosa",50,15));
		foods.add(new Foods(1003,"Poori",50,5));
		foods.add(new Foods(1004,"sapathi",50,15));
		foods.add(new Foods(1005,"Briyani",100,120));
		return foods;
	}
	public Foods(int id,String foodName,int quentity,int rate)
	{
		this.foodId=id;
		this.foodName=foodName;
		this.quantity=quentity;
		this.rate=rate;
	}
	public Foods()
	{
		
	}
}
