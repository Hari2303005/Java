package nedelja6;
import java.time.LocalDate;
public class Hrana extends Proizvod {
    
	private int brojKalorija;
    private LocalDate datum;
    private LocalDate rokUpotrebe;
	public int getBrojKalorija() {
		return brojKalorija;
	}
	public void setBrojKalorija(int brojKalorija) {
		this.brojKalorija = brojKalorija;
	}
	public LocalDate getDatum() {
		return datum;
	}
	public void setDatum(LocalDate datum) {
		this.datum = datum;
	}
	public LocalDate getRokUpotrebe() {
		return rokUpotrebe;
	}
	public void setRokUpotrebe(LocalDate rokUpotrebe) {
		this.rokUpotrebe = rokUpotrebe;
	}
	public Hrana(String opisProizvoda, String barkod, String zemljaProizvodnje, int godinaProizvodnje, int uvoznaCijena,
			int brojKalorija, LocalDate datum, LocalDate rokUpotrebe) {
		super(opisProizvoda, barkod, zemljaProizvodnje, godinaProizvodnje, uvoznaCijena);
		this.brojKalorija = brojKalorija;
		this.datum = datum;
		this.rokUpotrebe = rokUpotrebe;
	}
	public void izracunajCijenu() {
    	if(rokUpotrebe.isBefore(LocalDate.now().plusMonths(6))) {
    		this.setUvoznaCijena(getUvoznaCijena()*1.1);
    	}
    }
	@Override
	public String toString() {
		return "Hrana [brojKalorija=" + brojKalorija + ", datum=" + datum + ", rokUpotrebe=" + rokUpotrebe
				+ ", getOpisProizvoda()=" + getOpisProizvoda() + ", getBarkod()=" + getBarkod()
				+ ", getZemljaProizvodnje()=" + getZemljaProizvodnje() + ", getGodinaProizvodnje()="
				+ getGodinaProizvodnje() + ", getUvoznaCijena()=" + getUvoznaCijena() + "]";
	}
    
    
    
    
}
