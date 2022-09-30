package org.banksystem;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;


public class Banking extends CustomersSite {
	
	
	static Scanner scan=new Scanner(System.in);
	public static void main(String[] args) {
		Banking banking=new Banking();
		banking.frontPage();

	}
	public  void frontPage()
	{
		System.out.println("Welcome to Banking System");
		boolean iterate=true;
		int option=0;
		while(iterate)
		{
			System.out.println("Customer    Press 1");
			System.out.println("Exit        Press 2");
			System.out.println("Enter the option");
			option=scan.nextInt();
			if(option==2) {iterate=false;break;}
			switch(option)
			{
			case 1:clientSite();
			break;
			default :System.out.println("Enter the correct one");
			System.out.println();
			}
		}
	}
	
	public  void clientSite()
	{
		boolean iterate=true;
		int check=0,option=0;
		ArrayList<CustomersSite> customerDetails=new ArrayList<>();
		while(iterate)
		{
			System.out.println("Account Create    Press 1");
			System.out.println("Login             Press 2");
			System.out.println("Exit to mainpage  Press 3");
			System.out.println("Enter the option");
			option=scan.nextInt();
			if(option==3)return;
			switch(option)
			{
			case 1:check=accountCreate(customerDetails);
			break;
			case 2:if(check!=0)
			{login(customerDetails);
				break;}
			default :System.out.println("Enter the correct option");
			System.out.println();
			}

		}
	}
	public Banking(String userName, String password, long accountNo, long accountBalance, LocalDate date,
			String mobileNo) {
		super(userName, password, accountNo, accountBalance, date, mobileNo);

	}
	public Banking() {
		// TODO Auto-generated constructor stub
	}

}
