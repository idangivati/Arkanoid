import biuoop.DrawSurface;
import biuoop.GUI;
import biuoop.Sleeper;

/**
 * This class runs the animation.
 */
public class AnimationRunner {
    private GUI gui;
    private int framesPerSecond;
    private static final int WIDTH = 800;
    private static final int HEIGHT = 600;
    private Sleeper sleeper;

    /**
     * Constructors.
     */
    public AnimationRunner() {
        this.gui = new GUI("Arkanoid", WIDTH, HEIGHT);
        this.framesPerSecond = 60;
        this.sleeper = new Sleeper();
    }

    /**
     * This program get us the gui.
     * @return the gui
     */
    public GUI getGui() {
        return this.gui;
    }

    /**
     * This program runs the animation.
     * @param animation the animation we want to run.
     */
    public void run(Animation animation) {
        int millisecondsPerFrame = 1000 / this.framesPerSecond;
        while (!animation.shouldStop()) {
            long startTime = System.currentTimeMillis(); // timing
            DrawSurface d = gui.getDrawSurface();
            animation.doOneFrame(d);
            gui.show(d);
            long usedTime = System.currentTimeMillis() - startTime;
            long milliSecondLeftToSleep = millisecondsPerFrame - usedTime;
            if (milliSecondLeftToSleep > 0) {
                this.sleeper.sleepFor(milliSecondLeftToSleep);
            }
        }
    }
}
