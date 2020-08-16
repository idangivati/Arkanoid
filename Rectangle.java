import java.util.ArrayList;
import java.util.List;

/**
 * This program create a rectangle from a starting point (upper left), width and height. In addition this
 * program makes a list of collide points between a given line and the rectangle.
 */
public class Rectangle {
    private Point upperLeft;
    private double width;
    private double height;

    /**
     * This program receives a point, and 2 integers. After that it converts them into an upper left point
     * of the rectangle, the width of the rectangle and the height of the rectangle.
     * @param upperLeft the upper left point of the rectangle.
     * @param width the width of the rectangle.
     * @param height the height of the rectangle.
     */
    public Rectangle(Point upperLeft, double width, double height) {
        this.upperLeft = upperLeft;
        this.height = height;
        this.width = width;
    }

    /**
     * This program receive a line, checks where(and if) the line collide with rectangle, makes an array of the
     * collide point and returns the array.
     * @param line the line given to check the collide points with the rectangle.
     * @return the array of the collide points.
     */
    public java.util.List<Point> intersectionPoints(Line line) {
        List<Point> intersects = new ArrayList<>();
        // making 2 points the will help us to make the lines of the rectangle
        Point upLeft = new Point(this.upperLeft.getX(), this.upperLeft.getY());
        Point upperRight = new Point(upLeft.getX() + this.getWidth(), upLeft.getY());
        Point downLeft = new Point(upLeft.getX(), upLeft.getY() + this.getHeight());
        Point downRight = new Point(upperRight.getX(), upperRight.getY() + this.getHeight());
        Line upperLine = new Line(upLeft, upperRight);
        Line rightLine = new Line(upperRight, downRight);
        Line leftLine = new Line(upLeft, downLeft);
        Line bottomLine = new Line(downLeft, downRight);
        // checking if collide and put the collide point into the array.
        if (upperLine.isIntersecting(line)) {
            intersects.add(upperLine.intersectionWith(line));
        }
        if (bottomLine.isIntersecting(line)) {
            intersects.add(bottomLine.intersectionWith(line));
        }
        if (leftLine.isIntersecting(line)) {
            intersects.add(leftLine.intersectionWith(line));
        }
        if (rightLine.isIntersecting(line)) {
            intersects.add(rightLine.intersectionWith(line));
        }
        return intersects;
    }

    /**
     * This function returning the width of the rectangle.
     * @return the width of the rectangle.
     */
    public double getWidth() {
        return this.width;
    }

    /**
     * This function returning the height of the rectangle.
     * @return the height of the rectangle.
     */
    public double getHeight() {
        return this.height;
    }

    /**
     * This function returning the starting point (upper left point) of the rectangle.
     * @return the upper left point of the rectangle.
     */
    public Point getUpperLeft() {
        return this.upperLeft;
    }
}