package nedeljaa6;

public class Konobari extends Zaposleni {
	
    public Konobari(int iD, String ime, String prezime, int plataPoSatu, int ukupanBrojSati) {
		super(iD, ime, prezime, plataPoSatu, ukupanBrojSati);
		// TODO Auto-generated constructor stub
	}
	private int prekovremeni;
	public void plata() {
		this.setPlata(getPlataPoSatu()*this.getUkupanBrojSati() + prekovremeni*1.2);
		
		
	}
}
