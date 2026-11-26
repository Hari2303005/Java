package projekat3;

public class RectangleCollider implements Collidable {
	private final int width;
	private final int height;

	    public RectangleCollider(int width, int height) {
	        if (width <= 0 || height <= 0) {
	            throw new IllegalArgumentException("Sirina i visina pravougaonika moraju biti vece od 0.");
	        }
	        this.width = width;
	        this.height = height;
	    }

	    public int getWidth() {
	        return width;
	    }

	    public int getHeight() {
	        return height;
	    }

	    @Override
	    public boolean intersects(Collidable other, int thisX, int thisY, int otherX, int otherY) {
	        if (other == null) {
	            return false;
	        }
	        if (other instanceof RectangleCollider rect) {
	            return intersectsRectangle(rect, thisX, thisY, otherX, otherY);
	        }
	        if (other instanceof SquareCollider sq) {
	            return intersectsSquare(sq, thisX, thisY, otherX, otherY);
	        }
	        return false;
	    }

	    @Override
	    public boolean intersectsRectangle(RectangleCollider other, int thisX, int thisY, int otherX, int otherY) {
	        return thisX < otherX + other.width
	                && thisX + this.width > otherX
	                && thisY < otherY + other.height
	                && thisY + this.height > otherY;
	    }

	    @Override
	    public boolean intersectsSquare(SquareCollider other, int thisX, int thisY, int otherX, int otherY) {
	        return thisX < otherX + other.getSize()
	                && thisX + this.width > otherX
	                && thisY < otherY + other.getSize()
	                && thisY + this.height > otherY;
	    }
}
