package projekat3;

public class BossEnemy extends Enemy {
    public BossEnemy(int x, int y, Collidable collider, String type, int damage, int health) {
        super(x, y, collider, type, damage, health);
    }

    @Override
    public int getEffectiveDamage() {
        return damage * 2;
    }

    @Override
    public String toString() {
        return "BossEnemy[" + type + "] @ (" + x + "," + y + ") DMG=" + damage + "x2 HP=" + health;
    }
}
