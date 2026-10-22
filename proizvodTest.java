package nedelja6;

import java.time.LocalDate;
import java.util.ArrayList;

public class proizvodTest {

	public static void main(String[] args) {
		Garderoba g1 = new Garderoba("Majica","3243234234","Crna Gora",2026,(int) 2.5,"Kasmir","zimska");
		HemijskiProizvodi h1 = new HemijskiProizvodi("prasak","32324242323","Amerika",2026,(int) 9.5,23.4f,true);
		Hrana h2 = new Hrana("pica","32424242332","Italija",2026,11,600,LocalDate.of(2026,10,22), null);		
			
		ArrayList<Proizvod>lista = new ArrayList<>();
		lista.add(g1);
		lista.add(h1);
		lista.add(h2);
		
		
		for(Proizvod p:lista) {
			System.out.println(p);
		}
	}
}
