package projekat3;

public class SquareCollider implements Collidable {
	private final int size;

    public SquareCollider(int size) {
        if (size <= 0) {
            throw new IllegalArgumentException("Stranica kvadrata mora biti veca od 0.");
        }
        this.size = size;
    }

    public int getSize() {
        return size;
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
        return thisX < otherX + other.getWidth()
                && thisX + this.size > otherX
                && thisY < otherY + other.getHeight()
                && thisY + this.size > otherY;
    }

    @Override
    public boolean intersectsSquare(SquareCollider other, int thisX, int thisY, int otherX, int otherY) {
        return thisX < otherX + other.size
                && thisX + this.size > otherX
                && thisY < otherY + other.size
                && thisY + this.size > otherY;
    }

}
