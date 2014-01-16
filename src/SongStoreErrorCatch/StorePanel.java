package SongStoreErrorCatch;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.ScrollPaneConstants;
import javax.swing.border.Border;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

/*
 * Student Name: Dov Greenwood
 * Date: 8/8/13
 * 
 * This class is a panel for holding any GUI components necessary for an electronic music store.
 * It implements ActionListener and ListSelectionListener to handle events from buttons and lists.
 * There are text fields for entering your name and email, and a combo box for entering your
 * credit card type.  In the middle of the panel, there is a list for selecting which songs(s) you
 * want, which are then displayed in your shopping cart to the right.  Upon clicking the calculate
 * button, your total price will appear in the bottom right corner.
 * */

public class StorePanel extends JPanel implements ActionListener, ListSelectionListener {
	
	protected JTextField nameBox;
	protected JTextField emailBox;
	protected JComboBox<String> payType;
	private final String [] creditCards = {"", "Visa", "Mastercard", "Amex"};
	
	private Border cart;
	private JTextArea items;
	private JScrollPane cartScroll;
	
	private JScrollPane songsListScroll;
	protected JList<String> songs;
	protected Song [] songArray = {
								new Song("Somebody that I Used to Know","Gotye",3),
								new Song("Call Me Maybe","Carly Rae Jepsen",4),
								new Song("Lights","Ellie Golding",2),
								new Song("Stronger","Kellie Clarkson",3),
								new Song("Starships","Nicki Minaj",0.5)
								};
	private String [] songNames = new String [songArray.length];
	
	protected JTextField totalCost;
	protected JButton calculate;
	protected JButton exit;

	public StorePanel() {
		
		JPanel infoPanel = new JPanel();
		//sized to fit 13 components with 1 column
		infoPanel.setLayout(new GridLayout(13,1));
		
		nameBox = new JTextField(12);
		emailBox = new JTextField(12);
		payType = new JComboBox<String>(creditCards);
		
		infoPanel.add(new JLabel("Name:"));
		infoPanel.add(nameBox);
		infoPanel.add(new JLabel("e-mail:"));
		infoPanel.add(emailBox);
		infoPanel.add(new JLabel("Credit Card:"));
		infoPanel.add(payType);
		
		for(int i = 0; i < songArray.length; i ++)
			songNames[i] = songArray[i].getTitle();
		songs = new JList<String>(songNames);
		songs.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
		songs.getSelectionModel().addListSelectionListener(this);
		songsListScroll = new JScrollPane(songs, ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED, ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		
		
		cart = BorderFactory.createTitledBorder("Your Shopping Cart Contains:");
		items = new JTextArea(10, 20);
		items.setEditable(false);
		cartScroll = new JScrollPane(items, ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED, ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		cartScroll.setBorder(cart);
		
		
		JPanel bottomPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
		totalCost = new JTextField(10);
		totalCost.setEditable(false);
		
		calculate = new JButton("Calculate");
		calculate.addActionListener(this);
		exit = new JButton("Exit");
		exit.addActionListener(this);
		
		bottomPanel.add(new JLabel("Total: "));
		bottomPanel.add(totalCost);
		bottomPanel.add(calculate);
		bottomPanel.add(exit);
		
		
		this.setLayout(new BorderLayout());
		this.add(infoPanel, BorderLayout.WEST);
		this.add(songsListScroll, BorderLayout.CENTER);
		this.add(cartScroll, BorderLayout.EAST);
		this.add(bottomPanel, BorderLayout.SOUTH);
	}
	
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == exit)
			System.exit(0);
		else if(e.getSource() == calculate) {
			double total = 0;
			for(int i : songs.getSelectedIndices()) {
				total += songArray[i].getPrice();
			}
			totalCost.setText(String.format("$%.2f", total));
		}
		
	}

	public void valueChanged(ListSelectionEvent e) {
		String itemsVal = "";
		for(int i : songs.getSelectedIndices()) {
			itemsVal += songArray[i] + "\n";
		}
		items.setText(itemsVal);
	}

}
