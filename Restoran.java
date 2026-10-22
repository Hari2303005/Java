package nedeljaa6;

import java.util.ArrayList;

public class Restoran {

	private String naziv;
	private String adresa;
	private int pib;
	private ArrayList<Zaposleni> zaposleni;
	
	public String getNaziv() {
		return naziv;
	}

	public void setNaziv(String naziv) {
		this.naziv = naziv;
	}

	public String getAdresa() {
		return adresa;
	}

	public void setAdresa(String adresa) {
		this.adresa = adresa;
	}

	public int getPib() {
		return pib;
	}

	public void setPib(int pib) {
		this.pib = pib;
	}

	public ArrayList<Zaposleni> getZaposleni() {
		return zaposleni;
	}

	public void setZaposleni(ArrayList<Zaposleni> zaposleni) {
		this.zaposleni = zaposleni;
	}

	public Restoran(String naziv, String adresa, int pib, ArrayList<Zaposleni> zaposleni) {
		super();
		this.naziv = naziv;
		this.adresa = adresa;
		this.pib = pib;
		this.zaposleni = zaposleni;
	}

	public void dodajZaposelnog(Zaposleni z) {
		zaposleni.add(z);
	}
	
	public void ukloniZaposlenog(Zaposleni z) {
		zaposleni.remove(z.getID());
	}
	
	public void nadjiZaposlenog(int id) {
		for(Zaposleni z:this.zaposleni) {
			if(z.getID() == id) {
				System.out.print(z.getIme());
			}
		}
	}
	public static void main(String[] args) {
		ArrayList<Zaposleni> zaposleni = new ArrayList<>();
		Restoran r1 = new Restoran("Astorija","City kvart",123,zaposleni);
		
		Konobari konobar1=new Konobari(1,"Marko","Markovic",40,40,0,15);
		Kuvari kuvar1 = new Kuvari(2,"Marko","Ivanovic",40,40,0,1500);
	}
}
