package org.banksystem;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class TransactionsDetails {

	static Scanner scan=new Scanner(System.in);	
	static ArrayList<DepositHistory> depositeHistory=new ArrayList<>();
	static ArrayList<WithDrawHistory> withdrawHistory=new ArrayList<>();
	public static void balanceCheck(long accountno,
			ArrayList<CustomersSite> customerDetails)
	{
		for(CustomersSite balanceView:customerDetails)
		{
			if(balanceView.accountNo==accountno)
			{
				System.out.println("Your Account balance is:"+balanceView.accountBalance);
				System.out.println();
				return;
			}
		}
	}
	public  void depositMoney(long accountno
			,ArrayList<CustomersSite> customerDetails)
	{
		long amount=0;
		boolean bool=true;
		byte option=0;
		System.out.println("Enter the amount");
		bool=true;
		while(bool)
		{
			amount=scan.nextLong();
			System.out.println("If you want change amount Press 1");
			option=scan.nextByte();
			if(option==1) {System.out.println("Re-Enter amount");System.out.println();}
			else break;
		}
		for(CustomersSite moneyAdd:customerDetails)
		{
			if(moneyAdd.accountNo==accountno)
			{
				moneyAdd.accountBalance+=amount;
				System.out.println("Amount is SuccessFully added");
				depositeHistory.add(new DepositHistory(accountno, amount, 
						java.time.LocalDate.now(), "Depostited",moneyAdd.accountBalance));
				System.out.println();
				return;
			}
		}
		
		
		
	}
	public  void accountTransfer(long accountno
			,ArrayList<CustomersSite> customerDetails,HashMap<Long,String> loginCheck)
	{
		long amount=0;
		boolean bool=true;
		byte option=0;
		 long receiverAccountNumber=0;
		System.out.println("Enter the Receive Customer Account no");
		
		while(bool)
		{
		   receiverAccountNumber=scan.nextLong();
		   if(receiverAccountNumberCheck(receiverAccountNumber, loginCheck))
		   {
		    System.out.println("The receiver Account number:"+receiverAccountNumber);
		    System.out.println("If you want change receiver Account No  Press 1");
		    option=scan.nextByte();
		    if(option==1) {System.out.println("Re-Enter the accountno");continue;}
		    else {bool=false;break;}
		   }
		   else System.out.println("Enter the correct receiver Account number");
		}
		System.out.println("Enter the WithDraw Amount");
		bool=true;
		
		amount=scan.nextLong();
		long withdrawBalance=0;
		long receiverbalance=0;
		if(!withDrawAmountCheck( customerDetails,amount,accountno))
		{
			for(CustomersSite moneyTransfer:customerDetails)
			{
				if(moneyTransfer.accountNo==receiverAccountNumber)
				{
					moneyTransfer.accountBalance+=amount;
				     receiverbalance=moneyTransfer.accountBalance;
				}
				if(moneyTransfer.accountNo==accountno)
				{
					moneyTransfer.accountBalance-=amount;
					withdrawBalance=moneyTransfer.accountBalance;
					
					
				}
			}
		}
		else return;
		withdrawHistory.add(new WithDrawHistory(accountno,
				receiverAccountNumber,amount, withdrawBalance,  "Withdrawed", 
				java.time.LocalDate.now()));
		depositeHistory.add(new DepositHistory(receiverAccountNumber,amount, java.time.LocalDate.now(),
				"Deposited",  receiverbalance));
		System.out.println("Transactions successfullly completed");
		System.out.println();
		
	}
	private  boolean receiverAccountNumberCheck(long receiveraccountno,
			HashMap<Long,String> loginCheck)
	
	{
		return loginCheck.containsKey(receiveraccountno);
	}
	private  boolean withDrawAmountCheck(ArrayList<CustomersSite> customerDetails,
			long amount,long accountno)
	{
		for(CustomersSite amountCheck:customerDetails)
		{
			if(accountno==amountCheck.accountNo)
			{
				if(amount>amountCheck.accountBalance)
				{
					System.out.println("Insufficient Balance");
					return true;
				}
			}
		}
		return false;
	}
	public  void viewTransactionsHistory(long AccountNo)
	{
		System.out.println();
		for(DepositHistory depositeDetails:depositeHistory)
		{
			if(AccountNo==depositeDetails.accountno)
			{
				System.out.println("Account No:     "+depositeDetails.accountno);
				System.out.println("Deposite Amount:"+depositeDetails.depositAmount);
				System.out.println("Deposite Time:  "+depositeDetails.depositDate);
				System.out.println("Account balance:"+depositeDetails.accountBalance);
				System.out.println("Status:         "+depositeDetails.transferType);
				
				
			}
			System.out.println();
		}
		for(WithDrawHistory accountTransferHistory:withdrawHistory)
		{
			if(AccountNo==accountTransferHistory.userAccountNo)
			{
				System.out.println("Account No:       "+accountTransferHistory.userAccountNo);
				System.out.println("ReceiverAccountNo:"+accountTransferHistory.receiverAccountNo);
				System.out.println("Transfer Amount:  "+accountTransferHistory.withDrawAmount);
				System.out.println("Withdraw Date:    "+accountTransferHistory.withdrawDate);
				System.out.println("Account balance:  "+accountTransferHistory.balanceAmount);
				System.out.println("Status:           "+accountTransferHistory.status);
				
				
			}
			System.out.println();
		}
	}
}
class DepositHistory
{
	long accountno;
	long depositAmount;
    LocalDate depositDate;
    String transferType;
    long accountBalance;
    public DepositHistory(long accountno,long depositeAmount,LocalDate depositeDate,
    		String type,long accountBalance)
    {
    	this. accountno=accountno;
    	this. depositAmount=depositeAmount;
    	this. depositDate=depositeDate;
        this.transferType=type;
        this.accountBalance=accountBalance;
    }
    
    
}
class WithDrawHistory
{
	long userAccountNo;
	long receiverAccountNo;
	long withDrawAmount;
	long balanceAmount;
	String status;
	LocalDate withdrawDate;
	public WithDrawHistory(long userAccountno,long receiverAccountno,
			long withdrawAmount,long balanceAmount,String status,LocalDate  date)
	{
		this.userAccountNo=userAccountno;
		this.receiverAccountNo=receiverAccountno;
		this.withDrawAmount=withdrawAmount;
		this.balanceAmount=balanceAmount;
		this.status=status;
		this.withdrawDate=date;
	}
}