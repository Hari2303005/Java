package nedelja6;

public class Proizvod {

	public String getOpisProizvoda() {
		return opisProizvoda;
	}
	public void setOpisProizvoda(String opisProizvoda) {
		this.opisProizvoda = opisProizvoda;
	}
	public String getBarkod() {
		return barkod;
	}
	public void setBarkod(String barkod) {
		this.barkod = barkod;
	}
	public String getZemljaProizvodnje() {
		return zemljaProizvodnje;
	}
	public Proizvod(String opisProizvoda, String barkod, String zemljaProizvodnje, int godinaProizvodnje,
			int uvoznaCijena) {
		
		this.opisProizvoda = opisProizvoda;
		this.barkod = barkod;
		this.zemljaProizvodnje = zemljaProizvodnje;
		this.godinaProizvodnje = godinaProizvodnje;
		this.uvoznaCijena = uvoznaCijena;
	}

	public void setZemljaProizvodnje(String zemljaProizvodnje) {
		this.zemljaProizvodnje = zemljaProizvodnje;
	}
	public int getGodinaProizvodnje() {
		return godinaProizvodnje;
	}
	public void setGodinaProizvodnje(int godinaProizvodnje) {
		this.godinaProizvodnje = godinaProizvodnje;
	}
	public double getUvoznaCijena() {
		return uvoznaCijena;
	}
	public void setUvoznaCijena(double uvoznaCijena) {
		this.uvoznaCijena = uvoznaCijena;
	}
	private String opisProizvoda;
	private String barkod;
	private String zemljaProizvodnje;
	private int godinaProizvodnje;
	protected double uvoznaCijena;
	public static void main(String[] args) {
		
	}

}
