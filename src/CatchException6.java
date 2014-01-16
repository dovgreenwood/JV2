/*
 *  Student Name: Dov Greenwood
 *  Date: 6/18/13
 *  
 *  This program tests the new Exception DivideByZero and then asks the user to keep giving
 *  input until a valid divisor is given.
 **/
public class CatchException6
{
	public static void main(String [] args)
	{
		System.out.println();
		try
		{
			divide(10, 0);
		}
		catch(DivideByZeroException e)
		{
			int result;
			while(true)
			{
				try
				{
					int denom = Input.getInt("it's okay ... you still have another " + 
							"chance to enter a valid (non-zero) denominator");
					result = divide(10, denom);
					break;
				}
				catch(DivideByZeroException d){}
			}
			System.out.println(result);
		}
	}

	private static int divide(int x, int y) throws DivideByZeroException
	{
		int result = 0;
		try
		{
			result = x/y;
		}
		catch(ArithmeticException e)
		{
			throw new DivideByZeroException(y);
		}
		return result;
	}
}
