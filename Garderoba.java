package nedelja6;

public class Garderoba extends Proizvod {

	private String materijalProizvodnje;
	private String sezona;

	public Garderoba(String opisProizvoda, String barkod, String zemljaProizvodnje, int godinaProizvodnje,
			int uvoznaCijena, String materijalProizvodnje, String sezona) {
		super(opisProizvoda, barkod, zemljaProizvodnje, godinaProizvodnje, uvoznaCijena);
		this.materijalProizvodnje = materijalProizvodnje;
		this.sezona = sezona;
	}
	public String getMaterijalProizvodnje() {
		return materijalProizvodnje;
	}
	public void setMaterijalProizvodnje(String materijalProizvodnje) {
		this.materijalProizvodnje = materijalProizvodnje;
	}
	public String getSezona() {
		return sezona;
	}
	public void setSezona(String sezona) {
		this.sezona = sezona;
	}
	
	public void uvecajCijenu() {
		this.setUvoznaCijena(getUvoznaCijena());
	}
	@Override
	public String toString() {
		return "Garderoba [materijalProizvodnje=" + materijalProizvodnje + ", sezona=" + sezona
				+ ", getOpisProizvoda()=" + getOpisProizvoda() + ", getBarkod()=" + getBarkod()
				+ ", getZemljaProizvodnje()=" + getZemljaProizvodnje() + ", getGodinaProizvodnje()="
				+ getGodinaProizvodnje() + ", getUvoznaCijena()=" + getUvoznaCijena() + "]";
	}


}
