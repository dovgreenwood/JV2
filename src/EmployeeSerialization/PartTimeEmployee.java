package EmployeeSerialization;

import java.io.*;

/*
 * Student Name: Dov Greenwood
 * Date: 7/10/13
 * 
 * This object is a subclass of employee and is serializable (like person and employee).  It adds
 * a new class member for the hourly rate of the employee, and updated readObject and writeObject methods.
 * */

public class PartTimeEmployee extends Employee implements Serializable
{
	private double hourlyRate;
	
	public PartTimeEmployee(Address address, Date birthDate, String firstName,
			String lastName, String employeeNum, Date hireDate, double hourlyRate)
	{
		super(address, birthDate, firstName, lastName, employeeNum, hireDate);
		this.hourlyRate = hourlyRate;
	}
	
	private void writeObject(ObjectOutputStream out) throws IOException, ClassNotFoundException
	{
		out.writeDouble(hourlyRate);
	}
	
	private void readObject(ObjectInputStream in) throws IOException
	{
		hourlyRate = in.readDouble();
	}
	
	public String toString()
	{
		return super.toString() + "\nHourly Rate: " + 
				hourlyRate;
	}

	public double getHourlyRate()
	{
		return hourlyRate;
	}

	public void setHourlyRate(double hourlyRate)
	{
		this.hourlyRate = hourlyRate;
	}
}
