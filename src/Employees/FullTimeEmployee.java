package Employees;

/*
 *  Student Name: Dov Greenwood
 *  Date: 6/16/13
 *  
 *  This class is a subclass of employee for full time employees.  It adds overtime pay for
 *  when the employee works over the threshold hours.  It also adds to the employee info
 *  that they are eligible for pension and benifits.
 **/

public class FullTimeEmployee extends Employee
{
	
	private int overTimePay;
	private int thresholdHours;

	public FullTimeEmployee(String id, Date birthDate, Date employDate, String firstName, 
			String lastName, Address address, boolean isHourly, int salary, int overTimePay, 
			int thresholdHours)
	{
		super(id, birthDate, employDate, firstName, lastName, address, isHourly, salary);
		this.thresholdHours = thresholdHours;
		this.overTimePay = overTimePay;
	}

	public String getSalary()
	{
		if(isHourly)
			return "The employee is paid $" + salary + " per hour and has an overtime hourly pay rate of " + overTimePay + " after " + thresholdHours + " of work.";
		else
			return "The employee is paid $" + salary + " per year.";
	}
	public String toString()
	{
		//adds that the employee is eligible for benifits and pension to the toString
		return super.toString() + "\n" + 
				"This employee works full time and is eligible for benifits and pension.";
	}

}
