package attendancesystem;

import java.sql.SQLException;
import java.util.Scanner;

public class SchoolAttendanceSystem extends TeacherSite{

	static Scanner scan=new Scanner(System.in);	
	
	
	
	
	public static void main(String[] args) throws SQLException, ClassNotFoundException {
		
		SchoolAttendanceSystem schoolAttendance=new SchoolAttendanceSystem();
		
		schoolAttendance.attendancePage();

	}
	public  void attendancePage() throws ClassNotFoundException, SQLException
	{
		System.out.println("Welcome To School Attendance System");
		System.out.println();
		
		studentStart();
		teacherStart();
		
		 
		boolean bool=true;
		byte option=0;
	    while(bool)
	    {
	    	System.out.println("Teacher     Press 1");
	    	System.out.println("Student     Press 2");
	    	System.out.println("Exit        Press 3");
	        System.out.println("Enter the option");
	        option=scan.nextByte();
	        if(option>=3) {bool=false;break;}
	        switch(option)
	        {
	       
	        case 1:teacherLogin();
	        break;
	        case 2:studentLogin();
	        break;
	        default:System.out.println("Enter the correct one");
	        }
	    }
	   
	}

}
