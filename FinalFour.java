import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

/**
 * The first level.
 */
public class FinalFour implements LevelInformation {
    private static int numberOfBalls = 3;
    private static int numberOfBlocksToRemove = 105;
    private static int paddleSpeed = 7;
    private static int paddleWidth = 100;
    private static Velocity ballVelocity = new Velocity(0, 0);
    private static String levelName = "Final Four";
    private static Sprite getBackground = new Block(new Rectangle(new Point(0, 0), 800, 600),
            new Color(0, 215, 215));
    private static double blocksWidth = 51;
    private static double blocksHeight = 20;

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
            ballVelocity = Velocity.fromAngleAndSpeed(315 + 45 * i, 4);
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
     * @return the list of blocks.
     */
    public Sprite getBackground() {
        return getBackground;
    }

    /**
     * The Blocks that make up this level, each block contains its size, color and location.
     * @return the background we run on.
     */
    public List<Block> blocks() {
        List<Block> blockList = new ArrayList<>();
        Rectangle rect;
        for (int i = 0; i < 7; i++) {
            for (int j = 0; j < 15; j++) {
                rect = new Rectangle(new Point(j * blocksWidth + 20, i * blocksHeight + 100),
                        blocksWidth, blocksHeight);
                Block block = new Block(rect, (new Color((i + 10) * 7, (i + 20) * 5, (i + 10) * 7)));
                blockList.add(block);
            }
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
