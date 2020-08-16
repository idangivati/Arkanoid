import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

/**
 * The first level.
 */
public class WideEasy implements LevelInformation {
    private static int numberOfBalls = 10;
    private static int numberOfBlocksToRemove = 15;
    private static int paddleSpeed = 7;
    private static int paddleWidth = 640;
    private static Velocity ballVelocity = new Velocity(0, 0);
    private static String levelName = "Wide Easy";
    private static Sprite getBackground = new Block(new Rectangle(new Point(0, 0), 800, 600),
            Color.white);
    private static double blocksWidth = 51;
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
        for (int i = 0; i < numberOfBalls; i++) {
            ballVelocity = Velocity.fromAngleAndSpeed(290 + 15 * i, 3);
            listOfVelocity.add(ballVelocity);
        }
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
        Rectangle rect;
        for (int i = 0; i < this.numberOfBlocksToRemove(); i++) {
            rect = new Rectangle(new Point(20 + blocksWidth * i, 250), blocksWidth, blocksHeight);
            Block block = new Block(rect, (new Color(150, (i + 5) * 6, (i + 10) * 8)));
            blockList.add(block);
        }
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
