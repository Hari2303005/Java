package Projekat;

public class Player extends GameObject {

	private String name;
	private int health;
	public Player(int x, int y, int width, int height, String name, int health) {
		super(x, y, width, height);
		this.name = name;
		this.health = health;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		if(name.isEmpty() || name == null) {
			System.out.print("Ime igraca ne smije biti prazno");
		}
		else {
			 name = name.trim().replaceAll("\\s+", " ");
			 String[] rijeci = name.split(" ");
			 String ime = "";
			 for(String rijec : rijeci) {
				 ime+=rijec.substring(0,1).toUpperCase() + rijec.substring(1).toLowerCase() + " ";
			 }
			 this.name=ime.trim();
		}
	}
	public int getHealth() {
		return health;
	}
	public void setHealth(int health) {
		if (health >= 0 && health <= 100) {
	        this.health = health;
	    }
		else {
			System.out.print("Health mora biti izmedju 0 i 100");
		}
	}
	
	public String toString() {
		return "Player[" + this.name + "] @ " + "(" + this.getX() + "," + this.getY() + ")" + this.getWidth() + "x" + this.getHeight() + "HP=" + this.getHealth() ;
	}
}
