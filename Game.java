package projekat3;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;


public class Game {
	
    private final ArrayList<Enemy> enemies = new ArrayList<>();
    private final ArrayList<String> eventLog = new ArrayList<>();
    private final Player player;

    public Game(Player player) {
        if (player == null) {
            throw new IllegalArgumentException("Igrac ne smije biti null.");
        }
        this.player = player;
    }

    public Player getPlayer() {
        return player;
    }

    public ArrayList<Enemy> getEnemies() {
        return enemies;
    }

    public ArrayList<String> getEventLog() {
        return eventLog;
    }

    public void addEnemy(Enemy e) {
        if (e == null) {
            throw new IllegalArgumentException("Neprijatelj ne smije biti null.");
        }
        enemies.add(e);
        eventLog.add("ADD: " + e.getType());
    }

    public boolean checkCollision(Player p, Enemy e) {
        return p.intersects(e);
    }

    public void decreaseHealth(Player p, Enemy e) {
        int damage = e.getEffectiveDamage();
        int oldHealth = p.getHealth();
        int newHealth = Math.max(0, oldHealth - damage);
        p.setHealth(newHealth);
        eventLog.add("HIT: " + e.getType() + " nanio " + damage + " DMG -> HP " + oldHealth + " -> " + newHealth);
    }

    public ArrayList<Enemy> findByType(String type) {
        ArrayList<Enemy> result = new ArrayList<>();
        if (type == null) {
            return result;
        }
        String query = type.trim().toLowerCase();
        for (Enemy e : enemies) {
            if (e.getType().toLowerCase().contains(query)) {
                result.add(e);
            }
        }
        return result;
    }

    public ArrayList<Enemy> collidingWithPlayer() {
        ArrayList<Enemy> result = new ArrayList<>();
        for (Enemy e : enemies) {
            if (checkCollision(player, e)) {
                result.add(e);
            }
        }
        return result;
    }

    public void resolveCollisions() {
        for (Enemy e : enemies) {
            if (checkCollision(player, e)) {
                decreaseHealth(player, e);
            }
        }
    }

    public static ArrayList<Enemy> loadEnemiesFromFile(String path) {
        ArrayList<Enemy> loaded = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(path))) {
            String header = br.readLine();
            if (header == null) {
                throw new IllegalArgumentException("Fajl je prazan.");
            }

            String line;
            int lineNumber = 1;
            while ((line = br.readLine()) != null) {
                lineNumber++;
                if (line.trim().isEmpty()) {
                    continue;
                }
                String[] parts = line.split(",");
                if (parts.length < 8) {
                    throw new IllegalArgumentException("Neispravna linija " + lineNumber + ": " + line);
                }

                String type = parts[0].trim();
                String enemyClass = parts[1].trim().toLowerCase();

                int damage;
                int health;
                int x;
                int y;
                try {
                    damage = Integer.parseInt(parts[2].trim());
                    health = Integer.parseInt(parts[3].trim());
                    x = Integer.parseInt(parts[4].trim());
                    y = Integer.parseInt(parts[5].trim());
                } catch (NumberFormatException ex) {
                    throw new IllegalArgumentException("Neispravan broj u liniji " + lineNumber, ex);
                }

                String shape = parts[6].trim().toLowerCase();
                Collidable collider;
                try {
                    if ("square".equals(shape)) {
                        if (parts.length == 8) {
                            int size = Integer.parseInt(parts[7].trim());
                            collider = new SquareCollider(size);
                        } else if (parts.length == 9) {
                            int w = Integer.parseInt(parts[7].trim());
                            int h = Integer.parseInt(parts[8].trim());
                            if (w != h) {
                                throw new IllegalArgumentException("Kvadrat mora imati iste dimenzije u liniji " + lineNumber);
                            }
                            collider = new SquareCollider(w);
                        } else {
                            throw new IllegalArgumentException("Neispravne dimenzije kvadrata u liniji " + lineNumber);
                        }
                    } else if ("rectangle".equals(shape)) {
                        if (parts.length != 9) {
                            throw new IllegalArgumentException("Pravougaonik zahteva sirinu i visinu u liniji " + lineNumber);
                        }
                        int w = Integer.parseInt(parts[7].trim());
                        int h = Integer.parseInt(parts[8].trim());
                        collider = new RectangleCollider(w, h);
                    } else {
                        throw new IllegalArgumentException("Nepoznat oblik kolajdera '" + shape + "' u liniji " + lineNumber);
                    }
                } catch (NumberFormatException ex) {
                    throw new IllegalArgumentException("Neispravna dimenzija u liniji " + lineNumber, ex);
                }

                Enemy enemy;
                if ("melee".equals(enemyClass)) {
                    enemy = new MeleeEnemy(x, y, collider, type, damage, health);
                } else if ("boss".equals(enemyClass)) {
                    enemy = new BossEnemy(x, y, collider, type, damage, health);
                } else {
                    throw new IllegalArgumentException("Nepoznata klasa neprijatelja '" + enemyClass + "' u liniji " + lineNumber);
                }

                loaded.add(enemy);
            }
        } catch (IOException ex) {
            throw new IllegalArgumentException("Greska pri citanju fajla: " + path, ex);
        }
        return loaded;
    }

    public void saveToFile(String path) {
        ArrayList<Enemy> colliding = collidingWithPlayer();
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(path))) {
            bw.write("STATUS: " + player.toString());
            bw.newLine();
            bw.newLine();

            bw.write("NEPRIJATELJI U KOLIZIJI (" + colliding.size() + "):");
            bw.newLine();
            for (Enemy e : colliding) {
                bw.write(" - " + e.getType() + " (" + e.getClass().getSimpleName() + ")");
                bw.newLine();
            }
            bw.newLine();

            bw.write("LOG:");
            bw.newLine();
            for (String entry : eventLog) {
                bw.write(" - " + entry);
                bw.newLine();
            }
        } catch (IOException ex) {
            throw new IllegalArgumentException("Greska pri upisu u fajl: " + path, ex);
        }
    }
}
