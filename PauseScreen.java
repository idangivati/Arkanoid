import biuoop.DrawSurface;
import biuoop.KeyboardSensor;

/**
 *
 */
public class PauseScreen implements Animation {
    private KeyboardSensor keyboard;
    private boolean stop;

    /**
     * This program pause the game if we will press the keyboard.
     * @param k the keyboard pressed.
     */
    public PauseScreen(KeyboardSensor k) {
        this.keyboard = k;
        this.stop = false;
    }

    /**
     * Do one frame and check if the user paused the game.
     * @param d the draw surface.
     */
    public void doOneFrame(DrawSurface d) {
        d.drawText(200, d.getHeight() / 4, "Paused ,take a lil break", 32);
        d.drawText(200, d.getHeight() / 2, "press space to come back", 32);
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