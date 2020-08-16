import biuoop.DrawSurface;

import java.awt.Color;

/**
 *This program create a Ball from a few values
 * Balls have size (radius), color, and location (a center Point).
 * Balls also know how to draw themselves on a DrawSurface.
 * Author : Idan givati Idangivati96@gmail.com 315902239
 */

public class Ball implements Sprite {
    private GameEnvironment gg;
    private Point center;
    private int r;
    private Color color;
    private Velocity v;
    // constructor

    /**
     * Adding ball to te game.
     * @param gameLevel the game.
     */
    public void addToGame(GameLevel gameLevel) {
        gameLevel.addSprite(this);
    }

    /**
     * Moving the ball one step. (per time circulation).
     */
    public void timePassed() {
        moveOneStep();
    }

    /**
     *This progrm construct a ball.
     * @param center the center of the ball.
     * @param r the size of the ball.
     * @param color the color of the ball.
     * @param game the game environment of the ball.
     */
    public Ball(Point center, int r, java.awt.Color color, GameEnvironment game) {
        this.center = new Point(center.getX(), center.getY());
        this.r = r;
        this.color = color;
        this.v = new Velocity(0, 0);
        this.gg = game;
    }
    /**
     *This progrm construct a ball.
     * @param x the x center of the ball.
     * @param y the y center of the ball.
     * @param r the size of the ball.
     * @param color the color of the ball.
     * @param game the game environment of the ball.
     */
    public Ball(double x, double y, int r, java.awt.Color color, GameEnvironment game) {
        this.center = new Point(x, y);
        this.r = r;
        this.color = color;
        this.v = new Velocity(0, 0);
        this.gg = game;
    }
    /**
     *This program receive a Point , radius and a color to create a ball with a color.
     * @param center , the center Point (x, y) of the ball.
     * @param r , the radius of the ball (also the size)
     * @param color , the color of the ball.
     */
    public Ball(Point center, int r, java.awt.Color color) {
        this.center = new Point(center.getX(), center.getY());
        this.r = r;
        this.color = color;
        this.v = new Velocity(0, 0);
    }

    /**
     *this program also create a ball but receive x and y to make the center point.
     * @param x , the x of the center ball Point.
     * @param y , the y of the center ball Point.
     * @param r , the radius of the ball.
     * @param color , the color of the ball.
     */
    public Ball(double x, double y, int r, java.awt.Color color) {
        this.center = new Point(x, y);
        this.r = r;
        this.color = color;
        this.v = new Velocity(0, 0);
    }

    /**
     *This program set the velocity of the ball.
     * @param newV , the values of the new velocity we want.
     */
    public void setVelocity(Velocity newV) {
        this.v = newV;
    }

    /**
     *This program set the velocity of the ball as well but this time we receive the values and not an object with
     * the values.
     * @param dx , the velocity of x.
     * @param dy , the velocity of y.
     */
    public void setVelocity(double dx, double dy) {
        this.v.setDx(dx);
        this.v.setDy(dy);
    }

    /**
     *This program check the velocity.
     * @return the velocity of the object (in our case its the velocity of the ball).
     */
    public Velocity getVelocity() {
        return this.v;
    }

    /**
     *This program receive a ball, width and height (of the screen). The program checks if its
     *touch the edges of the screen while moving or not. If not the ball will move one step.
     * If the ball do touch the screen, it will change its direction.
     * @param ball , the ball that we want to move.
     * @param width , the width of the screen.
     * @param height , the height of the screen.
     */
    public void moveOneStep(Ball ball, double width, double height) {
        double leftEdge = ball.center.getX() - ball.getSize();
        double rightEdge = ball.center.getX() + ball.getSize();
        double upEdge = ball.center.getY() - ball.getSize();
        double downEdge = ball.center.getY() + ball.getSize();
        boolean flag = true;
        //check if the ball reached the end of the screen ( left and right wall)
        if (leftEdge <= 0 || rightEdge >= width) {
            if (leftEdge <= 0) {
                if (ball.getVelocity().getDx() >= 0) {
                    flag = false;
                }
            }
            if (rightEdge >= width) {
                if (ball.getVelocity().getDx() <= 0) {
                    flag = false;
                }
            }
            if (flag) {
                //change the direction of the ball
                ball.setVelocity((-1) * ball.getVelocity().getDx(), ball.getVelocity().getDy());
            }
        }
        flag = true;
        //check if the ball reached the end of the screen ( up and down wall)
        if (upEdge <= 0 || downEdge >= height) {
            if (upEdge <= 0) {
                if (ball.getVelocity().getDy() >= 0) {
                    flag = false;
                }
            }
            if (downEdge >= height) {
                if (ball.getVelocity().getDy() <= 0) {
                    flag = false;
                }
            }
            if (flag) {
                //change the direction of the ball
                ball.setVelocity(ball.getVelocity().getDx(), (-1) * ball.getVelocity().getDy());
            }
        }
        this.center = this.getVelocity().applyToPoint(this.center);
    }

    /**
     * This program receive an area( x,y) a ball, width and height (of the screen). The program checks if its
     * touch the edges of the screen while moving or not. If not the ball will move one step.
     * If the ball do touch the screen, it will change its direction. This time the program checks the edges with
     * x and y as well.((x,y) is the top left of the screen and (width,height) is the bottom right).
     * @param x , the x of the starting Point of the screen(the top left of the screen).
     * @param y ,the y of the starting Point of the screen(the top left of the screen).
     * @param ball , the ball that we want to move.
     * @param width , the width of the screen.
     * @param height , the height of the screen.
     */
    public void moveOneStep(int x, int y, Ball ball, double width, double height) {
        double leftE = ball.center.getX() - ball.getSize();
        double rightE = ball.center.getX() + ball.getSize();
        double upE = ball.center.getY() - ball.getSize();
        double downE = ball.center.getY() + ball.getSize();
        boolean flag = true;
        //check if the ball reached the end of the screen ( left and right wall)
        if (leftE <= x || rightE >= width) {
            if (leftE <= x) {
                if (ball.getVelocity().getDx() >= 0) {
                    flag = false;
                }
            }
            if (rightE >= width) {
                if (ball.getVelocity().getDx() <= 0) {
                    flag = false;
                }
            }
            if (flag) {
                //change the direction of the ball
                ball.setVelocity((-1) * ball.getVelocity().getDx(), ball.getVelocity().getDy());
            }
        }
        flag = true;
        //check if the ball reached the end of the screen ( up and down wall)
        if (upE <= y || downE >= height) {
            if (upE <= y) {
                if (ball.getVelocity().getDy() >= 0) {
                    flag = false;
                }
            }
            if (downE >= height) {
                if (ball.getVelocity().getDy() <= 0) {
                    flag = false;
                }
            }
            if (flag) {
                //change the direction of the ball
                ball.setVelocity(ball.getVelocity().getDx(), (-1) * ball.getVelocity().getDy());
            }
        }
        this.center = this.getVelocity().applyToPoint(this.center);
    }
    // accessors

/*
            1) compute the ball trajectory (the trajectory is "how the ball will move
            without any obstacles" -- its a line starting at current location, and
            ending where the velocity will take the ball if no collisions will occur).

            2) Check (using the game environment) if moving on this trajectory will hit anything.

            2.1) If no, then move the ball to the end of the trajectory.

            2.2) Otherwise (there is a hit):
            2.2.2) move the ball to "almost" the hit point, but just slightly before it.
            2.2.3) notify the hit object (using its hit() method) that a collision occurred.
            2.2.4) update the velocity to the new velocity returned by the hit() method.
            */

    /**
     * We moving the ball one step according the the trajectory, the velocity, and the collision point we got
     * (if we got).
     */
    public void moveOneStep() {
        Line trajectory = new Line(this.center, this.getVelocity().applyToPoint(this.center));
        CollisionInfo info = this.gg.getClosestCollision(trajectory);
        if (info == null) {
            this.center = this.getVelocity().applyToPoint(this.center);
            return;
        } else {
            this.setVelocity(info.collisionObject().hit(this, info.collisionPoint(), this.getVelocity()));
        }
        this.center = this.getVelocity().applyToPoint(this.center);
    }
    /**
     *This program checks the value x of the center point of the ball.
     * @return the value x of the point.
     */
    public int getX() {
        return (int) this.center.getX();
    }

    /**
     *This program checks the value y of the center point of the ball.
     * @return the value y of the point.
     */
    public int getY() {
        return (int) this.center.getY();
    }

    /**
     *This program check the size of the ball by its radius.
     * @return the size of the ball(radius).
     */
    public int getSize() {
        return this.r;
    }

    /**
     *This program checks the color of the ball.
     * @return the color of the ball.
     */
    public java.awt.Color getColor() {
        return this.color;
    }

    /**
     * This program draw the ball on the given DrawSurface.
     * @param surface , the screen that we draw the ball on.
     */
    public void drawOn(DrawSurface surface) {
        surface.setColor(this.getColor());
        surface.fillCircle(this.getX(), this.getY(), this.getSize());
        surface.setColor(Color.black);
        surface.drawCircle(this.getX(), this.getY(), this.getSize());
    }

    /**
     * This program remove the ball form the game.
     * @param gameLevel the game we remove the ball from.
     */
    public void removeFromGame(GameLevel gameLevel) {
        gameLevel.removeSprite(this);
    }
}