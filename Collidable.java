/**
 * This is an interface of Collidable. In this interface we check which type of collision object we have
 * and the change of velocity according to the impact.
 */
public interface Collidable {

    /**
     * The type of the object.
     * @return the "collision shape" of the object.
     */
    Rectangle getCollisionRectangle();

    // Notify the object that we collided with it at collisionPoint with
    // a given velocity.
    // The return is the new velocity expected after the hit (based on
    // the force the object inflicted on us).

    /**
     * This program receive a collision point and the current velocity of the object.
     * It change the velocity according to the collision point.
     * @param collisionPoint the collision point.
     * @param currentVelocity the current velocity of the object.
     * @param hitter The ball that hit the block.
     * @return the new velocity expected after the hit.
     */
    Velocity hit(Ball hitter, Point collisionPoint, Velocity currentVelocity);
}
