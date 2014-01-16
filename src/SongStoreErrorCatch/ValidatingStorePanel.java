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
import javax.swing.JOptionPane;
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

public class ValidatingStorePanel extends StorePanel {

	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == exit)
			System.exit(0);
		if(e.getSource() == calculate) {

			if(nameBox.getText().equals("")) {
				JOptionPane.showMessageDialog(this, "Please enter a name.", "Name Error", JOptionPane.ERROR_MESSAGE);
				return;
			}
			if(emailBox.getText().equals("")) {
				JOptionPane.showMessageDialog(this, "Please enter an email address.", "E-mail Error", JOptionPane.ERROR_MESSAGE);
				return;
			}
			if(payType.getSelectedItem().equals("")) {
				JOptionPane.showMessageDialog(this, "Please enter your credit card.", "Credit Card Error", JOptionPane.ERROR_MESSAGE);
				return;
			}
			if(songs.getSelectedValuesList().size() == 0) {
				JOptionPane.showMessageDialog(this, "Please choose at least one song.", "Song Error", JOptionPane.ERROR_MESSAGE);
				return;
			}
			double total = 0;
			for(int i : songs.getSelectedIndices()) {
				total += songArray[i].getPrice();
			}
			totalCost.setText(String.format("$%.2f", total));
		}				


	}

}
