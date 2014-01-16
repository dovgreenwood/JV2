package SongStore;

import javax.swing.JFrame;
import javax.swing.JPanel;

/*
 * Student Name: Dov Greenwood
 * Date: 8/8/13
 * 
 * This class is used to create a frame for the music store, and has a main method to display it.
 * */

public class SongStoreFrame extends JFrame {
	
	public SongStoreFrame() {
		setTitle("Music Store");
		setSize(600,400);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setResizable(false);
		JPanel panel = new StorePanel();
		this.add(panel);
	}
	
	public static void main(String [] args) {
		JFrame frame = new SongStoreFrame();
		frame.setVisible(true);
	}
	
}
