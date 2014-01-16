package SongBinaryFileWrite;

import java.io.*;
import java.util.Scanner;

/*
 *  Student Name: Dov Greenwood
 *  Date: 6/19/13
 *  
 *  This program tests the SongBinaryFileProcessor's readSong and writeSong methods.  It gives three
 *  options upon typing in the file that you want to access: read all of the songs, write another song,
 *  or quit.
 **/

public class Assignment6
{

	public static void main(String [] args)
	{
		Scanner input = new Scanner(System.in);
		System.out.print("File to read/write to: ");
		String fileLoc = input.nextLine();
		SongBinaryFileProcessor sfp = new SongBinaryFileProcessor(fileLoc); //sfp: song-file processor
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
				try
				{
					//used for line counting
					DataInputStream textRead = new DataInputStream(
												new BufferedInputStream(
												new FileInputStream(fileLoc)));
					while(textRead.readUTF() != null)
					{
						System.out.println(sfp.readSong());
						//moves down the file two more lines
						textRead.readUTF();
						textRead.readUTF();
					}
				}catch(IOException e){}
				break;
			case "c":
				break;
			default:
				System.out.println("Did not understand input.  Exiting...");
				break;
		}
		
	}

}
