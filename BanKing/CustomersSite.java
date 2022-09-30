package org.banksystem;


import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;
import java.util.regex.Pattern;

public class CustomersSite extends TransactionsDetails {

	static Scanner scan=new Scanner(System.in);	
	public static long generateAccountNumber=1;
	public String userName;
	public String password;
	public long accountNo;
	public long accountBalance;
	public  LocalDate date;
	public String mobileNo;
	static HashMap<Long,String> loginCheck=new HashMap<>();
	static HashMap<Long,String> passwordChange=new HashMap<>();

	public CustomersSite()
	{
		
	}
	public  int accountCreate(ArrayList<CustomersSite> customerDetails)
	{
		Boolean bool=true;
		String userName="";
		long initialAmount=0;
		String mobileno="";
		String password="";
		byte option=1;

		System.out.println("Enter the customer name");
		System.out.println("The First letter must be Captital And only use letters");
			f1:while(bool)
			{

				userName=scan.nextLine();
				while(nameCheck(userName)&&option==1)
				{
					System.out.println("Your Name is:"+userName);
					System.out.println("If you want change name    Press 1");
					option=scan.nextByte();
					if(option==1) {System.out.println("Re -Enter the name");scan.nextLine();}
					else {bool=false ;continue f1;}
				}
				System.out.println("Enter the Correct format");

			}




		bool=true;
		System.out.println("Enter the Password");
		System.out.println("The Password must be above 8 charcters");
		while(bool)
		{
			password=scan.next();
			if(passwordCheck(password))
			{
				bool=false;
				break;
			}
			else
				System.out.println("Re-Enter the password");
		}



		bool=true;
		option=1;
		System.out.println("Enter the mobileNo");
		System.out.println("Only put numbers and 10 digits only allowed");
		while(bool)
		{
			mobileno=scan.next();
			if(mobileNumberCheck(mobileno))
			{
				System.out.println("Your mobile no:"+mobileno);
				System.out.println("If you want change   Press 1");
				option=scan.nextByte();
				if(option==1) {System.out.println("Re -enter the mobile no");continue;}
				else {bool=false;break;}
			}
			System.out.println("Enter the correct format");
		}


		bool=true;
		System.out.println("Enter the initial Amount");
		System.out.println("Only accepted if amount greater than five hundred");
		while(bool)
		{
			initialAmount=scan.nextLong();
			if(initialAmount>500)
			{
				System.out.println("If you want change intial amount    Press 1");
				option=scan.nextByte();
				if(option==1) {System.out.println("Re -Enter the initial amount");continue;}
				else {bool=false;break;}

			}
			else
			{System.out.println("Enter the valid amount");}
		}

		System.out.println("Your Account number is:"+generateAccountNumber);

		loginCheck.put(generateAccountNumber, password);
		passwordChange.put(generateAccountNumber, mobileno);
		System.out.println("Your Account is created...");
		customerDetails.add(new CustomersSite(userName,password,generateAccountNumber++,initialAmount,java.time.LocalDate.now(),
				mobileno));
		System.out.println();
		return 1;

	}
	public  void login(ArrayList<CustomersSite> customerDetails)
	{
		long accountNo=-1;
		String password="";
		boolean bool=true;
		byte passwordwrongcheck=0;
		System.out.println("Enter the Account number");
		f1:while(bool)
		{
			accountNo=scan.nextLong();
			while(loginCheck.containsKey(accountNo))
			{
				System.out.println("Enter the correct password here");
				password=scan.next();
				if(password.equals(loginCheck.get(accountNo)))
				{
					bool=false;
					break  f1;
				} 
				passwordwrongcheck++;
				if(passwordwrongcheck==3) {goToPasswordChange(customerDetails,accountNo);passwordwrongcheck=0;}
			}
			System.out.println("Enter the correct account no");
		}

		bool=true;
		byte option=0;
		while(bool)
		{


			System.out.println("View Account Balance      Press 1");
			System.out.println("Deposit Money             Press 2");
			System.out.println("Account Transfer          Press 3");
			System.out.println("Transactions History      Press 4");
			System.out.println("Exit                      Press 5");
			option=scan.nextByte();
			switch(option)
			{
			case 1:balanceCheck(accountNo,customerDetails);
			break;
			case 2:depositMoney(accountNo,customerDetails);
			break;
			case 3:accountTransfer(accountNo,
					customerDetails,loginCheck);break;
			case 4:viewTransactionsHistory(accountNo);break;
			case 5:return;
			}
			System.out.println();

		}
	}
	public  boolean nameCheck(String userName)
	{
		return Pattern.matches("[A-Z][^0-9]+", userName);
	}
	public  boolean passwordCheck(String password)
	{
		return Pattern.matches("[^0-9][a-z,A-Z,0-9]{7,}", password);
	}
	public  boolean mobileNumberCheck(String mobileno)
	{
		return Pattern.matches("[0-9]{10}", mobileno);
	}
	public  void goToPasswordChange(ArrayList<CustomersSite> customerDetails
			,long accountno)
	{
		System.out.println("Please Change your password");
		System.out.println();
		String phoneno="";
		boolean bool=true;
		String password="";
		System.out.println("Enter Your phone number");
		while(bool)
		{
			phoneno=scan.next();
			while(passwordChange.get(accountno).equals(phoneno))
			{
				System.out.println("Enter the new password");
				password=scan.next();
				if(passwordCheck(password))
				{
					passwordChanging(customerDetails, accountno,password);
					System.out.println("Password Succesfully Changed");
					return;
				}
				else
				{ System.out.println("Re enter Password");System.out.println();}
			}
		}



	}
	private  void passwordChanging(ArrayList<CustomersSite> customerDetails,
			long accountno,String password)
	{
		for(CustomersSite changeProcess:customerDetails)
		{
			if(changeProcess.accountNo==accountno)
			{
				changeProcess.password=password;
				return;
			}
		}
	}
	public CustomersSite(String userName, String password,long accountNo,long accountBalance, 
			LocalDate date, String mobileNo)
	{
		this.userName=userName;
		this.password=password;
		this.accountNo=accountNo;
		this.accountBalance=accountBalance;
		this.date=date;
		this.mobileNo=mobileNo;
	}
}
