package Projekat;

import java.util.ArrayList;

public class Game {

	public void decreaseHealth(Player p, Enemy e) {
	    int damage = e.getDamage();
	    if(e instanceof BossEnemy) {
	    	damage*=2;
	    }
	    p.setHealth(p.getHealth()-damage);
	    
	    if(p.getHealth()<0) {
	    	p.setHealth(0);
	    	System.out.print("Health ne moze biti ispod 0");
	    }
	}

	public void findByType(String query, Enemy[] enemies) {
		for(Enemy e : enemies) {
			if(e.getType().toLowerCase().contains(query.toLowerCase())) {
				System.out.print(e.getType());
				}
		}
	}
	public static void main(String[] args) {
		Player player1 = new Player(5,10,15,20,"Ben Ten",200);
		
		
		Enemy[] enemies = new Enemy[3];
		enemies[0] = new Enemy(100, 200, 50, 50, "Zombie", 10, 100);
        enemies[1] = new Enemy(300, 150, 40, 40, "Goblin", 15, 80);
        enemies[2] = new Enemy(500, 250, 60, 60, "Giant", 25, 200);
        
      
	}

}
