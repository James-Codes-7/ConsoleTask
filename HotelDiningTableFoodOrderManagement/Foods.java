package hotalSystem;

import java.util.ArrayList;

public class Foods {
   public int foodId=0;
   public String foodName;
   public int quantity;
   public int rate;


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
    public Foods(){}

    public void viewFoodDetails(ArrayList<Foods> foodDetails)
    {
        System.out.println();
        System.out.println("Food Id         Food Name       Food Rate       foodQuentity");
        for(Foods foods:foodDetails)
        {
            System.out.printf(foods.foodId+"\t\t\t"+foods.foodName+
                    "\t\t\t"+foods.rate+"\t\t\t"+foods.quantity+"\n");
        }
    }
    public boolean   foodQuentityCheck(ArrayList<Foods> foodDetails, int foodQuanity, int foodId)
    {
        Foods foods=foodDetails.get(foodId-1001);
        return foods.quantity<=foodQuanity;
    }
}
