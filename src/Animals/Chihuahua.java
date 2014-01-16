package Animals;

/*
 *  Student Name: Dov Greenwood
 *  Date: 6/17/13
 *  
 *  This chihuahua class implements the Dog interface.  It overrides the abstract methods
 *  to return things when it is being displayed, making a sound, and doing tricks.
 **/

public class Chihuahua implements Dog 
{

	public String display() 
	{
		return "a chihuahua is being displayed";
	}

	public String makeSound() 
	{
		return "Yo quiero taco bell";
	}

	public String doTrick(String trick) 
	{
		switch(trick)
		{
			case "sit up":
				return "the chihuahua is sitting up";
			case "lie down":
				return "the chihuahua is lying down";
			default:
				return "the chihuahua did not understand your trick";
		}
	}

}
