
import javax.swing.JFrame;
import javax.swing.JPanel;

public class CalculatorFrame extends JFrame {
	
	public CalculatorFrame() {
		setTitle("Addition Calculator");
		setSize(267,200);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		JPanel panel = new CalcPanel();
		this.add(panel);
	}
	
	public static void main(String [] args) {
		JFrame frame = new CalculatorFrame();
		frame.setVisible(true);
	}
	
}
