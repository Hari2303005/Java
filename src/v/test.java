package v;

import java.util.Scanner;

public class test {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		int [] niz = new int[n];
		
		for(int i=0;i<niz.length;i++) {
			niz[i]=sc.nextInt();
		}
		
		z1 analiza = new z1();
		double prosjek = analiza.nadjiParniPozitivniProsjek(niz);
		System.out.print(prosjek);

	}

}
