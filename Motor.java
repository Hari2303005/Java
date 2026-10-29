package n7;

public class Motor extends VoziloAbs implements Ekonomican {

	public Motor(int id, double maxBrzina) {
		super(id, maxBrzina);
		// TODO Auto-generated constructor stub
	}

	@Override
	public double izracunajVrijemeDostave(double udaljenostKm) {
		// TODO Auto-generated method stub
		return udaljenostKm/maxBrzina;
	}
	
	public double potrosnjaPoKm() {
		return 0.03;
	}

}
