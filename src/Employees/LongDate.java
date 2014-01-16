package Employees;
/*
 *  Student Name: Dov Greenwood
 *  Date Created: 6/14/13
 *
 *  This Class is a subclass of Date.  It adds the ability to declare the date with
 *  a month name, and to display the contents of the date in the following formats:
 *  - MM/DD/YYYY
 *  - MonthName DD, YYYY
 **/

public class LongDate extends Date
{
	
	private String monthName;
	
	public LongDate(String month, int day, int year)
	{
		setDate(month, day, year);
	}
	
	public void setDate(String month, int day, int year)
	{
		monthName = month;
		String [] monthNames = {
				"January", "February","March",
				"April","May","June",
				"July","August","September",
				"October","November","December"
		};
		int monthIndex = 0;
		//loops through monthNames until it finds a month number to match the month name
		while(monthIndex == 0){
			for(int i = 0; i < monthNames.length; i++)
			{
				if(monthNames[i].equals(monthName))
					monthIndex = i + 1;
			}
			//prompts the user if the month name is invalid
			if(monthIndex == 0)
				monthName = Input.getString("\"" + monthName + "\" is an invalid month (remember to capitalize).  Please enter a new one:");
		}
		super.setDate(monthIndex, day, year);
	}
	
	public String getDate()
	{
		// returns the date in long format
		return monthName + " " + getDay() + ", " + getYear();
	}
	
	public String getShortDate()
	{
		// returns result of getDate for the super-class
		return super.getDate();
	}
}
