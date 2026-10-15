package vjezbe;

import java.util.Scanner;

public class zad3 {

	public static void main(String[] args) {
		//Br samoglasnika i suglasnika
		
		Scanner sc = new Scanner(System.in);
		
		String recenica = sc.nextLine().trim().toLowerCase();

		
		int samoglasnici=0;
		int suglasnici=0;
		for(int i=0;i<recenica.length();i++) {
			char c = recenica.charAt(i);
			if(c=='a' || c=='e' ||c=='i' ||c=='o' || c=='u') {
				samoglasnici++;
			}
			else {
				suglasnici++;
			}
				
		}
		System.out.print(samoglasnici + " " + suglasnici);
		

	}

}
