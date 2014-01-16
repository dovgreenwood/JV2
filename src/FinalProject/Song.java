package FinalProject;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

/*
 * Student Name: Dov Greenwood
 * Date: 8/12/13
 * 
 * This object is used to store information about a song.  It also contains getter and setter methods
 * for the class members, and writeObject and readObject methods to read and write a song to a file.
 * */

public class Song implements Serializable {
	
	private String itemCode;
	private String description;
	private String artist;
	private String album;
	private double price;
	
	public Song(String itemCode, String description,
			String artist, String album, double price) {
		setItemCode(itemCode);
		setDescription(description);
		setArtist(artist);
		setAlbum(album);
		setPrice(price);
	}

	public String getItemCode() {
		return itemCode;
	}

	public void setItemCode(String itemCode) {
		this.itemCode = itemCode;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getArtist() {
		return artist;
	}

	public void setArtist(String artist) {
		this.artist = artist;
	}

	public String getAlbum() {
		return album;
	}

	public void setAlbum(String album) {
		this.album = album;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}
	
	private void writeObject(ObjectOutputStream out) throws IOException, ClassNotFoundException {
		out.writeUTF(itemCode);
		out.writeUTF(description);
		out.writeUTF(artist);
		out.writeUTF(album);
		out.writeDouble(price);
	}
	
	private void readObject(ObjectInputStream in) throws IOException {
		setItemCode(in.readUTF());
		setDescription(in.readUTF());
		setArtist(in.readUTF());
		setAlbum(in.readUTF());
		setPrice(in.readDouble());
	}
	
	public String toString() {
		return getDescription();
	}
	
}
