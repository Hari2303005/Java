package vjezbe;

import java.util.Scanner;

public class zad8 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		// 0 - slobodno
		// 1 - zauzeto

		String string = sc.nextLine();
		int pozicija = sc.nextInt();
		

		if(pozicija==0) {
			if(string.charAt(1) == '0') {
				System.out.println("Slobodno polje");
			}
			else {
				System.out.println("Zauzeto polje");
			}
		}
		else if(pozicija==string.length()-1) {
			if(string.charAt(pozicija-1)=='0') {
				System.out.println("Slobodno polje");
			}
			else {
				System.out.println("Zauzeto polje");
			}
		}
		
		else if(string.charAt(pozicija-1)=='0' && string.charAt(pozicija+1)=='0') {
			System.out.println("Slobodna polja");
		}
		else {
            System.out.println("Nema slobodnih polja");
		}
	}
}
	

