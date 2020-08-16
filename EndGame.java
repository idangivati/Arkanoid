import biuoop.DrawSurface;
import biuoop.KeyboardSensor;

/**
 * This program checks if the game ended.
 */
public class EndGame implements Animation {
    private boolean stop;
    private boolean nice;
    private KeyboardSensor keyboard;
    private int score;

    /**
     * This program pause the game if we will press the keyboard.
     * @param k the keyboard pressed.
     * @param score the score we save.
     * @param nice if we won or lost.
     */
    public EndGame(KeyboardSensor k, int score, boolean nice) {
        this.keyboard = k;
        this.stop = false;
        this.nice = nice;
        this.score = score;
    }

    /**
     * Do one frame and check if the user paused the game.
     * @param d the draw surface.
     */
    public void doOneFrame(DrawSurface d) {
        if (this.nice) {
            d.drawText(200, d.getHeight() / 2, "You Win! Your score is " + this.score, 32);
        } else {
            d.drawText(200, d.getHeight() / 2, "Game Over. Your score is " + this.score, 32);
        }
        if (this.keyboard.isPressed(KeyboardSensor.SPACE_KEY)) {
            this.stop = true;
        }
    }

    /**
     * Check if the frame should stop or not.
     * @return if the screen stopped or not.
     */
    public boolean shouldStop() {
        return this.stop;
    }
}
