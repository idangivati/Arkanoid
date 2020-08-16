import biuoop.DrawSurface;

/**
 * This interface is on an animations.
 */
public interface Animation {
    /**
     * When we only want to do one frame.
     * @param d the draw surface.
     */
    void doOneFrame(DrawSurface d);

    /**
     * When the game should stop.
     * @return if the game stopped or not.
     */
    boolean shouldStop();
}
