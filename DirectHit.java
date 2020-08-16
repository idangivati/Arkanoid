import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

/**
 * The first level.
 */
public class DirectHit implements LevelInformation {
    private static int numberOfBalls = 1;
    private static int numberOfBlocksToRemove = 1;
    private static int paddleSpeed = 7;
    private static int paddleWidth = 80;
    private static Velocity ballVelocity = new Velocity(0, -5);
    private static String levelName = "Direct hit";
    private static Sprite getBackground = new Block(new Rectangle(new Point(0, 0), 800, 600),
            Color.black);
    private static double blocksWidth = 30;
    private static int blocksHeight = 30;

    /**
     * The number of balls in the level.
     * @return the number of balls.
     */
    public int numberOfBalls() {
        return numberOfBalls;
    }

    /**
     *The initial velocity of each ball.
     * @return a list of velocities.
     */
    public List<Velocity> initialBallVelocities() {
        List<Velocity> listOfVelocity = new ArrayList<>();
        listOfVelocity.add(ballVelocity);
        return listOfVelocity;
    }

    /**
     * The paddle speed.
     * @return the paddle speed.
     */
    public int paddleSpeed() {
        return paddleSpeed;
    }

    /**
     * The paddle width.
     * @return the paddle width.
     */
    public int paddleWidth() {
        return paddleWidth;
    }

    /**
     * The level name will be displayed at the top of the screen.
     * @return the level name.
     */
    public String levelName() {
        return levelName;
    }

    /**
     * Returns a sprite with the background of the level.
     * @return the background we run on.
     */
    public Sprite getBackground() {
        return getBackground;
    }

    /**
     * The Blocks that make up this level, each block contains its size, color and location.
     * @return the list of blocks.
     */
    public List<Block> blocks() {
        List<Block> blockList = new ArrayList<>();
        blockList.add(new Block(new Rectangle(new Point(385, 85), blocksWidth, blocksHeight), Color.red));
        return blockList;
    }

    /**
     * Number of blocks that should be removed
     * before the level is considered to be "cleared".
     * This number should be <= blocks.size();
     * @return the number of blocks to remove.
     */
    public int numberOfBlocksToRemove() {
        return numberOfBlocksToRemove;
    }
}
