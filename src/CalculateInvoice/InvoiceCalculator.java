package CalculateInvoice;

import javax.swing.JFrame;
import javax.swing.JPanel;

/*
 * Student Name: Dov Greenwood
 * Date: 8/7/13
 * 
 * This class is simply used as a frame to contain an Invoice Panel.  It also contains
 * the main method to run the program. 
 * */

public class InvoiceCalculator extends JFrame {
	
	public InvoiceCalculator() {
		setTitle("Invoice Calculator");
		setSize(300, 300);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setResizable(false);
		JPanel panel = new InvoicePanel();
		this.add(panel);
	}
	
	public static void main(String [] args) {
		InvoiceCalculator calc = new InvoiceCalculator();
		calc.setVisible(true);
	}
	
}
