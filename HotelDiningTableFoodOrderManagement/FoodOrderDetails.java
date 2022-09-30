package hotalSystem;

public class FoodOrderDetails extends  Bills{
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

    public FoodOrderDetails() {

    }
}
