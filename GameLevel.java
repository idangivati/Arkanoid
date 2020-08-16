import biuoop.DrawSurface;
import biuoop.KeyboardSensor;

import java.awt.Color;

/**
 * This program creates a game with a list of collidables and sprite collection (another list).
 */
public class GameLevel implements Animation {
    private AnimationRunner runner;
    private boolean running;
    private SpriteCollection sprites;
    private GameEnvironment environment;
    private Counter counterBall;
    private Counter counterBlock;
    private BlockRemover removerBlock;
    private BallRemover removerBall;
    private ScoreTrackingListener scoreListen;
    private ScoreIndicator tracker;
    private Counter scoreCount;
    private KeyboardSensor keyboard;
    private LevelInformation levels;
    private LevelIndicator levelName;
    /**
     * Constructors.
     */
    public GameLevel() {
        this.levels = null;
        this.scoreCount = new Counter();
        this.scoreListen = new ScoreTrackingListener(this.scoreCount);
        this.tracker = new ScoreIndicator(this.scoreCount);
        this.counterBlock = new Counter();
        this.counterBall = new Counter();
        this.sprites = new SpriteCollection();
        this.environment = new GameEnvironment();
        this.removerBlock = new BlockRemover(this, this.counterBlock);
        this.removerBall = new BallRemover(this, this.counterBall);
        this.runner = new AnimationRunner();
        this.running = true;
        this.keyboard = this.runner.getGui().getKeyboardSensor();
    }

    /**
     * Constructors.
     * @param levels the levels we want the game to run on.
     * @param ks the keyboard we work on.
     * @param ar the animation we work on.
     * @param score the score.
     */
    public GameLevel(LevelInformation levels, KeyboardSensor ks, AnimationRunner ar, int score) {
        this.levelName = new LevelIndicator(levels.levelName());
        this.levels = levels;
        this.scoreCount = new Counter();
        scoreCount.increase(score);
        this.scoreListen = new ScoreTrackingListener(this.scoreCount);
        this.tracker = new ScoreIndicator(this.scoreCount);
        this.counterBlock = new Counter();
        counterBlock.increase(levels.numberOfBlocksToRemove());
        this.counterBall = new Counter();
        counterBall.increase(levels.numberOfBalls());
        this.sprites = new SpriteCollection();
        this.environment = new GameEnvironment();
        this.removerBlock = new BlockRemover(this, this.counterBlock);
        this.removerBall = new BallRemover(this, this.counterBall);
        this.runner = ar;
        this.running = true;
        this.keyboard = ks;
    }

    /**
     *This program adds a collidable to the list of collidables.
     * @param c adding c to the
     */
    public void addCollidable(Collidable c) {
            environment.addCollidable(c);
    }

    /**
     * When the game should stop.
     * @return if the game stopped or not.
     */
    public boolean shouldStop() {
        return !this.running;
    }

    /**
     * When we only want to do one frame.
     * @param d the draw surface.
     */
    public void doOneFrame(DrawSurface d) {
        if (this.keyboard.isPressed("p") || this.keyboard.isPressed("פ") || this.keyboard.isPressed("P")) {
            this.runner.run(new KeyPressStoppableAnimation(this.keyboard, this.keyboard.SPACE_KEY,
                    new PauseScreen(this.keyboard)));
        }
        if (this.counterBlock.getValue() == 0) {
            this.scoreCount.increase(100);
            this.running = false;
        }
        if (this.counterBall.getValue() == 0) {
            this.running = false;
        }
        this.sprites.drawAllOn(d);
        this.sprites.notifyAllTimePassed();
    }
    /**
     * Adding sprite to the sprite collection.
     * @param s the sprite we want to add.
     */
    public void addSprite(Sprite s) {
        sprites.addSprite(s);
    }

    /**
     * add the frame to the game.
     */
    public void addFrame() {
        Rectangle up = new Rectangle(new Point(0, 20), 800, 20);
        Block blockyUp = new Block(up);
        blockyUp.addToGame(this);
        Rectangle down = new Rectangle(new Point(0, 580), 800, 20);
        Block blockyDown = new Block(down, Color.black);
        blockyDown.addToGame(this);
        blockyDown.addHitListener(this.removerBall);
        Rectangle left = new Rectangle(new Point(0, 20), 20, 580);
        Block blockyLeft = new Block(left);
        blockyLeft.addToGame(this);
        Rectangle right = new Rectangle(new Point(780, 20), 20, 580);
        Block blockyRight = new Block(right);
        blockyRight.addToGame(this);
    }
    /**
     * Initialize a new game: create the Blocks and Ball (and Paddle) and add them to the game.
     */
    public void initialize() {
        this.sprites.addSprite(this.levels.getBackground());
        for (int i = 0; i < this.levels.numberOfBalls(); i++) {
            Ball ball = new Ball(398, 500, 4, Color.white, this.environment);
            ball.setVelocity(this.levels.initialBallVelocities().get(i));
            ball.addToGame(this);
        }
        for (Block b: this.levels.blocks()) {
            b.addToGame(this);
            b.addHitListener(this.removerBlock);
            b.addHitListener(this.scoreListen);
        }
        Paddle paddle = new Paddle(new Rectangle(new Point((double) (800 - this.levels.paddleWidth()) / 2, 570),
                this.levels.paddleWidth(), 15),
                this.runner.getGui().getKeyboardSensor(), this.levels.paddleSpeed());
        paddle.addToGame(this);
        addFrame();
        this.tracker.addToGame(this);
        this.levelName.addToGame(this);
    }

    /**
     * Run the game -- start the animation loop.
     */
    public void run() {
        this.runner.run(new CountdownAnimation(2, 3, this.sprites));
        // countdown before turn starts.
        // use our runner to run the current animation -- which is one turn of
        // the game.
        this.running = true;
        this.runner.run(this);
    }

    /**
     * This program remove the collidable received from the collidable collection.
     * @param c the collidable we want to remove.
     */
    public void removeCollidable(Collidable c) {
        this.environment.removeColliadble(c);
    }

    /**
     * This program remove the sprite received from the sprite collection.
     * @param s the sprite we want to remove.
     */
    public void removeSprite(Sprite s) {
        this.sprites.removeSprite(s);
    }

    /**
     * Get the number of balls.
     * @return the number of balls.
     */
    public Counter getNumOfBalls() {
        return this.counterBall;
    }

    /**
     * Get the number of blocks.
     * @return the number of blocks.
     */
    public Counter getNumOfBlocks() {
        return this.counterBlock;
    }

    /**
     * Get the score.
     * @return the number of blocks.
     */
    public Counter getScore() {
        return this.scoreCount;
    }
}
