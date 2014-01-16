package Animals;

/*
 *  Student Name: Dov Greenwood
 *  Date: 6/17/13
 *  
 *   This is the base interface for all types of animals.  It contains their age, weight,
 *   an abstract method for displaying them, and an abstract method for having them make a sound.
 **/

public interface Animal
{
	
	int age = 5;
	int weight = 10;
	
	String display();
	String makeSound();
	
}
