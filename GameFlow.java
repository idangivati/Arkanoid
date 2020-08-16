import biuoop.KeyboardSensor;

import java.util.List;

/**
 * This program make the game work fluently.
 */
public class GameFlow {
    private AnimationRunner ar;
    private KeyboardSensor ks;
    /**
     * Constructors.
     * @param ar the animation runner.
     * @param ks the Keyboard sensor.
     */
    public GameFlow(AnimationRunner ar, KeyboardSensor ks) {
        this.ar = ar;
        this.ks = ks;
    }

    /**
     * The program in charge of the levels to run one after another and save the score.
     * @param levels the levels we run on.
     */
    public void runLevels(List<LevelInformation> levels) {
        int score = 0;
        for (LevelInformation levelInfo : levels) {
            GameLevel level = new GameLevel(levelInfo,
                    this.ks,
                    this.ar, score);
            level.initialize();
            while (level.getNumOfBalls().getValue() > 0 && level.getNumOfBlocks().getValue() > 0) {
                level.run();
            }
            score = level.getScore().getValue();
            if (level.getNumOfBalls().getValue() <= 0) {
                this.ar.run(new KeyPressStoppableAnimation(this.ks, this.ks.SPACE_KEY,
                        new EndGame(this.ks, score, false)));
                this.ar.getGui().close();
                break;
            }
        }
        this.ar.run(new KeyPressStoppableAnimation(this.ks, this.ks.SPACE_KEY,
                new EndGame(this.ks, score, true)));
        this.ar.getGui().close();
    }
}