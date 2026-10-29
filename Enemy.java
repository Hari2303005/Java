package Projekat;

public class Enemy extends GameObject {

	protected String type;
	protected int damage;
	private int health;
	public Enemy(int x, int y, int width, int height, String type, int damage, int health) {
		super(x, y, width, height);
		this.type = type;
		this.damage = damage;
		this.health = health;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		if(type==null||type.isEmpty()) {
			System.out.print("Tip ne smije biti prazan");
		}
		else {
			 type = type.trim().replaceAll("\\s+", " ");
			 String[] rijeci = type.split(" ");
			 String tip = "";
			 for(String rijec : rijeci) {
				 tip+=rijec.substring(0,1).toUpperCase() + rijec.substring(1).toLowerCase() + " ";
			 }
			 this.type=tip.trim();
		}
	}
	public int getDamage() {
		return damage;
	}
	public void setDamage(int damage) {
		if (damage >= 0 && damage <= 100) {
	        this.damage = damage;
	    }
		else {
			System.out.print("Damage mora biti izmedju 0 i 100");
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
		return "Enemy[" + this.type + "] @ " + "(" + this.getX() + "," + this.getY() + ")" + this.getWidth() + "x" + this.getHeight() + "DMG=" + this.damage + "HP=" + this.getHealth() ;
	}
	
	
}
