package n7;

public class Automobil extends VoziloAbs {

	public Automobil(int id, double maxBrzina) {
		super(id, maxBrzina);
		// TODO Auto-generated constructor stub
	}

	@Override
	public double izracunajVrijemeDostave(double udaljenostKm) {
		// TODO Auto-generated method stub
		return udaljenostKm/maxBrzina;
	}

}
