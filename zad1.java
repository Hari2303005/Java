package vjezbe;

import java.util.Scanner;
//Broj rijeci u recenici

public class zad1 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
        String recenica = sc.nextLine().trim();
        
        String[] rijeci = recenica.split("\\s+");
        System.out.print("Ukupan broj rijeci je: " + rijeci.length);
        
	}

}
