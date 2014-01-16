package FinalProject;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

/*
 * Student Name: Dov Greenwood
 * Date: 8/12/13
 * 
 * This class defines a panel to contain song information.  It has display boxes for 
 * a song's item code, description, artist, album, and price.  In addition, methods are also defined
 * to listen to buttons so that you can add new songs, edit songs, and delete songs.  When editing
 * and adding songs, the program checks your input, and fills in anything that is missing or incorrect.
 * */

public class SongInfoPanel extends JPanel implements ActionListener {
	
	private String selectedOption;
	
	private JComboBox<Song> songs;
	
	private JTextField codeBox;
	private JTextField descriptionBox;
	private JTextField artistBox;
	private JTextField albumBox;
	private JTextField priceBox;
	
	private JButton add;
	private JButton edit;
	private JButton delete;
	private JButton accept;
	private JButton cancel;
	private JButton exit;
	
	public SongInfoPanel() {
		
		this.setLayout(new BorderLayout());
		
		songs = new JComboBox<Song>(SongDatabase.readSongs());
		songs.addActionListener(new songListListener());
		
		this.add(songs, BorderLayout.NORTH);
		this.add(newTextPanel(), BorderLayout.CENTER);
		this.add(newButtonPanel(), BorderLayout.SOUTH);
		
	}
	
	private JPanel newTextPanel() {
		JPanel textPanel = new JPanel(new GridLayout(8, 2));
		codeBox = new JTextField();
		codeBox.setEditable(false);
		descriptionBox = new JTextField();
		descriptionBox.setEditable(false);
		artistBox = new JTextField();
		artistBox.setEditable(false);
		albumBox = new JTextField();
		albumBox.setEditable(false);
		priceBox = new JTextField();
		priceBox.setEditable(false);
				
		textPanel.add(new JLabel("Item Code: "));
		textPanel.add(codeBox);
		textPanel.add(new JLabel("Description: "));
		textPanel.add(descriptionBox);
		textPanel.add(new JLabel("Artist: "));
		textPanel.add(artistBox);
		textPanel.add(new JLabel("Album: "));
		textPanel.add(albumBox);
		textPanel.add(new JLabel("Price: (in $'s)"));
		textPanel.add(priceBox);
		
		displaySongInfo();
		
		return textPanel;
	}
	
	private JPanel newButtonPanel() {
		
		JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
		add = new JButton("ADD");
		add.addActionListener(new buttonListener());
		edit = new JButton("EDIT");
		edit.addActionListener(new buttonListener());
		delete = new JButton("DELETE");
		delete.addActionListener(new buttonListener());
		accept = new JButton("ACCEPT");
		accept.addActionListener(new acceptCancelListener());
		accept.setEnabled(false);
		cancel = new JButton("CANCEL");
		cancel.addActionListener(new acceptCancelListener());
		cancel.setEnabled(false);
		exit = new JButton("EXIT");
		exit.addActionListener(this);
		buttonPanel.add(add);
		buttonPanel.add(edit);
		buttonPanel.add(delete);
		buttonPanel.add(accept);
		buttonPanel.add(cancel);
		buttonPanel.add(exit);
		
		return buttonPanel;
	}

	private void displaySongInfo() {
		codeBox.setText(( (Song) songs.getSelectedItem() ).getItemCode());
		descriptionBox.setText(( (Song) songs.getSelectedItem() ).getDescription());
		artistBox.setText(( (Song) songs.getSelectedItem() ).getArtist());
		albumBox.setText(( (Song) songs.getSelectedItem() ).getAlbum());
		priceBox.setText( String.format( "%.2f", ((Song) songs.getSelectedItem() ).getPrice() ) );
	}
	
	public void actionPerformed(ActionEvent ae) {
		if(ae.getSource() == exit)
			System.exit(0);
	}
	
	private class songListListener implements ActionListener {

		public void actionPerformed(ActionEvent ae) {
			displaySongInfo();
		}
		
	}
	
	private class buttonListener implements ActionListener {

		public void actionPerformed(ActionEvent ae) {
			enableButtons();
			songs.setEnabled(false);

			if(ae.getSource() == add) {
				selectedOption = "add";
				enableTextFields(true, true, true, true, true);
				clearTextFields(true, true, true, true, true);
			}
			if(ae.getSource() == edit) {
				selectedOption = "edit";
				enableTextFields(false, true, true, false, true);
			}
			if(ae.getSource() == delete) {
				selectedOption = "delete";
			}
		}
		
		private void clearTextFields(boolean c,boolean d,boolean ar,boolean al,boolean p) {
			if(c)
				codeBox.setText("");
			if(d)
				descriptionBox.setText("");
			if(ar)
				artistBox.setText("");
			if(al)
				albumBox.setText("");
			if(p)
				priceBox.setText("");
		}

		private void enableTextFields(boolean c,boolean d,boolean ar,boolean al,boolean p) {
			codeBox.setEditable(c);
			descriptionBox.setEditable(d);
			artistBox.setEditable(ar);
			albumBox.setEditable(al);
			priceBox.setEditable(p);
		}
		
		private void enableButtons() {
			accept.setEnabled(true);
			cancel.setEnabled(true);
			
			add.setEnabled(false);
			edit.setEnabled(false);
			delete.setEnabled(false);
		}
	}
	
	private class acceptCancelListener implements ActionListener {

		public void actionPerformed(ActionEvent ae) {
			disableButtons();
			disableTextFieds();
			songs.setEnabled(true);

			if(ae.getSource() == accept) {
				validateInfo();
				switch(selectedOption) {
					case "add":
						SongDatabase.writeSong(new Song(
								codeBox.getText(),
								descriptionBox.getText(),
								artistBox.getText(),
								albumBox.getText(),
								Double.parseDouble(priceBox.getText())
								));
						break;
					case "delete":
						SongDatabase.deleteSong(songs.getSelectedIndex());
						break;
					case "edit":
						SongDatabase.editSong(songs.getSelectedIndex(), new Song(
								codeBox.getText(),
								descriptionBox.getText(),
								artistBox.getText(),
								albumBox.getText(),
								Double.parseDouble(priceBox.getText())
								));
						break;
					}
				
					DefaultComboBoxModel<Song> m = new DefaultComboBoxModel<Song>(SongDatabase.readSongs());
					songs.setModel(m);
			}
			songs.setSelectedIndex(0);
			displaySongInfo();
		}
		
		private void validateInfo() {
			
			if(codeBox.getText().equals("")) {
				JOptionPane.showMessageDialog(new SongInfoPanel(), "Error Encountered: item code not entered.\n" + 
																	"Setting to default...", "", JOptionPane.ERROR_MESSAGE);
				codeBox.setText("(default)");
			}
			if(descriptionBox.getText().equals("")) {
				JOptionPane.showMessageDialog(new SongInfoPanel(), "Error Encountered: description not entered.\n" +
																	"Setting to default...", "", JOptionPane.ERROR_MESSAGE);
				descriptionBox.setText("(default)");
			}
			if(artistBox.getText().equals("")) {
				JOptionPane.showMessageDialog(new SongInfoPanel(), "Error Encountered: artist not entered.\n" +
																	"Setting to default...", "", JOptionPane.ERROR_MESSAGE);
				artistBox.setText("(default)");
			}
			if(albumBox.getText().equals("")) {
				JOptionPane.showMessageDialog(new SongInfoPanel(), "Error Encountered: album not entered.\n" +
																	"Setting as single...", "", JOptionPane.ERROR_MESSAGE);
				albumBox.setText("(single)");
			}
			if(priceBox.getText().equals("")) {
				JOptionPane.showMessageDialog(new SongInfoPanel(), "Error Encountered: price not entered.\n" +
																	"Setting to zero...", "", JOptionPane.ERROR_MESSAGE);
				priceBox.setText("0");
			}
			try {
				Double.parseDouble(priceBox.getText());
			}
			catch(Exception e) {
				JOptionPane.showMessageDialog(new SongInfoPanel(), "Error Encountered: price must be a number.\n" +
						"Setting to zero...", "", JOptionPane.ERROR_MESSAGE);
				priceBox.setText("0");
			}
			
		}

		private void disableTextFieds() {
			codeBox.setEditable(false);
			descriptionBox.setEditable(false);
			artistBox.setEditable(false);
			albumBox.setEditable(false);
			priceBox.setEditable(false);
		}

		private void disableButtons() {
			accept.setEnabled(false);
			cancel.setEnabled(false);

			add.setEnabled(true);
			edit.setEnabled(true);
			delete.setEnabled(true);
		}
	}
	
}
