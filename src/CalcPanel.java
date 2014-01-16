
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class CalcPanel extends JPanel implements ActionListener{

	private JLabel label1;
	private JLabel label2;
	private JLabel label3;
	
	private JTextField box1;
	private JTextField box2;
	private JTextField box3;
	
	private JButton calc;
	private JButton exit;
	
	public CalcPanel() {
		
		JPanel text = new JPanel();
		text.setLayout(new FlowLayout(FlowLayout.CENTER));
		JPanel buttons = new JPanel();
		buttons.setLayout(new FlowLayout(FlowLayout.RIGHT));
		
		label1 = new JLabel("First Value:      ");
		label2 = new JLabel("Second Value: ");
		label3 = new JLabel("Sum Is:              ");
		
		box1 = new JTextField(10);
		box2 = new JTextField(10);
		box3 = new JTextField(10);
		box3.setEditable(false);
		
		calc = new JButton("Calculate");
		calc.addActionListener(this);
		exit = new JButton("Exit");
		exit.addActionListener(this);
		
		text.add(label1);
		text.add(box1);
		text.add(label2);
		text.add(box2);
		text.add(label3);
		text.add(box3);
		
		buttons.add(calc);
		buttons.add(exit);
		
		this.setLayout(new BorderLayout());
		this.add(text, BorderLayout.CENTER);
		this.add(buttons, BorderLayout.SOUTH);
		
	}
	
	public void actionPerformed(ActionEvent e) {
		
		if(e.getSource() == calc) {
			int sum = Integer.parseInt(box1.getText()) + Integer.parseInt(box2.getText());
			box3.setText(Integer.toString(sum));
		}
		else if(e.getSource() == exit) {
			System.exit(0);
		}
		
	}
	
}
