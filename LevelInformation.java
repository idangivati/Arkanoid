import java.util.List;

/**
 * An interface to check the level information.
 */
public interface LevelInformation {
    /**
     * The number of balls.
     * @return the number of balls.
     */
    int numberOfBalls();
    /**
     * The initial velocity of each ball.
     * @return a list of velocities.
     */
    List<Velocity> initialBallVelocities();

    /**
     * Checks paddle Speed.
     * @return the paddle Speed.
     */
    int paddleSpeed();

    /**
     * Checks the paddle Width.
     * @return the paddle Width.
     */
    int paddleWidth();

    /**
     * Check the level name.
     * @return the level name.
     */
    String levelName();

    /**
     * The background of the level.
     * @return a sprite with the background of the level
     */
    Sprite getBackground();
    /**
     * The Blocks that make up this level, each block contains its size, color and location.
     * @return a list of blocks
     */
    List<Block> blocks();

    /**
     * Number of blocks that should be removed before the level is considered to be "cleared".
     * @return number of blocks that should be removed
     */
    int numberOfBlocksToRemove();
}
