/*
 *  Student Name: Dov Greenwood
 *  Date Created: 6/14/13
 *  
 *  This program tests the new subclass of Date -- LongDate.  It tests the getDate
 *  method of LongDate and Date.  It also makes sure that the correction prompt works
 *  for the LongDate month name.
 **/
public class TestDate
{
	public static void main(String [] args)
	{
		Date [] testDates = {
				new LongDate("Sertember", 3, 2012), //invalid
				new Date(1,2,345), //valid
				new LongDate("January", 1, 2014) //valid
		};
		for(int i = 0; i < testDates.length; i++)
		{
			System.out.println(testDates[i].getDate());
		}
		LongDate BarMitzvah = (LongDate)testDates[0];
		System.out.println(BarMitzvah.getShortDate());
	}
}
