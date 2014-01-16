package SongBinaryFileWrite;

/*
 *  Student Name: Dov Greenwood
 *  Date: 6/19/13
 *  
 *  This class is used to store general information about a song, including the artist,
 *  the title, and the genre, and it has getter and setter methods for these attributes.
 *  It also provides a toString method, for printing the songs information, and a getSongInfo
 *  method for formatting the song data for a file.
 **/

public class Song
{
	
	private String title;
	private String genre;
	private String artist;
	
	public Song(String title, String genre, String artist)
	{
		this.setTitle(title);
		this.setGenre(genre);
		this.setArtist(artist);
	}

	public String getTitle()
	{
		return title;
	}

	public void setTitle(String title)
	{
		this.title = title;
	}

	public String getGenre()
	{
		return genre;
	}

	public void setGenre(String genre)
	{
		this.genre = genre;
	}

	public String getArtist()
	{
		return artist;
	}

	public void setArtist(String artist)
	{
		this.artist = artist;
	}
	
	public String getSongInfo()
	{
		return title + "\n" + 
				genre + "\n" + 
				artist;
	}
	
	public String toString()
	{
		return "artist: " + artist + "\ttitle: " + title + "\tgenre: " + genre;
	}
	
}
