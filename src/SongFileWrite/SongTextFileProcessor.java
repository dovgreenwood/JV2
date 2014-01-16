package SongFileWrite;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

/*
 *  Student Name: Dov Greenwood
 *  Date: 6/19/13
 *  
 *  This class (which implements the abstract methods from SongReader and SongWriter) provides
 *  the methods to read and write Songs to a text file.  It has a writeSong method, which accepts a
 *  song and then writes the data to the file, and two methods for reading the songs from files:
 *  readSong (which returns only one song), and readAllSongs (which reads all of the songs from
 *  a file and returns them as an array).
 **/

public class SongTextFileProcessor implements SongReader, SongWriter
{

	private String fileName;
	private Scanner input;
	
	public SongTextFileProcessor(String fileName)
	{
		this.fileName = fileName;
		try
		{
			input = new Scanner(new File(fileName));
		}catch(Exception e){}
	}
	
	public void writeSong(Song s)
	{
		try
		{
			PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter(fileName, true) ) );
			out.println(s.getSongInfo());
			out.flush();
			out.close();
		}
		catch(IOException e)
		{
			System.out.println("An error occurred while opening the file");
		}
	}

	public Song [] readAllSongs()
	{
		try
		{
			BufferedReader in = new BufferedReader(new FileReader(fileName));
			ArrayList<Song> songs = new ArrayList<Song>();
			
			Scanner myFile = new Scanner(in);
			String artist = "";
			String genre = "";
			String title = "";
			
			while(myFile.hasNext())
			{
				if(title.equals(""))
				{
					title = myFile.nextLine();
				}
				else if(genre.equals(""))
				{
					genre = myFile.nextLine();
				}
				else if(artist.equals(""))
				{
					artist = myFile.nextLine();
				}
				else
				{
					songs.add(new Song(title, genre, artist));
					artist = ""; genre = ""; title = "";
				}
			}
			if(!(artist.equals("")))
				songs.add(new Song(title, genre, artist));
			myFile.close();
			return songs.toArray(new Song[0]);
		}
		catch(Exception e)
		{
			System.out.println("There was an error while opening the file.");
		}
		return null;
	}
	
	public Song readSong()
	{
		return new Song(input.nextLine(),input.nextLine(),input.nextLine());
	}
	
}
