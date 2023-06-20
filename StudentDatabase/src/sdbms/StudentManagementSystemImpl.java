package sdbms;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

import Customsorting.SortStudentByAge;
import Customsorting.SortStudentById;
import Customsorting.SortStudentByMarks;
import Customsorting.SortStudentByName;
import custumexecption.InvalidChoiceException;
import custumexecption.StudentNotFoundExecption;

public class StudentManagementSystemImpl implements StudentManagentSystem {

	Scanner sc=new Scanner(System.in);

	Map<String,Student> db=new LinkedHashMap<String ,Student>();

	@Override
	public void addstudent() {
		System.out.println("enter age");
		int age=sc.nextInt();//accepting age

		System.out.println("enter name");	
		String name=sc.next();//accepting name

		System.out.println("enter marks");
		int marks=sc.nextInt();//accepting marks

		Student s=new Student(age , name, marks);
		db.put(s.getId(), s);
		System.out.println("STUDENT RECORD INSERTED SUCESSFULLY");
		System.out.println("YOUR STUDENT ID IS :"+s.getId());


	}

	@Override
	public void displaystudent() {
		System.out.println("Enter Student id");//id-->key
		String id=sc.next();//String id=sc.next().toUppercase()
		id=id.toUpperCase();

		if(db.containsKey(id)) {
			System.out.println("Student Details");
			System.out.println("-------------------------");
			Student std=db.get(id);
			System.out.println("id :"+std.getId());
			System.out.println("Age :"+std.getAge());
			System.out.println("Name :"+std.getName());
			System.out.println("Marks :"+std.getMarks());
			//Printing reference as toString() is overridden
			//S.O.P(std)
		}else {
			try {
				String msg="Student with id "+id+" is not found";
				throw new StudentNotFoundExecption(msg);	
			}
			catch(Exception e) {
				System.out.println(e.getMessage());
			}
		}

	}

	@Override
	public void displayallstudent() {
		if(db.size()>0) {//if(isEmpty);
			System.out.println("STUDENT RECORDS AS FOLLOWS");
			System.out.println("--------------------------------");

			Set<String>keys=db.keySet();
			for(String key:keys) {
				System.out.println(db.get(key));
			}
		}
		else {
			try {
				String msg="NO SIFFICIENT STUDENT RECORDS TO DISPLAY";
				throw new StudentNotFoundExecption(msg);
			}
			catch(Exception e) {
				System.out.println(e.getMessage());
			}
		}


	}

	@Override
	public void removestudent() {
		System.out.println("enter id");
		String id=sc.next().toUpperCase();
		if(db.containsKey(id)) {
			System.out.println("Student record found :");
			System.out.println(db.get(id));
			db.remove(id);
			System.out.println("Student record deleted successfully");
		}else {
			try {
				String msg="Student with id "+id+" is not found";
				throw new StudentNotFoundExecption(msg);
			}
			catch(Exception e) {
				System.out.println(e.getMessage());
			}

		}

	}

	@Override
	public void removeallstudent() {
		if(db.size()>0) {
			System.out.println("number of Students record"+db.size());
			db.clear();
			System.out.println("All students records deleted sucessfully");
		}else {
			try {
				String msg="NO Student record deleted";
				throw new StudentNotFoundExecption(msg);
			}
			catch(Exception e) {
				System.out.println(e.getMessage());
			}

		}

	}

	@Override
	public void updatestudent() {
		System.out.println("enter Student id");
		String id=sc.next().toUpperCase();
		if(db.containsKey(id)) {
			Student std=db.get(id);//getting the Student object based on id
			System.out.println("1.Update Age");
			System.out.println("2.Update Name");
			System.out.println("3.Update Marks");
			System.out.println("Enter Choice");
			int choice=sc.nextInt();

			switch(choice) {
			case 1:
				System.out.println("Enter Age");
				int age=sc.nextInt();
				std.setAge(age);
				System.out.println("Age Updated Successfully");
				break;

			case 2:
				System.out.println("Enter Name");
				String name =sc.next();
				std.setName(name);
				System.out.println("Name Updated Successfully");
				break;

			case 3:
				System.out.println("Enter Marks");
				int marks=sc.nextInt();
				std.setMarks(marks);
				System.out.println("Marks Updated Successfully");
				break;

			}
		}else {
			try {
				String msg="Student with id "+id+" is not found";
				throw new StudentNotFoundExecption(msg);
			}
			catch(Exception e) {
				System.out.println(e.getMessage());
			}

		}


	}

	@Override
	public void countstudent() {
		System.out.println("NUMBER OF STUDENTS RECORDS :"+db.size());

	} 

	@Override
	public void sortstudent() {

		if(db.isEmpty()) {
			//converting Map into Set using keySet
			Set<String>keys=db.keySet();

			//refernce of list & object  of arrayList Storing student objects
			List<Student>list=new ArrayList<Student>();

			//traversing the keys

			for(String key:keys){
				list.add(db.get(key));
			}

			System.out.println("1.sort by student Id");
			System.out.println("2.sort by student Age");
			System.out.println("3.sort by student Name");
			System.out.println("4.sort by student Marks");
			System.out.println("5.enter choice");
			int choice=sc.nextInt();
			switch(choice) {
			case 1:
				Collections.sort(list, new SortStudentById());
				for(Student s : list) {
					System.out.println(s);
				}
				break;
			case 2:
				Collections.sort(list, new SortStudentByAge());
				for(Student s : list) {
					System.out.println(s);
				}
				break;
			case 3:
				Collections.sort(list, new SortStudentByName());
				for(Student s : list) {
					System.out.println(s);
				}
				break;
			case 4:
				Collections.sort(list, new SortStudentByMarks());
				for(Student s : list) {
					System.out.println(s);
				}
				break;

			default :
				try {
					String msg="invalid choice ,kindly enter choice";
					throw new InvalidChoiceException(msg);
				}
				catch(Exception e) {
					System.out.println(e.getMessage());


				}
				
				}

			}
	}
		private static void display(List<Student>list) {
			for(Student s : list) {
				System.out.println(s);
			}
		}


		@Override
		public void findstudentswithhighestmarks() {
			
			Set <String>keys=db.keySet();
			List<Student>list=new ArrayList<Student>();
			for(String key : keys) {
				list.add(db.get(key));
			}
			Collections.sort(list, new SortStudentByMarks());
			System.out.println("Student with highest marks");
System.out.println(list.get(list.size()-1));
		}

		@Override
		public void findstudentswithlowestmarks() {
			Set <String>keys=db.keySet();
			List<Student>list=new ArrayList<Student>();
			for(String key : keys) {
				list.add(db.get(key));
			}
			Collections.sort(list, new SortStudentByMarks());
			System.out.println("Student with lowest marks");
System.out.println(list.get(0));

		}

	}
