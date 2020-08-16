/**
 *
 */
public class CollisionInfo {
    private Collidable block;
    private Point collisionPoint;

    /**
     * Constructors.
     * @param block the block.
     * @param collisionPoint the collision point.
     */
    public CollisionInfo(Collidable block, Point collisionPoint) {
        this.block = block;
        this.collisionPoint = collisionPoint;
    }

    /**
     * This program returns the collision point.
     * @return the collision point with the object
     */
    public Point collisionPoint() {
        return this.collisionPoint;
    }

    /**
     * This program returns the object involved.
     * @return the collidable object
     */
    public Collidable collisionObject() {
        return this.block;
    }
}