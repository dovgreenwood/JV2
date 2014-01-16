package CalculateInvoice;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

/*
 * Student Name: Dov Greenwood
 * Date: 8/7/13
 * 
 * This class is used to create a panel to be added to a frame, which contains the necessary GUI
 * to input the data necessary to calculate total invoice, and also contains space for displaying
 * the total invoice.  Inside of the InvoicePanel class, there is only its constructor, the
 * ActionListener's overridden actionPerformed method, and a method for displaying discounts called
 * "displayDiscounts."
 * */

public class InvoicePanel extends JPanel implements ActionListener {

	private JTextField subtotal;
	private JTextField discountPercent;
	private JTextField discountVal;
	private JTextField total;
	
	private JButton calculate;
	private JButton exit;
	
	public InvoicePanel() {
		JPanel tFields = new JPanel(new FlowLayout(FlowLayout.RIGHT));
		
		subtotal = new JTextField(10);
		discountPercent = new JTextField(10);
		discountPercent.setEditable(false);
		discountVal = new JTextField(10);
		discountVal.setEditable(false);
		total = new JTextField(10);
		total.setEditable(false);
		
		tFields.add(new JLabel("Invoice Sub-Total: "));
		tFields.add(subtotal);
		tFields.add(new JLabel("Percentage of Discount: "));
		tFields.add(discountPercent);
		tFields.add(new JLabel("Discount Value: "));
		tFields.add(discountVal);
		tFields.add(new JLabel("Total Invoice: "));
		tFields.add(total);
		
		
		JPanel buttons = new JPanel(new FlowLayout(FlowLayout.RIGHT));
		
		calculate = new JButton("Calculate");
		calculate.addActionListener(this);
		exit = new JButton("Exit");
		exit.addActionListener(this);
		
		buttons.add(calculate);
		buttons.add(exit);
		
		this.setLayout(new BorderLayout());
		this.add(tFields, BorderLayout.CENTER);
		this.add(buttons, BorderLayout.SOUTH);
		
	}
	
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == exit)
			System.exit(0);
		else if(e.getSource() == calculate)
			displayDiscounts();
	}

	private void displayDiscounts() {
		//not validating input is an integer (doesn't affect flow of program)
		int sub = Integer.parseInt(subtotal.getText());
		double discount = 0;
		
		if(sub < 100)
			discount = 0;
		else if(sub < 200)
			discount = 0.1;
		else
			discount = 0.15;
		
		discountPercent.setText( (discount * 100) + "%");
		discountVal.setText(Double.toString(discount * sub));
		total.setText(Double.toString( sub - (discount * sub) ));
	}
	
}
