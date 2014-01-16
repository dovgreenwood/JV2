package Animals;

/*
 *  Student Name: Dov Greenwood
 *  Date: 6/17/13
 *  
 *  This French poodle class implements the Dog interface.  It overrides the abstract methods
 *  to return things when it is being displayed, making a sound, and doing tricks.
 **/

public class FrenchPoodle implements Dog 
{

	public String display() 
	{
		return "a french poodle is being displayed";
	}

	public String makeSound() 
	{
		return "Bonjour mon ami";
	}

	public String doTrick(String trick) 
	{
		switch(trick)
		{
			case "sit up":
				return "the french poodle is sitting up";
			case "lie down":
				return "the french poodle is lying down";
			case "shake hands":
				return "the french poodle is shaking hands";
			default:
				return "the french poodle did not understand your trick";
		}
	}

}
