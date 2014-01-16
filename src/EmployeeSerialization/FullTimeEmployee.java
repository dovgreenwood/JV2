package EmployeeSerialization;

import java.io.*;

/*
 * Student Name: Dov Greenwood
 * Date: 7/10/13
 * 
 * This object is a subclass of employee and is serializable (like person and employee).  It adds
 * new class members for the annual salary, and benefit category of the employee, and provides 
 * updated readObject and writeObject methods.
 * */

public class FullTimeEmployee extends Employee implements Serializable
{
	private double salary;
	private int benefitCategory;
	
	public FullTimeEmployee(Address address, Date birthDate, String firstName,
			String lastName, String employeeNum, Date hireDate, double salary, int benifitCategory)
	{
		super(address, birthDate, firstName, lastName, employeeNum, hireDate);
		this.salary = salary;
		setBenefitCategory(benifitCategory);
	}
	
	private void writeObject(ObjectOutputStream out) throws IOException, ClassNotFoundException
	{
		out.writeDouble(salary);
		out.writeInt(benefitCategory);
	}
	
	private void readObject(ObjectInputStream in) throws IOException
	{
		salary = in.readDouble();
		benefitCategory = in.readInt();
	}
	
	public String toString()
	{
		return super.toString() + "\nSalary: " + 
				salary + "\nBenifit Category: " + 
				benefitCategory;
	}

	public double getSalary()
	{
		return salary;
	}

	public void setSalary(double salary)
	{
		this.salary = salary;
	}

	public int getBenefitCategory()
	{
		return benefitCategory;
	}

	public void setBenefitCategory(int benifitCategory)
	{
		while(true)
		{
			this.benefitCategory = benifitCategory;
			if(benifitCategory < 0 || benifitCategory > 5)
			{
				benifitCategory = Input.getInt("Benefit category must be an int from 1 - 5.");
				continue;
			}
			break;
		}
	}
}
