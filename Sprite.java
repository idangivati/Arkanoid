import biuoop.DrawSurface;

/**
 * The interface of the sprite.
 * In this interface we want to notify the sprite that the time has passed and add the sprite to the game.
 */
public interface Sprite {
    /**
     * draw the sprite to the screen.
     * @param d the draw surface.
     */
    void drawOn(DrawSurface d);

    /**
     * notify the sprite that time has passed.
     */
    void timePassed();

    /**
     * adds the sprites to the game.
     * @param g the game we want to add the sprites to.
     */
    void addToGame(GameLevel g);
}