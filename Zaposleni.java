package nedeljaa6;

public class Zaposleni {

	private int ID;
	private String Ime;
	private String Prezime;
	protected int plataPoSatu;
	protected int ukupanBrojSati;
	protected double plata;
	public int getID() {
		return ID;
	}
	public void setID(int iD) {
		ID = iD;
	}
	public String getIme() {
		return Ime;
	}
	public void setIme(String ime) {
		Ime = ime;
	}
	public String getPrezime() {
		return Prezime;
	}
	public void setPrezime(String prezime) {
		Prezime = prezime;
	}
	public int getPlataPoSatu() {
		return plataPoSatu;
	}
	public void setPlataPoSatu(int plataPoSatu) {
		this.plataPoSatu = plataPoSatu;
	}
	public int getUkupanBrojSati() {
		return ukupanBrojSati;
	}
	public void setUkupanBrojSati(int ukupanBrojSati) {
		this.ukupanBrojSati = ukupanBrojSati;
	}
	public Zaposleni(int iD, String ime, String prezime, int plataPoSatu, int ukupanBrojSati) {
		super();
		ID = iD;
		Ime = ime;
		Prezime = prezime;
		this.plataPoSatu = plataPoSatu;
		this.ukupanBrojSati = ukupanBrojSati;
	}
	public double getPlata() {
		return plata;
	}
	public void setPlata(double plata) {
		this.plata = plata;
	}
}
