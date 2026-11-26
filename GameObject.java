package projekat3;

public abstract class GameObject {
    protected int x;
    protected int y;
    protected Collidable collider;

    public GameObject(int x, int y, Collidable collider) {
        if (collider == null) {
            throw new IllegalArgumentException("Kolajder ne smije biti null.");
        }
        
        this.x = x;
        this.y = y;
        this.collider = collider;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public Collidable getCollider() {
        return collider;
    }

    public void setCollider(Collidable collider) {
        if (collider == null) {
            throw new IllegalArgumentException("Kolajder ne smije biti null.");
        }
        this.collider = collider;
    }

    public abstract String getDisplayName();

    public boolean intersects(GameObject other) {
        if (other == null || this.collider == null || other.collider == null) {
            return false;
        }
        return this.collider.intersects(other.collider, this.x, this.y, other.x, other.y);
    }

    
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
