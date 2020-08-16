import biuoop.DrawSurface;

import java.awt.Color;

/**
 * This class is a level indicator for the game.
 */
public class LevelIndicator implements Sprite {
    private String level;

    /**
     * Constructor.
     * @param level the current score.
     */
    public LevelIndicator(String level) {
        this.level = level;
    }
    /**
     * draw the sprite to the screen.
     * @param d the draw surface.
     */
    public void drawOn(DrawSurface d) {
        d.setColor(Color.BLACK);
        d.drawRectangle(0, 0, 800, 20);
        d.drawText(570, 15, "Level:" + this.level, 10);
    }

    /**
     * notify the sprite that time has passed.
     */
    public void timePassed() { }

    /**
     * adds the sprites to the game.
     * @param g the game we want to add the sprites to.
     */
    public void addToGame(GameLevel g) {
        g.addSprite(this);
    }
}