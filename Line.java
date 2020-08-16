
import java.util.List;

/**
 *This program create a line with 2 points , checks the middle of the line , and if the line is intersecting
 * with other line, if it does the program also can calculate the intersect point.
 * Author : Idan givati Idangivati96@gmail.com 315902239
 */
public class Line {
    private Point p1;
    private Point p2;
    // constructors

    /**
     *This program receive 2 points and make a line of them.
     * @param start , the start of the line.
     * @param end the end of the line.
     */
    public Line(Point start, Point end) {
        this.p1 = new Point(start.getX(), start.getY());
        this.p2 = new Point(end.getX(), end.getY());
    }

    /**
     *This program receive 4 values the will make 2 points , and from those 2 points create a line.
     * @param x1 the x value of the first point
     * @param y1 the y value of the first point
     * @param x2 the x value of the second point
     * @param y2 the y value of the second point
     */
    public Line(double x1, double y1, double x2, double y2) {
        this.p1 = new Point(x1, y1);
        this.p2 = new Point(x2, y2);
    }

    /**
     * Checks the length of the line.
     * @return the length of the line.
     */
    public double length() {
        return this.p1.distance(this.p2);
    }

    /**
     *the program calculate the middle point of the line.
     * @return the middle point of the line
     */
    // Returns the middle point of the line
    public Point middle() {
        return new Point((this.p1.getX() + this.p2.getX()) / 2, (this.p1.getY() + this.p2.getY()) / 2);
    }

    /**
     *The program checks the start of the line.
     * @return the start point of the line
     */
    // Returns the start point of the line
    public Point start() {
        return this.p1;
    }

    /**
     *Checks the end point of the line.
     * @return the end point of the line.
     */
    public Point end() {
        return this.p2;
    }

    /**
     *The program returns if the integer is in the range.
     * @param x1 the first value of the range.
     * @param x2 the integer we want to check.
     * @param x3 the end value of the range.
     * @return if the integer is in the range.
     */

    public boolean inRange(double x1, double x2, double x3) {
        return (x1 <= x2 && x2 <= x3) || (x3 <= x2 && x2 <= x1);
    }

    /**
     *Checks which point is bigger(by x first and then if the x value is equal then by y).
     * @param one the first point
     * @param two the second point
     * @return the point that is bigger.
     */
    public Point bigger(Point one, Point two) {
        if (one.getX() > two.getX()) {
            return one;
        }
        if (one.getX() == two.getX()) {
            if (one.getY() > two.getY()) {
                return one;
            }
        }
        return two;
    }

    /**
     *The program receive a line checks if the line intersect with an other line.
     * @param other , the line that we check the intersect with.
     * @return true if the lines intersect, false otherwise.
     */
    // Returns true if the lines intersect, false otherwise
    public boolean isIntersecting(Line other) {
        if (this.equals(other)) {
            return false;
        }
        Point collide;
        //if there isn't an incline between the two points or the same incline.
        // we want to check if they collide in the one point or more , if they do collide in more than one
        // point they do not have an intersection point(cause they have infinite).
        if (((this.p1.getX() == this.p2.getX()) || (other.p1.getX() == other.p2.getX()))
                || (incline(this.p1, this.p2) == incline(other.p1, other.p2))) {
            //checks if the intersect point does appear on both lines.
            if ((this.p1.getX() == this.p2.getX()) || (other.p1.getX() == other.p2.getX())) {
                if ((this.p1.getX() == this.p2.getX())) {
                    double mo = incline(other.p1, other.p2);
                    collide = new Point(this.p1.getX(), mo * (this.p1.getX() - other.p1.getX()) + other.p1.getY());
                } else {
                    double mo = incline(this.p1, this.p2);
                    collide = new Point(other.p1.getX(), mo * (other.p1.getX() - this.p1.getX()) + this.p1.getY());
                }
                return inRange(other.p1.getX(), collide.getX(), other.p2.getX())
                        && inRange(other.p1.getY(), collide.getY(), other.p2.getY())
                        && inRange(this.p1.getX(), collide.getX(), this.p2.getX())
                        && inRange(this.p1.getY(), collide.getY(), this.p2.getY());
            }
            Point b1 = bigger(this.p1, this.p2);
            Point otherB = bigger(other.p1, other.p2);
            if (b1.equals(bigger(b1, otherB))) {
                if (b1.equals(this.p1)) {
                    return otherB.equals(this.p2);
                }
                return otherB.equals(this.p1);
            } else if (otherB.equals(other.p1)) {
                return b1.equals(other.p2);
            } else {
                return b1.equals(other.p1);
            }
        }
            //checks if the intersect point does appear on both lines.
            return inRange(other.p1.getX(), this.collidePoint(other).getX(), other.p2.getX())
                    && inRange(other.p1.getY(), this.collidePoint(other).getY(), other.p2.getY())
                    && inRange(this.p1.getX(), this.collidePoint(other).getX(), this.p2.getX())
                    && inRange(this.p1.getY(), this.collidePoint(other).getY(), this.p2.getY());
    }

    /**
     *This program receive 2 points and calculate the incline between them.
     * @param first , the first point.
     * @param second , the second point.
     * @return the incline between 2 points.
     */
    public double incline(Point first, Point second) {
        if (first.getX() == second.getX()) {
            return 0;
        }
        if (first.getX() > second.getX()) {
            return (first.getY() - second.getY()) / (first.getX() - second.getX());
        }
        return (second.getY() - first.getY()) / (second.getX() - first.getX());
    }

    /**
     * This program receive a line and calculate the collide of the two lines.
     * @param other , the other line we check the collide point with.
     * @return the collide point.
     */
    public Point collidePoint(Line other) {
        double m1 = incline(this.p1, this.p2);
        double m2 = incline(other.p1, other.p2);
        double collideX;
        double collideY;
        collideX = (m1 * this.p1.getX() - m2 * other.p1.getX() + other.p1.getY() - this.p1.getY()) / (m1 - m2);
        collideY = m1 * (collideX - this.p1.getX()) + this.p1.getY();
        if (m1 == 0) {
            collideY = this.p1.getY();
            collideX = (collideY - other.p1.getY() + m2 * other.p1.getX()) / m2;
        }
        if (m2 == 0) {
            collideY = other.p1.getY();
            collideX = (collideY - this.p1.getY() + m1 * this.p1.getX()) / m1;
        }
        return new Point(collideX, collideY);
    }

    /**
     * This program receive a line(other) and checks if it intersect with the another line.
     * (the line we done the function on).
     * @param other the other line we want to check the intersect point with.
     * @return the collide point if they do intersect and null if not.
     */
    // Returns the intersection point if the lines intersect,
    // and null otherwise.
    public Point intersectionWith(Line other) {
        if (isIntersecting(other)) {
            if (incline(this.p1, this.p2) == incline(other.p1, other.p2)) {
                Point b1 = bigger(this.p1, this.p2);
                Point otherB = bigger(other.p1, other.p2);
                if (b1.equals(bigger(b1, otherB))) {
                    if (b1.equals(this.p1)) {
                        return new Point(this.p2.getX(), this.p2.getY());
                    }
                    return new Point(this.p1.getX(), this.p1.getY());
                } else if (otherB.equals(other.p1)) {
                    return new Point(other.p2.getX(), other.p2.getY());
                } else {
                    return new Point(other.p1.getX(), other.p1.getY());
                }
            }
            if ((this.p1.getX() == this.p2.getX()) || (other.p1.getX() == other.p2.getX())) {
                Point collides;
                if ((this.p1.getX() == this.p2.getX())) {
                    double mo = incline(other.p1, other.p2);
                    collides = new Point(this.p1.getX(), mo * (this.p1.getX() - other.p1.getX()) + other.p1.getY());
                } else {
                    double mo = incline(this.p1, this.p2);
                    collides = new Point(other.p1.getX(), (mo * (other.p1.getX() - this.p1.getY()) + this.p1.getY()));
                }
                collides = new Point(collides.getX(), collides.getY());
                return collides;
            }
            return collidePoint(other);
        }
        return null;
    }

    // If this line does not intersect with the rectangle, return null.
    // Otherwise, return the closest intersection point to the
    // start of the line.

    /**
     * This program check the closest point of intersect between a rectangle and an object. Its go over a list of
     * Points and returns the closest one to the start.
     * @param rect the rectangle received for the check.
     * @return the closest point of intersect.
     */
    public Point closestIntersectionToStartOfLine(Rectangle rect) {
        List<Point> check = rect.intersectionPoints(this);
        if (check.isEmpty()) {
            return null;
        }
        double min = check.get(0).distance(this.start());
        int i = 0;
        for (Point p:check) {
            if (min > p.distance(this.start())) {
                min = p.distance(this.start());
                i = check.indexOf(p);
            }
        }
        //System.out.println("left");
        return check.get(i);
    }
    /**
     * This program receive a line(other) and checks if the line is the same of the other line.
     * @param other , the other line we receive and comparing to.
     * @return true if the are the same line, false if not.
     */
    // equals -- return true is the lines are equal, false otherwise
    public boolean equals(Line other) {
        return this.p1.equals(other.p1) && this.p2.equals(other.p2);
    }

}