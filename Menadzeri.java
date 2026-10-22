package nedeljaa6;

public class Menadzeri extends Zaposleni {
	
public Menadzeri(int iD, String ime, String prezime, int plataPoSatu, int ukupanBrojSati) {
		super(iD, ime, prezime, plataPoSatu, ukupanBrojSati);
		// TODO Auto-generated constructor stub
	}

private int bonus;

public void plata() {
	this.setPlata(1300 + 4*getUkupanBrojSati()*getPlataPoSatu() + bonus);
}
}
