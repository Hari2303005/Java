package nedeljaa6;

public class Kuvari extends Zaposleni {
	
   public Kuvari(int iD, String ime, String prezime, int plataPoSatu, int ukupanBrojSati) {
		super(iD, ime, prezime, plataPoSatu, ukupanBrojSati);
		// TODO Auto-generated constructor stub
	}

   public void plata(){
	   this.setPlata(1500 + 4*getUkupanBrojSati()*getPlataPoSatu());
	   
   }
}
