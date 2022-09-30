package hotalSystem;

import java.util.ArrayList;
import java.util.Scanner;

public class OwnerSite extends CustomerSite {
    private String ownerPassword=null;
    public void OwnerView(ArrayList<Foods> foodDetails, ArrayList<Bills> bills) {

        Scanner scan=new Scanner(System.in);
        System.out.println("Enter the Password");
        boolean bool=true;
        while(bool)
        {
            String password=scan.next();
            if(password.equals(ownerPassword))break;
            else System.out.println("Enter the correct password");
        }

        bool=true;
        byte option=0;
        while(bool)
        {
            System.out.println("View Bills            Press 1");
            System.out.println("View Food Details     Press 2");
            System.out.println("Exit                  Press 3");
            option=scan.nextByte();
            if(option==3) {bool=false;break;}
            switch(option)
            {
                case 1:showBill(bills,2);
                    break;
                case 2:viewFoodDetails(foodDetails);
                    break;
                default:System.out.println("Enter the coorect one");
            }

        }

    }
    public void owners()
    {
        ownerPassword="hentry123";
    }
}
