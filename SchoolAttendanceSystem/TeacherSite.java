package attendancesystem;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;
import java.util.regex.Pattern;

public class TeacherSite extends StudentSite {

	static int generateteacherId;
	static HashMap<Integer,String>  teacherLoginCheck=new HashMap<>();
	static Scanner scan=new Scanner(System.in);


	
	public  void teacherLogin()
	{
		boolean bool=true;

		
		int teacherId=0;
		String teacherPassword="";
		byte option=0;
		System.out.println("Enter the Teacher Id");
		f1:while(bool)

		{
			teacherId=scan.nextInt();
			while(teacherLoginCheck.containsKey(teacherId))
			{
				System.out.println("Enter the Password");
				teacherPassword=scan.next();
				if(teacherLoginCheck.get(teacherId).equals(teacherPassword))
				{
					bool=false;break f1;
				}
				else System.out.println("Re-Enter Password");
				System.out.println("Goto main Page  Press 1");
				option=scan.nextByte();
				if(option==1)return;
			}
			System.out.println("Enter the Correct teacher Id");
		}

		bool=true;
		while(bool)
		{
			System.out.println();
			System.out.println("View Your Profile           Press 1");
			System.out.println("View Student Attendence     Press 2");
			System.out.println("Put Attendance to Students  Press 3");
			System.out.println("Exit                        Press 4");
			System.out.println("Enter the option");
			option=scan.nextByte();
			if(option==4)return;
			switch(option)
			{
			case 1:viewTeacherProfile(teacherId);
			break;
			case 2:viewStudentAttendance();
			break;
			case 3:putAttendance();
			break;
			default :System.out.println("Enter the valid one");
			}
		}
	}
	public void putAttendance() 
	{
		System.out.println("Enter the date  this format YYYY-MM-DD");
		boolean bool=true;
		byte option=0;
		while(bool)
		{
			String date=scan.next();
			if(dateCheck(date))
			{
				setAttendance(date);
				bool=false;
				break;
			}
			else System.out.println("Wrong Format");
		}
	}

	public boolean dateCheck(String date)
	{
		return Pattern.matches("[0-9]{4}[/-][0-9]{2}[/-][0-9]{2}", date);
	}
	public void viewTeacherProfile(int teacherId) 
	{
		try
		{
			Statement statement=jdbcConnection();
			ResultSet result=statement.executeQuery("select * from teacherDetails where teacherid="+teacherId);
			while(result.next())
			{
				System.out.println("Teacher Id:    "+result.getInt(1));
				System.out.println("Teacher Name:  "+result.getString(2));
				System.out.println("Your class:    "+result.getString(3));
				System.out.println("Your Dob:      "+result.getString(4));
			}
			statement.close();
			result.close();
		}catch(Exception e)
		{
			e.printStackTrace();
		}

	}
	public void teacherStart() throws ClassNotFoundException, SQLException
	{
		Statement statement=jdbcConnection();

		ResultSet result=statement.executeQuery("select * from teacherDetails");
		while(result.next())
		{
			teacherLoginCheck.putIfAbsent(result.getInt(1), result.getString(5));
		}
		statement.close();
		result.close();
	}
	public void viewStudentAttendance() 
	{
		boolean bool=true;
		byte option=0;
		while(bool)
		{
			System.out.println("View whole attendance              Press 1");
			System.out.println("View Single Student Attendance     Press 2");
			System.out.println("View Attendance use Date           Press 3");
			System.out.println("Exit                               Press 4");
			option =scan.nextByte();
			if(option==4)return;
			switch(option)
			{
			case 1:wholeAttendance();
			break;
			case 2:singleStudentAttendance();
			break;
			case 3:viewAttendanceUseDate();
			break;
			default : System.out.println("Enter the correct one");

			}
		}
	}

	public void wholeAttendance() 
	{
		try
		{
			Statement statement=jdbcConnection();
			ResultSet result=statement.executeQuery("select * from schoolattendance");

			System.out.println();
			System.out.println();
			int count=0;
			while(result.next())
			{
				System.out.println("Attend no:"+result.getInt(1)+" StudentId:"+result.getInt(2)
				+" Date:"+result.getString(3)+" Status:"+result.getString(4)+" Total Leaves:"+result.getInt(5)
				+"  leave Permit:"+result.getInt(6));
				count++;
				System.out.println();
			}
			if(count>0)System.out.println("That date not here");
			statement.close();
			result.close();
		}catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	public void singleStudentAttendance() 
	{
		try
		{
			Statement statement=jdbcConnection();
			System.out.println();
			System.out.println("Enter the student Id");
			int studentId=scan.nextInt();
			viewAttendanceHistory(studentId);
		}catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	public void viewAttendanceUseDate() 
	{
		System.out.println("Enter the date  this format YYYY-MM-DD");
		boolean bool=true;
		String date="";
		byte option=0;
		while(bool)
		{
			date=scan.next();
			if(dateCheck(date))
			{

				bool=false;
				break;
			}
			else System.out.println("Wrong Format");
		}
		try
		{


			Statement statement=jdbcConnection();
			ResultSet result=statement.executeQuery("select * from schoolattendance where atdate='"+date+"'");

			System.out.println();
			System.out.println("Full Attendance Sheet");
			System.out.println();
			while(result.next())
			{
				System.out.println("Attend no:"+result.getInt(1)+" StudentId:"+result.getInt(2)
				+" Date:"+result.getString(3)+" Status:"+result.getString(4)+" Total Leaves:"+result.getInt(5)
				+"  leave Permit:"+result.getInt(6));
				System.out.println();
			}
			statement.close();
			result.close();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}

}
