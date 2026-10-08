package v;

import java.util.Scanner;
import java.util.Random;

public class z1 {
	

	
		public double nadjiParniPozitivniProsjek(int []niz) {
			int s=0;
			int cnt=0;
			
			for(int i=0;i<niz.length;i++) {
				if(niz[i]>0 && niz[i]%2==0) {
					s+=niz[i];
					cnt++;
				}
			}
			if(cnt==0) {
				return 0;
			}
			return (double) s/cnt;
		}
	


	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		Random random = new Random();
		
		System.out.print("Unesi duzinu niza: ");
		
		int n = sc.nextInt();
		double [] niz = new double[n];

		for(int i=0;i<niz.length;i++) {
			niz[i]=random.nextInt(10) + 1;
		}
		
		System.out.print("Niz je : ");
		
		for(int i=0;i<niz.length;i++) {
			System.out.print(niz[i] + " ");
		}
		
		
		
		for(int i=0;i<niz.length;i++) {
			if(niz[i]%2==0) {
				niz[i]=-1*niz[i];
			}
			else {
				niz[i]=1/niz[i];
			}
			
		}
		
		System.out.print("Izmijenjeni niz je : ");
		
		for(int i=0;i<niz.length;i++) {
			System.out.print(niz[i] + " ");
		}
		
		
	}

}
