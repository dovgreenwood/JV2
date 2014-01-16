package EmployeeSerialization;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

/*
 * Student Name: Dov Greenwood
 * Date: 7/10/13
 * 
 * This object is the base class for the 2 different kinds of employees: full-time, and part-time.
 * It extends 'Person,' adding new class members (employee number & hire date) and a method for
 * displaying employee information.  It also has writeObject and readObject methods.
 * */

public class Employee extends Person implements Serializable
{
	private String employeeNum;
	private Date hireDate;
	
	public Employee(Address address, Date birthDate, String firstName, String lastName, 
			String employeeNum, Date hireDate)
	{
		super(address, birthDate, firstName, lastName);
		this.employeeNum = employeeNum;
		this.hireDate = hireDate;
	}
	
	private void writeObject(ObjectOutputStream out) throws IOException, ClassNotFoundException
	{
		out.writeUTF(employeeNum);
		out.writeObject(hireDate);
	}
	
	private void readObject(ObjectInputStream in) throws IOException, ClassNotFoundException
	{
		employeeNum = in.readUTF();
		hireDate = (Date) in.readObject();
	}
	
	public String toString()
	{
		return getFirstName() + " " + getLastName() + "\nEmployee Number: " + 
				employeeNum + "\nDate of Birth: " + 
				getBirthDate().getDate() + "\nHire Date: " + 
				hireDate.getDate() + "\nAddress: " + 
				getAddress().getAddress();
	}

	public String getEmployeeNum()
	{
		return employeeNum;
	}

	public void setEmployeeNum(String employeeNum)
	{
		this.employeeNum = employeeNum;
	}

	public Date getHireDate()
	{
		return hireDate;
	}

	public void setHireDate(Date hireDate)
	{
		this.hireDate = hireDate;
	}
}
