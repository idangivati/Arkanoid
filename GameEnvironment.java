import java.util.ArrayList;
import java.util.List;

/**
 * This class creates a Game environment with a list of collidables.
 */
public class GameEnvironment {
    private List<Collidable> collidables;

    /**
     * Constructor.
     */
    public GameEnvironment() {
        collidables = new ArrayList<Collidable>();
    }
    // add the given collidable to the environment.

    /**
     * Adds c to the game environment.
     * @param c the collidable we want to add to our game environment.
     */
    public void addCollidable(Collidable c) {
        collidables.add(c);
    }
    // Assume an object moving from line.start() to line.end().
    // If this object will not collide with any of the collidables
    // in this collection, return null. Else, return the information
    // about the closest collision that is going to occur.

    /**
     * This program checks the closest collision point out of the collidables.
     * @param trajectory The line we checking the collision with.
     * @return the closest collision point, null if there is'nt any
     */
    public CollisionInfo getClosestCollision(Line trajectory) {
        Collidable save = null;
        Point temp = null;
        Point closest;
        double min = Double.POSITIVE_INFINITY;
        for (Collidable c : collidables) {
            closest = trajectory.closestIntersectionToStartOfLine(c.getCollisionRectangle());
            if (closest == null) {
                continue;
            }
            if (trajectory.start().distance(closest) < min) {
                min = trajectory.start().distance(closest);
                temp = closest;
                save = c;
            }
        }
        if (temp == null) {
            return null;
        }
        return new CollisionInfo(save, temp);
    }

    /**
     * Removing a collidable.
     * @param c the collidable we want to remove.
     */
    public void removeColliadble(Collidable c) {
        this.collidables.remove(c);
    }
}