package projekat3;

public interface Collidable {
	 boolean intersects(Collidable other, int thisX, int thisY, int otherX, int otherY);
	    boolean intersectsRectangle(RectangleCollider other, int thisX, int thisY, int otherX, int otherY);
	    boolean intersectsSquare(SquareCollider other, int thisX, int thisY, int otherX, int otherY);
}
