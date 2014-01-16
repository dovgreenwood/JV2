import Employees.Address;


public abstract class Employee
{
	
	private String id;
	private Date birthDate;
	private Date employDate;
	private String firstName;
	private String lastName;
	private Address address;
	
	public Employee(String id, Date birthDate, Date employDate, String firstName, String lastName, Address address)
	{
		this.id = id;
		this.birthDate = birthDate;
		this.employDate = employDate;
		this.firstName = firstName;
		this.lastName = lastName;
		this.address = address;
	}
	
	public abstract void hourly();
	
	public abstract void salary();
	
	
	
}
