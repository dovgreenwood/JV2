public class BaseClassExercise
{
	public static void main(String [] args)
	{
		Derived d = new Derived(20, 10);
	}
}

class Base
{
	private int data;
	
	public int getData()
	{
		return data;
	}
	
	public Base(int data)
	{
		this.data = data;
	}
}

class Derived extends Base
{
	private int subData;
	
	public int getSubData()
	{
		return subData;
	}
	
	public Derived(int subData, int data)
	{
		super(data);
		this.subData = subData;
	}
}


