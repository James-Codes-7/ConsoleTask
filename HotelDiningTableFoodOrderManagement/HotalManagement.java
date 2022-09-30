package hotalSystem;

import java.util.ArrayList;
import java.util.Scanner;

public class HotalManagement extends  OwnerSite{


    public static void main(String[] args) {

        HotalManagement  startHotal=new HotalManagement();

        startHotal.hotalPage();

    }

    public void hotalPage()
    {
        System.out.println("Welcome To Our Hotel");
        ArrayList<Foods> foodDetails=foodFill();
        Scanner scan=new Scanner(System.in);
        boolean bool=true;
        byte option=0;
        System.out.println();
        owners();
        ArrayList<Bills> bills=new ArrayList<>();
        while(bool)
        {

            System.out.println("Customer    Press 1");
            System.out.println("Owner       Press 2");
            System.out.println("Exit        Press 3");
            System.out.println("Enter the option");
            option=scan.nextByte();
            if(option==3) {bool=false ;return;}
            switch(option)
            {
                case 1:customerView(foodDetails,bills);
                    break;
                case 2:OwnerView(foodDetails,bills);
                    break;
                default:System.out.println("Enter the correct one");
            }


        }

    }

}
