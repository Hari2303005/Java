package projekat3;

public class Enemy extends GameObject implements Attacker {
    protected String type;
    protected int damage;
    protected int health;

    public Enemy(int x, int y, Collidable collider, String type, int damage, int health) {
        super(x, y, collider);
        setType(type);
        setDamage(damage);
        setHealth(health);
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        if (type == null || type.trim().isEmpty()) {
            throw new IllegalArgumentException("Tip neprijatelja ne smije biti prazan.");
        }
        this.type = type.trim();
    }

    @Override
    public int getDamage() {
        return damage;
    }

    @Override
    public int getEffectiveDamage() {
        return damage;
    }

    public void setDamage(int damage) {
        if (damage < 0) {
            throw new IllegalArgumentException("Damage ne moze biti negativan.");
        }
        this.damage = damage;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        if (health < 0) {
            throw new IllegalArgumentException("Health ne moze biti negativan.");
        }
        this.health = health;
    }

    @Override
    public String getDisplayName() {
        return type;
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + "[" + type + "] @ (" + x + "," + y + ") DMG=" + getEffectiveDamage() + " HP=" + health;
    }
}