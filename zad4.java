package vjezbe;

import java.util.Scanner;

public class zad4 {

	public static void main(String[] args) {
		// Koje slovo se ponavlja u stringu

		Scanner sc = new Scanner(System.in);
		
		String recenica = sc.nextLine();
		for(int i=0;i<recenica.length()-1;i++) {
			char c1=recenica.charAt(i);
			char c2=recenica.charAt(i+1);
			if(c1==c2) {
				System.out.println("Slovo koje se ponavlja je " + c1);
						
			}
		}
	}

}
