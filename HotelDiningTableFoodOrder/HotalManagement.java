package hotaldiningtablefoodordermanagement;

import java.util.ArrayList;
import java.util.Scanner;

public class HotalManagement  extends Tables{

	private String ownerPassword=null;
	 	public static void main(String[] args) {
		
		HotalManagement  startHotal=new HotalManagement();
		
		startHotal.hotalPage();

	}
	 	
	public void hotalPage()
	{
		System.out.println("Welcome To Our Hotel");
		ArrayList<Foods>  foodDetails=foodFill();
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
			case 1:customerSite(foodDetails,bills);
			break;
			case 2:OwnerSite(foodDetails,bills);
			break;
			default:System.out.println("Enter the correct one");
			}
			
		
		}
	}
	public void OwnerSite(ArrayList<Foods> foodDetails, ArrayList<Bills> bills) {
				
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
	public void customerSite(ArrayList<Foods> foodDetails, ArrayList<Bills> bills)
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
	public void owners()
	{
		ownerPassword="hentry123";
	}
	
}