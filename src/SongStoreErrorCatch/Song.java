package SongStoreErrorCatch;

/*
 * Student Name: Dov Greenwood
 * Date: 8/8/13
 * 
 * This class is used for storing data about songs.  Along with a toString method to
 * display the data.
 * */

public class Song {
	
	private String title;
	private String artist;
	private double price;
	
	public Song(String title, String artist, double price) {
		this.title = title;
		this.artist = artist;
		this.price = price;
	}
	
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getArtist() {
		return artist;
	}
	public void setArtist(String artist) {
		this.artist = artist;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}

	public String toString() {
		return "Song Title: " + title + "\nArtist: " + artist + "\nPrice: $"
				+ String.format("%.2f" ,price) + "\n";
	}
	
}
