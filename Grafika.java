package vzb;
import javax.swing.JOptionPane;

public class Grafika {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String ime = JOptionPane.showInputDialog(null, "Unesite Ime");
		String prezime = JOptionPane.showInputDialog(null, "Unesite Prezime");
		String unosGod = JOptionPane.showInputDialog(null, "Unesite unosGod");
		
		int godine = Integer.parseInt(unosGod);
		
	
		 String poruka = "Pregled podataka:\n"
	                + "Ime: " + ime + "\n"
	                + "Prezime: " + prezime + "\n"
	                + "Godine: " + godine + "\n\n"
	                + "Da li su podaci tačni?";
		
		int izbor = JOptionPane.showConfirmDialog(null,poruka,"Provjera podataka",JOptionPane.YES_NO_OPTION);
		 if (izbor == JOptionPane.YES_OPTION) {
	            JOptionPane.showMessageDialog(null, "Podaci su tacni");
	        } else {
	            JOptionPane.showMessageDialog(null, "Podaci nisu tacni");
	        }
	}
	}


