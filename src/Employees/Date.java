package Employees;
import java.io.PrintStream;

public class Date
{
	private int month;
	private int day;
	private int year;

	public Date() {
		this.month = 0;
		this.day = 0;
		this.year = 0;
	}

	public Date(int paramInt1, int paramInt2, int paramInt3)
	{
		this.month = editMonth(paramInt1);
		this.day = editDay(paramInt2);
		this.year = editYear(paramInt3);
	}

	public void setDate(int paramInt1, int paramInt2, int paramInt3)
	{
		this.month = editMonth(paramInt1);
		this.day = editDay(paramInt2);
		this.year = editYear(paramInt3);
	}

	public String getDate()
	{
		String str = this.month + "/" + this.day + "/" + this.year;

		return str;
	}

	public int getMonth()
	{
		return this.month;
	}

	public int getDay()
	{
		return this.day;
	}

	public int getYear()
	{
		return this.year;
	}

	protected int editMonth(int paramInt)
	{
		int i = paramInt;
		int j = 0;

		while (j == 0)
		{
			if ((i >= 1) && (i <= 12))
			{
				j = 1;
			}
			else
			{
				i = Input.getInt("Month must be 1 - 12");
				j = 0;
			}
		}
		return i;
	}

	protected int editDay(int paramInt)
	{
		int i = paramInt;
		int j = 0;
		int[] arrayOfInt = { 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };

		System.out.println("month = " + this.month + " day = " + paramInt);


		if ((this.month < 1) || (this.month > 12)) {
			this.month = editMonth(this.month);
		}
		while (j == 0)
		{
			if ((i >= 1) && (i <= arrayOfInt[(this.month - 1)])) {
				j = 1;
			}
			else {
				i = Input.getInt("Day must be 1 - " + arrayOfInt[(this.month - 1)]);
				j = 0;
			}
		}


		return i;
	}

	protected int editYear(int paramInt)
	{
		int i = paramInt;
		int j = 0;

		while (j == 0)
		{
			if (i > 0) {
				j = 1;
			}
			else {
				i = Input.getInt("Year must be greater than 0");
				j = 0;
			}
		}

		return i;
	}
} 
