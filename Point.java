/**
 *This class creates a point , calculating the distance and check if its equal to an other point.
 * Author : Idan givati Idangivati96@gmail.com 315902239
 */
public class Point {
    private double x;
    private double y;

    /**
     * This program receive x and y and put them into the point value.
     * @param x , the x value of the point.
     * @param y , the y value of the point.
     */
    public Point(double x, double y) {
        this.x = x;
        this.y = y;
    }

    /**
     * The receive a point and checks the distance between the two points.
     * @param other , the other point we want to check the distance between.
     * @return the distance between the points.
     */
    // distance -- return the distance of this point to the other point
    public double distance(Point other) {
       return Math.sqrt((this.x - other.x) * (this.x - other.x) + (this.y - other.y) * (this.y - other.y));
    }

    /**
     * The program receive a point and checks if it equal to another point.
     * @param other , the other point we comparing to.
     * @return true if the points are the same, false if not.
     */
    // equals -- return true is the points are equal, false otherwise
    public boolean equals(Point other) {
        return (this.x == other.x) && (this.y == other.y);
    }

    /**
     * Checks the value x of the points.
     * @return the value x of the point.
     */
    // Return the x and y values of this point
    public double getX() {
        return this.x;
    }

    /**
     * Checks the value y of the point.
     * @return the value y of the point.
     */
    public double getY() {
        return this.y;
    }

    /**
     * This program changes the x value of the point.
     * @param newX the new x value of the point.
     */
    public void setX(double newX) {
        this.x = newX;
    }

    /**
     * This program changes the y value of the point.
     * @param newY the new y value of the point.
     */
    public void setY(double newY) {
        this.y = newY;
    }
}