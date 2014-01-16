package Employees;

/*
 *  Student Name: Dov Greenwood
 *  Date: 6/16/13
 *  
 *  This is a test program which creates an array of different types of employees and displays
 *  their information. 
 **/

public class TestEmployee {

	public static void main(String[] args) {
		Employee [] employeeList = {
				new PartTimeEmployee(
						"0x45gf3", 
						new Date(1, 2, 2345), 
						new Date(3, 7, 2365), 
						"Hello", "World", 
						new Address("Sunshine Ave.","Place City","ND","03451"), 
						true, 
						20, 
						32
				),
				new PartTimeEmployee(
						"v78og", 
						new Date(6, 9, 5698), 
						new Date(4, 10, 6698), 
						"Man1", "LastName1", 
						new Address("Darkness Rd.","Haunted City","OK","56430"), 
						false, 
						90000, 
						42
				),
				new FullTimeEmployee(
						"erw554u76", 
						new Date(3, 13, 4456), 
						new Date(3, 23, 4485), 
						"Matt", "Roth", 
						new Address("Carillon Dr.","Livingston","NJ","07069"), 
						false,
						200000, 
						25, 
						35
				),
				new FullTimeEmployee(
						"5678dfg6", 
						new Date(6, 16, 3013), 
						new Date(7, 18, 4442), 
						"James", "Clark", 
						new Address("Greenwood Ave.","Chicago","IL","23420"), 
						true,
						100, 
						25, 
						35
				)
		};
		for(int i = 0; i < employeeList.length; i++)
		{
			System.out.println(employeeList[i] + "\n\n\n");
		}
	}

}
