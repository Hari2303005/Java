package vjezbe;

import java.util.Scanner;

//Da li je recenica palindrom 
public class zad2 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
        String recenica = sc.nextLine().trim();
        StringBuilder sb = new StringBuilder(recenica);
        
        String obrnuto = sb.reverse().toString();
        
        if(recenica.equalsIgnoreCase(obrnuto)) {
        	System.out.println("Jeste");
        }
        else {
        	System.out.print("Nije");
        	
        }
	}
	
		}

	


