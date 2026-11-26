package vzb;
import javax.swing.JFrame;
import java.awt.FlowLayout;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class Konverter extends JFrame{

	private JTextField poljeEUR;
	private JTextField poljeUSD;
	private JTextField poljeGDP;
	
	public Konverter() {
		super("Konvertor valuta");
		setSize(250,170);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Konverter forma = new Konverter();
		
		forma.setVisible(true);
	}

}
