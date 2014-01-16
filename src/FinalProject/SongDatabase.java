package FinalProject;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

/*
 * Student Name: Dov Greenwood
 * Date: 8/12/13
 * 
 * This class contains methods that are used to read and write songs to a database file ("songData.dat").
 * It has a method to read songs from the file, write songs to the file, delete songs from the file,
 * and edit songs in the file.
 * */

public class SongDatabase {
	
	public static Song [] readSongs() {
		Song [] fileSongs = {
							new Song("---","---","---","---",0)
							};
		ArrayList<Song> songsAsList = new ArrayList<Song>();
		
		ObjectInputStream in = null;
		try {
			in = new ObjectInputStream(
					new BufferedInputStream(
					new FileInputStream("songData.dat")));
			songsAsList = (ArrayList<Song>) in.readObject();
			in.close();
			if(songsAsList.size() != 0) {
				fileSongs = new Song [songsAsList.size()];
				for(int i = 0; i < fileSongs.length; i ++) {
					fileSongs[i] = songsAsList.get(i);
				}
			}
		}
		catch(Exception e) {
		}
		
		return fileSongs;
	}
	
	public static void writeSong(Song addedSong) {
		ArrayList<Song> newSongs = new ArrayList<Song>();
		Song [] newSongArray = SongDatabase.readSongs();
		for(Song s : newSongArray) {
			newSongs.add(s);
		}
		newSongs.add(addedSong);
		ObjectOutputStream out = null;
		try {
			out = new ObjectOutputStream(
										new BufferedOutputStream(
										new FileOutputStream("songData.dat")));
			out.writeObject(newSongs);
			out.flush();
			out.close();
		}
		catch(Exception e) {
		}
	}

	public static void deleteSong(int index) {
		ArrayList<Song> newSongs = new ArrayList<Song>();
		Song [] newSongArray = SongDatabase.readSongs();
		for(Song s : newSongArray) {
			newSongs.add(s);
		}
		newSongs.remove(index);
		ObjectOutputStream out = null;
		try {
			out = new ObjectOutputStream(
										new BufferedOutputStream(
										new FileOutputStream("songData.dat")));
			out.writeObject(newSongs);
			out.flush();
			out.close();
		}
		catch(Exception e) {
		}
	}

	public static void editSong(int index, Song replaceSong) {
		ArrayList<Song> newSongs = new ArrayList<Song>();
		Song [] newSongArray = SongDatabase.readSongs();
		for(Song s : newSongArray) {
			newSongs.add(s);
		}
		newSongs.set(index, replaceSong);
		ObjectOutputStream out = null;
		try {
			out = new ObjectOutputStream(
										new BufferedOutputStream(
										new FileOutputStream("songData.dat")));
			out.writeObject(newSongs);
			out.flush();
			out.close();
		}
		catch(Exception e) {
		}
	}
	
}
