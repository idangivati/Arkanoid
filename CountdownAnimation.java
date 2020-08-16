import biuoop.DrawSurface;
import biuoop.Sleeper;

import java.awt.Color;

/**
 * The CountdownAnimation will display the given gameScreen,
 * or numOfSeconds seconds, and on top of them it will show
 * a countdown from countFrom back to 1, where each number will
 * appear on the screen for (numOfSeconds / countFrom) seconds, before
 * it is replaced with the next one.
 */
public class CountdownAnimation implements Animation {
    private double numOfSeconds;
    private int countFrom;
    private SpriteCollection gameScreen;
    private int countTracker;
    /**
     * Constructor.
     * @param numOfSeconds the number of seconds.
     * @param countFrom where we want to count from.
     * @param gameScreen the screen the game runs on.
     */
    public CountdownAnimation(double numOfSeconds, int countFrom, SpriteCollection gameScreen) {
        this.numOfSeconds = numOfSeconds;
        this.countFrom = countFrom;
        this.gameScreen = gameScreen;
        this.countTracker = countFrom;
    }

    /**
     * A program that do one frame.
     * @param d the draw surface.
     */
    public void doOneFrame(DrawSurface d) {
        double time = this.numOfSeconds / this.countFrom;
        Sleeper sleeper = new Sleeper();
        this.gameScreen.drawAllOn(d);
        d.setColor(new Color(10, 120, 130));
        d.drawText(375, 275, Integer.toString(this.countTracker), 125);
        this.countTracker = this.countTracker - 1;
        sleeper.sleepFor((long) ((this.numOfSeconds / this.countFrom) * 1000));

    }

    /**
     * Checks if the animation suppose to run or stop.
     * @return false if keep run and true if need to stop.
     */
    public boolean shouldStop() {
        return this.countTracker <= -1;
    }
}