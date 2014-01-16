package Animals;

/*
 *  Student Name: Dov Greenwood
 *  Date: 6/17/13
 *  
 *  This robin class implements the Bird interface.  It overrides the abstract methods
 *  to return things when it is being displayed, making a sound, and flying.
 **/

public class Robin implements Bird 
{

	public String display() 
	{
		return "a robin is being displayed";
	}

	public String makeSound() 
	{
		return "chirp chirp";
	}

	public String fly() 
	{
		return "the robin is flying";
	}

}
