package vjezbe;

import java.util.Scanner;

public class zad5 {

	public static void main(String[] args) {
		// provjeriti da li je string 2 podstring stringa 1

		Scanner sc = new Scanner(System.in);

		String string1 = sc.nextLine().toLowerCase().trim();
		String string2 = sc.nextLine().toLowerCase().trim();
		
		if(string1.contains(string2)) {
			System.out.print("da");
		}
		else {
			System.out.print("ne");
		}
	}

}
