/*
 *  Student Name: Dov Greenwood
 *  Date: 6/18/13
 *  
 *  This exception is meant to be thrown when there is a division by zero in a program.
 **/
public class DivideByZeroException extends Exception
{
	
	private int denom;
	
	public DivideByZeroException(){}
	
	public DivideByZeroException(String s)
	{
		super(s);
	}
	
	public DivideByZeroException(int denom)
	{
		super("div by zero");
		this.denom = denom;
	}
	
	public int getDenom()
	{
		return denom;
	}
	
}
