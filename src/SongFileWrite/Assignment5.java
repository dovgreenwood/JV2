package SongFileWrite;

import java.io.*;
import java.util.Scanner;

/*
 *  Student Name: Dov Greenwood
 *  Date: 6/19/13
 *  
 *  This program tests the SongTextFileProcessor's readSong and writeSong methods.  It gives three
 *  options upon typing in the file that you want to access: read all of the songs, write another song,
 *  or quit.
 **/

public class Assignment5
{

	public static void main(String [] args)
	{
		Scanner input = new Scanner(System.in);
		System.out.print("File to read/write to: ");
		String fileLoc = input.nextLine();
		SongTextFileProcessor sfp = new SongTextFileProcessor(fileLoc); //sfp: song-file processor
		
		System.out.println("Would you like to:\n" + 
							"a. write a song to the file\n" + 
							"b. read all songs from the file\n" + 
							"c. quit"
		);
		String choice = input.nextLine();
		switch(choice)
		{
			case "a":
				System.out.println("Artist: "); String artist = input.nextLine();
				System.out.println("Title: "); String title = input.nextLine();
				System.out.println("Genre: "); String genre = input.nextLine();
				
				sfp.writeSong(new Song(title, genre, artist));
				
				break;
			case "b":
				try //may throw an IOException error
				{
					//used for line counting
					Scanner textRead = new Scanner(new File(fileLoc));
					while(textRead.hasNext())
					{
						System.out.println(sfp.readSong());
						//moves down the file three lines
						textRead.nextLine();
						textRead.nextLine();
						textRead.nextLine();
					}
				}
				catch(IOException e)
				{
					System.out.println("There was an error while opening the file.  Exiting...");
				}
				break;
			case "c":
				break;
			default:
				System.out.println("Did not understand input.  Exiting...");
				break;
		}
		
	}

}
