import biuoop.DrawSurface;
import biuoop.KeyboardSensor;

import java.awt.Color;

/**
 * This Program create a moving paddle, add it to the game as a collidable and sprite.
 */
public class Paddle implements Sprite, Collidable {
    private biuoop.KeyboardSensor keyboard;
    private Rectangle rect;
    private int pSpeed;

    /**
     * Constructors.
     * @param rect the shape of the paddle we want. rectangle.
     * @param keyboard the moving sensor we want.
     * @param pSpeed the speed of the paddle.
     */
    public Paddle(Rectangle rect, biuoop.KeyboardSensor keyboard, int pSpeed) {
        this.keyboard = keyboard;
        this.rect = rect;
        this.pSpeed = pSpeed;
    }

    /**
     * Moving the paddle left.
     */
    public void moveLeft() {
        if (rect.getUpperLeft().getX() >= 20 + this.pSpeed) {
            rect.getUpperLeft().setX(rect.getUpperLeft().getX() - this.pSpeed);
        }
    }

    /**
     * Moving the paddle right.
     */
    public void moveRight() {
        // x is a number that we can change to move the paddle right or left with some bigger steps
        // if we change the x value here we will change it at the moveLeft function as well.
        if (rect.getUpperLeft().getX() + rect.getWidth() <= 780 - this.pSpeed) {
            rect.getUpperLeft().setX(rect.getUpperLeft().getX() + this.pSpeed);
        }
    }

    /**
     * Checks which move do we want to do.
     */
    public void timePassed() {
        if (this.keyboard.isPressed(KeyboardSensor.LEFT_KEY)) {
            moveLeft();
        }
        if (this.keyboard.isPressed(KeyboardSensor.RIGHT_KEY)) {
            moveRight();
        }
    }
    /**
     * This program draw the paddle.
     * @param d the draw surface.
     */
    public void drawOn(DrawSurface d) {
        d.setColor(new Color(190, 10, 180));
        d.fillRectangle((int) this.rect.getUpperLeft().getX(), (int) this.rect.getUpperLeft().getY(),
                (int) this.rect.getWidth(), (int) this.rect.getHeight());
    }

    // Collidable

    /**
     * This program checks the type of paddle.
     * @return the type of the paddle (rectangle in this case).
     */
    public Rectangle getCollisionRectangle() {
        return this.rect;
    }

    /**
     *The program receive a collision point and a velocity, checks where is the collision point and change
     * the velocity according to it.
     * @param collisionPoint the collision point with the paddle.
     * @param currentVelocity the velocity of the object impacting the paddle.
     * @param hitter The ball that hit the block.
     * @return the change of velocity, the new velocity.
     */
    public Velocity hit(Ball hitter, Point collisionPoint, Velocity currentVelocity) {
        double speed = Math.sqrt(Math.pow(currentVelocity.getDx(), 2) + Math.pow(currentVelocity.getDy(), 2));
        double paddleStart1 = this.rect.getUpperLeft().getX();
        double paddleStart2 = paddleStart1 + this.rect.getWidth() / 5;
        double paddleStart3 = paddleStart1 + this.rect.getWidth() / 2.5;
        double paddleStart4 = paddleStart1 + this.rect.getWidth() / (5.0 / 3.0);
        double paddleStart5 = paddleStart1 + this.rect.getWidth() / (5.0 / 4.0);
        if (collisionPoint.getY() > this.rect.getUpperLeft().getY()) {
            return new Velocity(currentVelocity.getDx() * -1, currentVelocity.getDy());
        }
        if (inRange(paddleStart1, collisionPoint.getX(), paddleStart2)) {
            return Velocity.fromAngleAndSpeed(300, speed);
        }
        if (inRange(paddleStart2, collisionPoint.getX(), paddleStart3)) {
            return Velocity.fromAngleAndSpeed(330, speed);
        }
        if (inRange(paddleStart3, collisionPoint.getX(), paddleStart4)) {
            return new Velocity(currentVelocity.getDx(), currentVelocity.getDy() * -1);
        }
        if (inRange(paddleStart4, collisionPoint.getX(), paddleStart5)) {
            return Velocity.fromAngleAndSpeed(30, speed);
        }
        if (inRange(paddleStart5, collisionPoint.getX(), paddleStart5 + this.rect.getWidth() / 5)) {
            return Velocity.fromAngleAndSpeed(60, speed);
        }
        return currentVelocity;
    }

    /**
     * This program checks if the value is between 2 others.
     * @param x1 the first x range.
     * @param x2 the x we want to check
     * @param x3 the last x range.
     * @return if x2 is in the range.
     */
    public boolean inRange(double x1, double x2, double x3) {
        return (x1 <= x2 && x2 <= x3) || (x3 <= x2 && x2 <= x1);
    }

    /**
     * This program adds the paddle to the game.
     * @param g the game object
     */
    public void addToGame(GameLevel g) {
        g.addSprite(this);
        g.addCollidable(this);
    }
}