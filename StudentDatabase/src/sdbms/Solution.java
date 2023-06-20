package sdbms;

import java.util.Scanner;

import custumexecption.InvalidChoiceException;

public class Solution {
	public static void main(String[] args) {
		System.out.println("WELCOME TO STUDENT DATABASE MANAGEMENT SYSTEM");
		System.out.println("----------------------------------------------------");
		
		Scanner sc=new Scanner(System.in);
		StudentManagentSystem s = new StudentManagementSystemImpl();
 while(true) {
			System.out.println("1.addstudent");
		
			System.out.println("2.displaystudent");
			System.out.println("3.displayallstudent");
			System.out.println("4.removestudent");
			System.out.println("5.removeallstudent");
			System.out.println("6.updatestudent");
			System.out.println("7.countstudent");
			System.out.println("8.sortstudent");
			System.out.println("9.findstudentwithhighestmarks");
			System.out.println("10.findstudentwithlowestmarks");
			System.out.println("11.EXIT ");
			
			System.out.println("ENTER CHOICE");
			
			int choice =sc.nextInt();
			
			switch(choice) {
			case 1:
				s.addstudent();
			break;
			
			case 2:
				s.displaystudent();
				break;
				
			case 3:
				s.displayallstudent();
				break;
			case 4:
				s.removestudent();
				break;
			case 5:
				s.removeallstudent();
				break;
			case 6:
				s.updatestudent();
				break;
			case 7:
				s.countstudent();
				break;
			case 8:
				s.sortstudent();
				break;
			case 9:
				s.findstudentswithhighestmarks();
				break;
			case 10:
				s.findstudentswithlowestmarks();
				break;
			case 11:
				System.out.println("THANK YOU");
				break;
				
				default :
					//System.out.println("INVALID CHOICE");
					try {
						String msg="Invalid choice ,kindly enter valid choice";
						throw new InvalidChoiceException(msg);
					}
					catch(Exception e) {
						System.out.println(e.getMessage());
					}
			
			}
			System.out.println("-----------------------------");
		}
	}

}
