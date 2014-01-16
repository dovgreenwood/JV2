package Employees;

/*
 *  Student Name: Dov Greenwood
 *  Date: 6/16/13
 *  
 *  This class extends the base-class 'Employee' to add support for part-time employees.
 *  It adds a member variable for the maximum number of hours per week the employee can work, 
 *  and displays this.
 **/

public class PartTimeEmployee extends Employee
{

	private int maximumHours;

	public PartTimeEmployee(String id, Date birthDate, Date employDate, String firstName, 
			String lastName, Address address, boolean isHourly, int salary, int maximumHours)
	{
		super(id, birthDate, employDate, firstName, lastName, address, isHourly, salary);
		this.maximumHours = maximumHours;
	}

	public String getSalary()
	{
		if(isHourly)
			return "The employee is paid $" + salary + " per hour.";
		else
			return "The employee is paid $" + salary + " per year.";
	}

	public String toString()
	{
		//displays maximum number of working hours by overriding Employee's toString method
		return super.toString() + "\n" +
				"This employee works part time and has maximum working hours of " + maximumHours + " per week.";
	}

}
