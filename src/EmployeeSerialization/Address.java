package EmployeeSerialization;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

/*
 * Student Name: Dov Greenwood
 * Date: 7/10/13
 * 
 * This Address is the same that I used in my first assignment with two slight modifications for
 * this assignment:
 * a) I gave it a writeObject method, and
 * b) I gave it a readObject method.
 * */

public class Address implements Serializable
{
	private String street;
	private String city;
	private String state;
	private String zipCode;
	
	public Address(String street, String city, String state, String zipCode)
	{
		this.street = street;
		this.city = city;
		this.state = state;
		this.zipCode = zipCode;
	}
	
	
	public String getStreet()
	{
		return street;
	}
	public void setStreet(String street)
	{
		this.street = street;
	}
	public String getCity()
	{
		return city;
	}
	public void setCity(String city)
	{
		this.city = city;
	}
	public String getState()
	{
		return state;
	}
	public void setState(String state)
	{
		this.state = state;
	}
	public String getZipCode()
	{
		return zipCode;
	}
	public void setZipCode(String zipCode)
	{
		this.zipCode = zipCode;
	}
	
	public String getAddress()
	{
		return getStreet() + ", " + getCity() + ", " + getState() + ", " + getZipCode();
	}
	
	private void writeObject(ObjectOutputStream out) throws IOException, ClassNotFoundException
	{
		out.writeUTF(getStreet());
		out.writeUTF(getCity());
		out.writeUTF(getState());
		out.writeUTF(getZipCode());
	}
	
	private void readObject(ObjectInputStream in) throws IOException
	{
		setStreet(in.readUTF());
		setCity(in.readUTF());
		setState(in.readUTF());
		setZipCode(in.readUTF());
	}
}
