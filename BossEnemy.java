package Projekat;

public class BossEnemy extends Enemy {

	public BossEnemy(int x, int y, int width, int height, String type, int damage, int health) {
		super(x, y, width, height, type, damage, health);
	}
	public String toString() {
		return "Enemy[" + this.type + "] @ " + "(" + this.getX() + "," + this.getY() + ")" + this.getWidth() + "x" + this.getHeight() + "DMG=" + this.damage*2 + "HP=" + (this.getHealth() - this.damage*2);
	}

}
