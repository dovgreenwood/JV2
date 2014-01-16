package random_search;

import java.util.Random;

/*
 * Student Name: Dov Greenwood
 * Date: 7/12/13
 * 
 * This program generates a number between 0 and 1000 and creates three FindIts.  They all
 * try to guess the number within their range.  The program closes when one of the threads
 * finds the number.
 * */

public class CreateAndFindNum {
	
	public static void main(String [] args) {
		
		Random r = new Random();
		int num = r.nextInt(1001);
		
		Thread area1 = new FindIt(0, 349, num);
		Thread area2 = new FindIt(350, 699, num);
		Thread area3 = new FindIt(700, 1000, num);
		
		area1.start();
		area2.start();
		area3.start();
		
	}
	
}
