package Employees;
import Employees.Address;
/*
 *  Student Name: Dov Greenwood
 *  Date: 6/16/13
 *  
 *  This class is used as a base class for two different types of employees:
 *  part-time, and full-time.  It contains everything an employee should have on an
 *  ID card (id, date of birth, date of employment, full name, etc.).  It also specifies
 *  two different types of payment: salaried, or paid hourly.  It takes advantage of abstract
 *  classes and the toString Object method.
 **/

public abstract class Employee
{
	
	private String id;
	private Date birthDate;
	private Date employDate;
	private String firstName;
	private String lastName;
	private Address address;
	protected boolean isHourly;
	protected int salary;
	
	public Employee(String id, Date birthDate, Date employDate, String firstName, 
			String lastName, Address address, boolean isHourly, int salary)
	{
		setId(id);
		setBirthDate(birthDate);
		setEmployDate(employDate);
		setFirstName(firstName);
		setLastName(lastName);
		setAddress(address);
		setIsHourly(isHourly);
		setSalary(salary);
	}
	
	public boolean isPaidHourly()
	{
		return isHourly;
	}

	public abstract String getSalary();

	public String toString()
	{
		return "Employee Name: " + firstName + " " + lastName + "\n" +
			"Employee ID: " + id + "\n" +
			"Date of Birth: " + birthDate.getDate() + "\n" + 
			"Date of Employment: " + employDate.getDate() + "\n" + 
			"Address: " + address.getAddress() + "\n" + 
			"Salary:  " + getSalary();
	}

	public String getId()
	{
		return id;
	}

	public void setId(String id)
	{
		this.id = id;
	}

	public Date getBirthDate()
	{
		return birthDate;
	}

	public void setBirthDate(Date birthDate)
	{
		this.birthDate = birthDate;
	}

	public Date getEmployDate()
	{
		return employDate;
	}

	public void setEmployDate(Date employDate)
	{
		this.employDate = employDate;
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

	public Address getAddress()
	{
		return address;
	}

	public void setAddress(Address address)
	{
		this.address = address;
	}

	public boolean isHourly()
	{
		return isHourly;
	}

	public void setIsHourly(boolean isHourly)
	{
		this.isHourly = isHourly;
	}

	public void setSalary(int salary)
	{
		this.salary = salary;
	}

	
}
