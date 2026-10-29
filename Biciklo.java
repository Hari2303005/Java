package n7;

 class Biciklo extends VoziloAbs implements Ekonomican {

	 public double potrosnjaPoKm() {
		 return 0;
	 }

	 public Biciklo(int id, double maxBrzina) {
		super(id, 20);
	 }
	 
     public double izracunajVrijemeDostave(double udaljenostKm) {
    	 return udaljenostKm/maxBrzina;
     }
}
