package Animals;
import java.util.Random;

/*
 *  Student Name: Dov Greenwood
 *  Date: 6/17/13
 *  
 *  This program test the Subclasses of dog and bird by making an array of animals
 *  and picking four of them randomly and making them play their sound.
 **/

public class TestAnimals 
{

	public static void main(String[] args) 
	{
		Animal [] myAnimals = {
				new Chihuahua(), new FrenchPoodle(), 
				new Robin(), new Bluebird()
		};
		Random r = new Random();
		for(int i = 0; i < myAnimals.length; i++)
		{
			System.out.println(myAnimals[r.nextInt(4)].makeSound());
		}
		
	}

}
