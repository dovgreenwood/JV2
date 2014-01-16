package Animals;

/*
 *  Student Name: Dov Greenwood
 *  Date: 6/17/13
 *  
 *  This bluebird class implements the Bird interface.  It overrides the abstract methods
 *  to return things when it is being displayed, making a sound, and flying.
 **/

public class Bluebird implements Bird 
{

	public String display() 
	{
		return "a bluebird is being displayed";
	}

	public String makeSound() 
	{
		return "eek eek eek";
	}

	public String fly() 
	{
		return "the bluebird is flying";
	}

}
