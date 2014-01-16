package EmployeeSerialization;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

/*
 * Student Name: Dov Greenwood
 * Date: 7/10/13
 * 
 * This 'Person' object is used as a base class for the 'Employee' object.  It is specified
 * by an address, date of birth, first name, and last name.  It has no methods, except for its
 * constructor, getter and setter methods, and readObject and writeObject methods.
 * */

public class Person implements Serializable
{
	private Address address;
	private Date birthDate;
	private String firstName;
	private String lastName;
	
	public Person(Address address, Date birthDate, String firstName, String lastName)
	{
		this.address = address;
		this.birthDate = birthDate;
		this.firstName = firstName;
		this.lastName = lastName;
	}
	
	private void writeObject(ObjectOutputStream out) throws IOException, ClassNotFoundException
	{	
		out.writeObject(address);
		out.writeObject(birthDate);
		out.writeUTF(firstName);
		out.writeUTF(lastName);
	}
	
	private void readObject(ObjectInputStream in) throws IOException, ClassNotFoundException
	{
		address = (Address) in.readObject();
		birthDate = (Date) in.readObject();
		firstName = in.readUTF();
		lastName = in.readUTF();
	}

	public Address getAddress()
	{
		return address;
	}

	public void setAddress(Address address)
	{
		this.address = address;
	}

	public Date getBirthDate()
	{
		return birthDate;
	}

	public void setBirthDate(Date birthDate)
	{
		this.birthDate = birthDate;
	}

	public String getFirstName()
	{
		return firstName;
	}

	public void setFirstName(String firstName)
	{
		this.firstName = firstName;
	}

	public String getLastName()
	{
		return lastName;
	}

	public void setLastName(String lastName)
	{
		this.lastName = lastName;
	}
}
