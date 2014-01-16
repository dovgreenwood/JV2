package EmployeeSerialization;

import java.util.ArrayList;
import java.util.Scanner;
import java.io.*;
/*
 * Student Name: Dov Greenwood
 * Date: 7/10/13
 * 
 * This program allows the reading and writing of Employee objects to a file using object serialization.
 * Upon choosing a file to read and write to, it gives the user three options:
 * - display [all employees in the file]
 * - add [another employee to the file]
 * - exit [the program]
 * Writing an employee to the file will open the file, extract all of the exisiting objects into
 * an ArrayList, append the new employee, put all of the new employees in the buffer, and flush the buffer.
 * 
 * Reading simply opens the file, reads the employees into an ArrayList, and then loops through
 * the list calling the display methods on the different types of employees.
 * 
 * Exiting turns the loop condition to false, ending the loop, and the program.
 * */

public class ReadAndWriteEmployees
{

	public static void main(String[] args)
	{
		Scanner keyBoard = new Scanner(System.in);
		System.out.println("File name please:");
		String filePath = keyBoard.nextLine();
		
		boolean condition = true;
		
		while(condition)
		{
			System.out.println("Type 'display' to display all employees,\n" + 
								"type 'add' to add a new employee,\n" + 
								"or type 'exit' to exit the program.");
			
			switch(keyBoard.nextLine())
			{
				case "exit":
					condition = false;
					break;
				case "add":
					System.out.println("Full-time or part-time employee? (full-time/part-time)");
					makeNewEmployee(keyBoard.nextLine(), keyBoard, filePath);
					break;
				case "display":
					System.out.println("\n");
					ArrayList<Employee> employees = readEmployees(filePath);
					for(Employee e : employees)
					{
						System.out.println(e + "\n");
					}
					break;
			}
		}
	}

	private static ArrayList<Employee> readEmployees(String filePath)
	{
		
		ArrayList<Employee> rVal = new ArrayList<Employee>();
		
		ObjectInputStream in = null;
		
		try
		{
			
			in = new ObjectInputStream(
									new BufferedInputStream(
									new FileInputStream(filePath)));
			while(true)
			{
				Employee myEmployee = (Employee) in.readObject();
				rVal.add(myEmployee);
			}
			
		}
		catch(IOException | ClassNotFoundException e)
		{
		}
		finally
		{
			try {
				in.close();
			} catch (Exception e)
			{
			}
		}
		
		return rVal;
	}

	private static void makeNewEmployee(String choice, Scanner keyBoard, String filePath) //also see here for errors
	{
		Employee myEmployee = null;
		
		System.out.println("Address Information");
		System.out.print("Street: ");
		String street = keyBoard.nextLine();
		System.out.print("City: ");
		String city = keyBoard.nextLine();
		System.out.print("State: ");
		String state = keyBoard.nextLine();
		System.out.print("Zip code: ");
		String zipCode = keyBoard.nextLine();
		Address address = new Address(street, city, state, zipCode);
		
		System.out.println("\n\nDate of Birth");
		System.out.print("Month (number): ");
		int month = Integer.parseInt(keyBoard.nextLine());
		System.out.print("Day (number): ");	
		int day = Integer.parseInt(keyBoard.nextLine());
		System.out.print("Year: ");
		int year = Integer.parseInt(keyBoard.nextLine());
		Date birthDate = new Date(month, day, year);
		
		System.out.println("\n\nName");
		System.out.print("First Name: ");
		String firstName = keyBoard.nextLine();
		System.out.print("Last Name: ");
		String lastName = keyBoard.nextLine();
		
		System.out.print("\n\nEmployee Number: ");
		String employeeNum = keyBoard.nextLine();
		
		System.out.println("\n\nHire Date");
		System.out.print("Month (number): ");
		month = keyBoard.nextInt();
		System.out.print("Day (number): ");		
		day = keyBoard.nextInt();
		System.out.print("Year: ");
		year = keyBoard.nextInt();
		Date hireDate = new Date(month, day, year);
		keyBoard.nextLine();
		if(choice.equals("full-time"))
		{
			System.out.print("\n\nSalary: ");
			double salary = keyBoard.nextDouble();
			System.out.print("\n\nEmployee Benifit Category: ");
			int benifitCategory = keyBoard.nextInt();
			myEmployee = new FullTimeEmployee(address, birthDate, firstName, lastName, employeeNum, hireDate, salary, benifitCategory);
		}
		else if(choice.equals("part-time"))
		{
			System.out.print("\n\nHourly Rate: ");
			double hourlyRate = keyBoard.nextDouble();
			myEmployee = new PartTimeEmployee(address, birthDate, firstName, lastName, employeeNum, hireDate, hourlyRate);
		}
		else
			System.out.println("Invalid choice.  Exiting to main menu...");
		
		try
		{
			ArrayList<Employee> employees = new ArrayList<Employee>();
			try {
				employees = readEmployees(filePath);
			}
			catch(Exception e) {
				
			}
			employees.add(myEmployee);
			
			ObjectOutputStream out = new ObjectOutputStream(
									new BufferedOutputStream(
									new FileOutputStream(filePath)));
			for(Employee e : employees)
			{
				out.writeObject(e);
			}
			out.flush();
			out.close();
		}
		catch(Exception e) {
		}
		keyBoard.nextLine();
		
	}

}
