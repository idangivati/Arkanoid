import biuoop.DrawSurface;
import biuoop.KeyboardSensor;

/**
 *
 */
public class KeyPressStoppableAnimation implements Animation {
    private KeyboardSensor sensor;
    private String key;
    private Animation animation;
    private boolean isAlreadyPressed;
    private boolean stop;

    /**
     * Constructors.
     * @param sensor the keyboard sensor we want to work on.
     * @param key the key we pressing.
     * @param animation the animation we want to happen.
     */
    public KeyPressStoppableAnimation(KeyboardSensor sensor, String key, Animation animation) {
        this.animation = animation;
        this.sensor = sensor;
        this.key = key;
        this.isAlreadyPressed = true;
        this.stop = false;
    }

    /**
     * When we want to know if the key was pressed and if we need to stop.
     * @param d the draw surface.
     */
    public void doOneFrame(DrawSurface d) {
        if ((this.sensor.isPressed(this.key)) && this.isAlreadyPressed) {
            this.isAlreadyPressed = false;
        }
        if (!this.sensor.isPressed(this.key)) {
                this.stop = false;
        }
        this.animation.doOneFrame(d);
    }

    /**
     * When the game should stop.
     * @return if the game stopped or not.
     */
    public boolean shouldStop() {
        return this.stop;
    }
}