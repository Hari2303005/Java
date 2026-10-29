package n7;

public class DostavaDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		VoziloAbs[] vozila = new VoziloAbs[3];
		
		vozila[0] = new Biciklo(321,20);
		vozila[1] = new Motor(543,60);
		vozila[2] = new Automobil(999,80);
		
	    double udaljenost = 10.0;
	    
	    for(VoziloAbs v : vozila) {
	    	v.info();
	    	
	    	if (v instanceof Ekonomican) {
	    		Ekonomican e = (Ekonomican)v;
	    		
	    		double ukupnaPotrosnja = e.potrosnjaPoKm()*udaljenost;
	    		System.out.println("ukupna potrosnja na: " + udaljenost + " kilometara je :" + ukupnaPotrosnja);
	    				
	    	}
	    }
	}

}
