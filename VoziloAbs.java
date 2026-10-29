package n7;

public abstract class VoziloAbs {
     protected int id;
     protected double maxBrzina;
     
     public VoziloAbs(int id, double maxBrzina) {
		super();
		this.id = id;
		this.maxBrzina = maxBrzina;
	}

	 public void info() {
    	 System.out.println("ID vozila je : " + id + " a njegova maksimalna brzina je " + maxBrzina);
     }
     
     public abstract double izracunajVrijemeDostave(double udaljenostKm);
     
     
}


