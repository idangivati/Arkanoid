import biuoop.DrawSurface;

import java.util.ArrayList;
import java.util.List;


/**
 * This class create a lost of sprites.
 */
public class SpriteCollection {
    private List<Sprite> sprites;

    /**
     * Constructors.
     */
    public SpriteCollection() {
        this.sprites = new ArrayList<Sprite>();
    }

    /**
     * Adding a sprite to the list.
     * @param s the Sprite we receive
     */
    public void addSprite(Sprite s) {
        sprites.add(s);
    }

    /**
     * Call timePassed() on all sprites.
     */
    public void notifyAllTimePassed() {
        List<Sprite> sc = new ArrayList<>(this.sprites);
        for (Sprite s : sc) {
            s.timePassed();
        }
    }

    /**
     * Call drawOn(d) on all sprites.
     * @param d the draw surface.
     */
    public void drawAllOn(DrawSurface d) {
        for (Sprite s : sprites) {
            s.drawOn(d);
        }
    }

    /**
     * This class remove a sprite.
     * @param s removing the sprite received.
     */
    public void removeSprite(Sprite s) {
        this.sprites.remove(s);
    }
}