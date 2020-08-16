/**
 * An interface of a listener, that's listen to a hit bewtween a block and a ball.
 */
public interface HitListener {
    /**
     * This method is called whenever the beingHit object is hit.
     * The hitter parameter is the Ball that's doing the hitting
     * @param beingHit the object that got hit.
     * @param hitter the ball that's doing the hit.
     */
    void hitEvent(Block beingHit, Ball hitter);
}
