import biuoop.DrawSurface;

import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

/**
 * This class create a block and gets implements for the block. This program also checks a hit with the block and more
 * functions.
 */
public class Block implements Collidable, Sprite, HitNotifier {
    private List<HitListener> hitListeners;
    private Rectangle block;
    private Color color;

    /**
     * Constructor.
     * @param rect the rectangle received.
     */
    public Block(Rectangle rect) {
        this.hitListeners = new ArrayList<>();
        this.block = rect;
        this.color = Color.BLUE;
    }

    /**
     * Constructors.
     * @param rect the rectangle received.
     * @param color the color received for the block.
     */
    public Block(Rectangle rect, Color color) {
        this.hitListeners = new ArrayList<>();
        this.color = color;
        this.block = rect;
    }

    /**
     * Add hl as a listener to hit events.
     * @param hl the hl we want to add
     */
    public void addHitListener(HitListener hl) {
        hitListeners.add(hl);
    }

    /**
     * Remove hl from the list of listeners to hit events.
     * @param hl the hl we want to remove.
     */
    public  void removeHitListener(HitListener hl) {
        hitListeners.remove(hl);
    }

    /**
     *This program adds the block to the game, by collidable object and a Sprite.
     * @param gg the game we want to add the block.
     */
    public void addToGame(GameLevel gg) {
        gg.addSprite(this);
        gg.addCollidable(this);
    }

    /**
     * This program do nothing for now.
     */
    public void timePassed() { }

    /**
     * returns the type of the object.
     * @return the type of the rectangle.
     */
    public Rectangle getCollisionRectangle() {
        return this.block;
    }

    /**
     * This class notify the hit to all listeners.
     * @param hitter the ball that's hit.
     */
    private void notifyHit(Ball hitter) {
        // Make a copy of the hitListeners before iterating over them.
        List<HitListener> listeners = new ArrayList<HitListener>(this.hitListeners);
        // Notify all listeners about a hit event:
        for (HitListener hl : listeners) {
            hl.hitEvent(this, hitter);
        }
    }

    /**
     * Blocks that are hit will be removed
     * from the game. Remember to remove this listener from the block.
     * that is being removed from the game.
     * @param beingHit the object that got hit.
     * @param hitter the ball that's doing the hit.
     */
    public void hitEvent(Block beingHit, Ball hitter) {

    }

    /**
     * This program receive a collide point and current velocity, and then calculates according to the hit point
     * the new velocity.
     * @param collisionPoint the collosion point with the block
     * @param currentVelocity the current velocity received
     * @param hitter The ball that hit the block.
     * @return the change of the velocity
     */
    public Velocity hit(Ball hitter, Point collisionPoint, Velocity currentVelocity) {
        this.notifyHit(hitter);
        Point upperLeft = new Point(this.block.getUpperLeft().getX(), this.block.getUpperLeft().getY());
        Point upperRight = new Point(upperLeft.getX() + this.block.getWidth(), upperLeft.getY());
        Point downLeft = new Point(upperLeft.getX(), upperLeft.getY() + this.block.getHeight());
        Point downRight = new Point(upperRight.getX(), upperRight.getY() + this.block.getHeight());
        if (collisionPoint.equals(downLeft) || collisionPoint.equals(downRight)
                || collisionPoint.equals(upperLeft) || collisionPoint.equals(upperRight)) {
            return new Velocity(currentVelocity.getDx() * -1, currentVelocity.getDy() * -1);
        } else {
            if (((int) collisionPoint.getY() >= (int) upperLeft.getY()
                    || (int) collisionPoint.getY() <= (int) downLeft.getY())) {
                if ((int) collisionPoint.getX() > (int) downLeft.getX()
                        && (int) collisionPoint.getX() < (int) upperRight.getX()) {
                    return new Velocity(currentVelocity.getDx(), currentVelocity.getDy() * -1);
                }
            }
            if ((int) collisionPoint.getX() >= (int) downLeft.getX()
                    || (int) collisionPoint.getX() <= (int) upperRight.getX()) {
                if ((int) collisionPoint.getY() > (int) upperLeft.getY()
                        && (int) collisionPoint.getY() < (int) downLeft.getY()) {
                    return new Velocity(currentVelocity.getDx() * -1, currentVelocity.getDy());
                }
            }
            return currentVelocity;
        }
    }

    /**
     * Draw the object on the draw surface.
     * @param surface the draw surface given.
     */
    public void drawOn(DrawSurface surface) {
        surface.setColor(this.color);
        surface.fillRectangle((int) this.block.getUpperLeft().getX(), (int) this.block.getUpperLeft().getY(),
                (int) this.block.getWidth(), (int) this.block.getHeight());
        surface.setColor(Color.BLACK);
        surface.drawRectangle((int) this.block.getUpperLeft().getX(), (int) this.block.getUpperLeft().getY(),
                (int) this.block.getWidth(), (int) this.block.getHeight());
    }

    /**
     * This program remove a block from the game.
     * @param gameLevel the game we want to remove the block from.
     */
    public void removeFromGame(GameLevel gameLevel) {
        gameLevel.removeSprite(this);
        gameLevel.removeCollidable(this);
    }
}
