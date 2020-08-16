// Velocity specifies the change in position on the `x` and the `y` axes.

/**
 *This class create velocity from two integers , create them from and angle and speed as well, and apply velocity to.
 * a ball.
 */
public class Velocity {
    private double dx;
    private double dy;
    // constructor

    /**
     *The program receive 2 integers and create a velocity from them.
     * @param dx the x value of the velocity
     * @param dy the y value of the velocity
     */
    public Velocity(double dx, double dy) {
        this.dx = dx;
        this.dy = dy;
    }

    /**
     *This program calculate the velocity by receiving angle and speed and turn them into dx and dy.
     * @param angle the angle of the ball
     * @param speed the speed of the ball
     * @return the velocity of the angle and speed received.
     */
    public static Velocity fromAngleAndSpeed(double angle, double speed) {
        double dx = speed * Math.sin((Math.PI / 180) * angle);
        double dy = speed * -1 * Math.cos((Math.PI / 180) * angle);
        return new Velocity(dx, dy);
    }

    /**
     *checks the value dy of the velocity.
     * @return the dy of the velocity
     */
    public double getDy() {
        return this.dy;
    }

    /**
     *Setting the dy of our velocity to a new one that we received.
     * @param newDy the dy we want to put into the velocity.
     */
    public void setDy(double newDy) {
        this.dy = newDy;
    }

    /**
     *checks the value dx of the velocity.
     * @return the value dx of the velocity.
     */
    public double getDx() {
        return this.dx;
    }

    /**
     *Setting the dx of our velocity to a new one that we received.
     * @param newDx the dx we want to put into the velocity.
     */
    public void setDx(double newDx) {
        this.dx = newDx;
    }

    /**
     *Take a point with position (x,y) and return a new point with position (x+dx, y+dy).
     * @param p the point we receiving.
     * @return the new point with the position of (x+dx, y+dy).
     */
    // Take a point with position (x,y) and return a new point
    // with position (x+dx, y+dy)
    public Point applyToPoint(Point p) {
        return new Point(p.getX() + this.dx, p.getY() + this.dy);
    }
}
