package projekat3;

public class Player extends GameObject {
    private String name;
    private int health;

    public Player(int x, int y, Collidable collider, String name, int health) {
        super(x, y, collider);
        setName(name);
        setHealth(health);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException("Ime igraca ne smije biti prazno.");
        }
        String[] words = name.trim().split("\\s+");
        StringBuilder sb = new StringBuilder();
        for (String word : words) {
            if (!Character.isUpperCase(word.charAt(0))) {
                throw new IllegalArgumentException("Svaka rijec imena igraca mora poceti velikim slovom.");
            }
            sb.append(Character.toUpperCase(word.charAt(0)))
              .append(word.substring(1))
              .append(" ");
        }
        this.name = sb.toString().trim();
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        if (health < 0 || health > 100) {
            throw new IllegalArgumentException("Health igraca mora biti u opsegu [0, 100].");
        }
        this.health = health;
    }

    @Override
    public String getDisplayName() {
        return name;
    }

    @Override
    public String toString() {
        return "Player[" + name + "] @ (" + x + "," + y + ") HP=" + health;
    }
}

