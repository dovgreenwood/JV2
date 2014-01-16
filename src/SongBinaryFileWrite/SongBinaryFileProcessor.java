package SongBinaryFileWrite;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

/*
 *  Student Name: Dov Greenwood
 *  Date: 6/19/13
 *  
 *  This class (which implements the abstract methods from SongReader and SongWriter) provides
 *  the methods to read and write Songs to a text file.  It has a writeSong method, which accepts a
 *  song and then writes the data to the file, and readSong for reading songs from the file.
 **/

public class SongBinaryFileProcessor implements SongReader, SongWriter
{

	private String fileName;
	private DataInputStream myFile;
	
	public SongBinaryFileProcessor(String fileName)
	{
		this.fileName = fileName;
		try
		{
			myFile = new DataInputStream(
					new BufferedInputStream(
					new FileInputStream(fileName)));
		}catch(Exception e){}
	}
	
	public void writeSong(Song s)
	{
		try
		{
			DataOutputStream out = new DataOutputStream(
									new BufferedOutputStream(
									new FileOutputStream(fileName, true)));
			out.writeUTF(s.getTitle());
			out.writeUTF(s.getGenre());
			out.writeUTF(s.getArtist());
			out.flush();
			out.close();
		}
		catch(IOException e)
		{
			System.out.println("An error occurred while opening the file");
		}
	}
	
	public Song readSong()
	{
		try {
			return new Song(myFile.readUTF(),myFile.readUTF(),myFile.readUTF());
		} catch (IOException e)
		{
			return null;
		}
	}
	
}
