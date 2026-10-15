package vjezbe;

import java.util.Scanner;

public class zad9 {

	public static void main(String[] args) {
	   Scanner sc = new Scanner(System.in);
	   String s = sc.nextLine();
	   String s1="";
	   for(int i=0;i<s.length();i++) {
		   char c = s.charAt(i);
		   if(c%2==0) {
			   s1+='0';
		   }
		   else {
			   s1+='1';
		   }
	   }
	   System.out.print(s1);

	}

}
