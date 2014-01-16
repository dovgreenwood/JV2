package FinalProject;

import javax.swing.JFrame;
import javax.swing.JPanel;

/*
 * Student Name: Dov Greenwood
 * Date: 8/12/13
 * 
 * This program is used to create a frame for, and display, a SongInfoPanel.
 * */

public class SongFrame extends JFrame {
	
	public SongFrame() {
		setTitle("Song Information");
		setSize(600, 400);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		JPanel panel = new SongInfoPanel();
		this.add(panel);
	}
	
	public static void main(String [] args) {
		JFrame frame = new SongFrame();
		frame.setVisible(true);
	}
	
}
