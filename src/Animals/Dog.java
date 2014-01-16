package Animals;

/*
 *  Student Name: Dov Greenwood
 *  Date: 6/17/13
 *  
 *  This interface extends the base Animal class specifically for dogs.  All it adds is an
 *  abstract "doTrick" function which makes it do a trick.
 **/

public interface Dog extends Animal
{
	
	String doTrick(String trick);
	
}
