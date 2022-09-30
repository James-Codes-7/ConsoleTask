package libraryManagement;

import java.util.Scanner;

public class Library extends Admin{

		public static void main(String[] args) {

		Library library=new Library();

		library.frontPage();

	}

	public void frontPage()
	{


		Scanner scan=new Scanner(System.in);
		adminLoad();
		libraryStart();
		boolean bool=true;
		byte option=0;
		while(bool)
		{
			System.out.println("Admin          Press 1");
			System.out.println("Exit           Press 2");
			option=scan.nextByte();
			if(option==2)break;
			switch(option)
			{
			case 1:admin();
			default:System.out.println("Enter the valid one");
			}
		}

	}
	
}
