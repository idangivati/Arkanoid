import biuoop.DrawSurface;

import java.awt.Color;

/**
 * This class is a score indicator for the game.
 */
public class ScoreIndicator implements Sprite {
    private Counter score;

    /**
     * Constructor.
     * @param score the current score.
     */
    public ScoreIndicator(Counter score) {
        this.score = score;
    }
    /**
     * draw the sprite to the screen.
     * @param d the draw surface.
     */
    public void drawOn(DrawSurface d) {
        d.setColor(Color.white);
        d.fillRectangle(0, 0, 800, 20);
        d.setColor(Color.BLACK);
        d.drawRectangle(0, 0, 800, 20);
        d.drawText(370, 15, "Score:" + this.score.getValue(), 10);
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
