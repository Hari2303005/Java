package nedelja6;

public class HemijskiProizvodi extends Proizvod {

	private float temperaturaSkladistenja;
	private boolean zapaljivo;
	public HemijskiProizvodi(String opisProizvoda, String barkod, String zemljaProizvodnje, int godinaProizvodnje,
			int uvoznaCijena, float temperaturaSkladistenja, boolean zapaljivo) {
		super(opisProizvoda, barkod, zemljaProizvodnje, godinaProizvodnje, uvoznaCijena);
		this.temperaturaSkladistenja = temperaturaSkladistenja;
		this.zapaljivo = zapaljivo;
	}
	public float getTemperaturaSkladistenja() {
		return temperaturaSkladistenja;
	}
	public void setTemperaturaSkladistenja(float temperaturaSkladistenja) {
		this.temperaturaSkladistenja = temperaturaSkladistenja;
	}
	public boolean isZapaljivo() {
		return zapaljivo;
	}
	public void setZapaljivo(boolean zapaljivo) {
		this.zapaljivo = zapaljivo;
	}
	
	public void izracunajCijenu() {
		if(this.zapaljivo) {
			this.setUvoznaCijena(getGodinaProizvodnje()*1.125);
		}
		else {
			this.setUvoznaCijena(this.getUvoznaCijena()*1.1);
		}
	}
	@Override
	public String toString() {
		return "HemijskiProizvodi [temperaturaSkladistenja=" + temperaturaSkladistenja + ", zapaljivo=" + zapaljivo
				+ ", getOpisProizvoda()=" + getOpisProizvoda() + ", getZemljaProizvodnje()=" + getZemljaProizvodnje()
				+ ", getGodinaProizvodnje()=" + getGodinaProizvodnje() + ", getUvoznaCijena()=" + getUvoznaCijena()
				+ "]";
	}
	
}
