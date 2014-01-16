package SongStoreErrorCatch;

import javax.swing.JFrame;
import javax.swing.JPanel;

/*
 * Student Name: Dov Greenwood
 * Date: 8/8/13
 * 
 * This class is used to create a frame for the music store, and has a main method to display it.
 * */

public class SongStoreFrame2 extends JFrame {
	
	public SongStoreFrame2() {
		setTitle("Music Store");
		setSize(600,400);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setResizable(false);
		JPanel panel = new ValidatingStorePanel();
		this.add(panel);
	}
	
	public static void main(String [] args) {
		JFrame frame = new SongStoreFrame2();
		frame.setVisible(true);
	}
	
}
