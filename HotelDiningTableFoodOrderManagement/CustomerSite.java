package hotalSystem;

import java.util.ArrayList;
import java.util.Scanner;

public class CustomerSite extends  Tables {

    public void customerView(ArrayList<Foods> foodDetails, ArrayList<Bills> bills)
    {
        Scanner scan=new Scanner(System.in);
        boolean bool=true;
        byte option=0;
        String tables[]= {"Tittan","wood","corner","tytus","party"};

        System.out.println();
        System.out.println("Select the table");
        System.out.println();
        for(int i=0;i<tables.length;i++)
            System.out.printf(tables[i]+"\t\t\tPress "+(i+1)+"\n");
        System.out.println("Enter the option");
        option=scan.nextByte();
        switch(option)
        {

            case 1:table1(foodDetails,bills,tables[option-1]);
                break;
            case 2:table1(foodDetails,bills,tables[option-1]);
                break;
            case 3:table1(foodDetails,bills,tables[option-1]);
                break;
            case 4:table1(foodDetails,bills,tables[option-1]);
                break;
            case 5:table1(foodDetails,bills,tables[option-1]);
                break;
            default : System.out.println("Enter the corectOne");

        }
    }
}
