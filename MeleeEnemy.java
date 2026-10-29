package Projekat;

public class MeleeEnemy extends Enemy {

	public MeleeEnemy(int x, int y, int width, int height, String type, int damage, int health) {
		super(x, y, width, height, type, damage, health);
	}
	public String toString() {
		return "Enemy[" + this.type + "] @ " + "(" + this.getX() + "," + this.getY() + ")" + this.getWidth() + "x" + this.getHeight() + "DMG=" + this.damage + "HP=" + (this.getHealth() - this.damage); 
	}

}
