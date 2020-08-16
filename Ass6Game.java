import java.util.ArrayList;
import java.util.List;

/**
 * The class that runs the game.
 */
public class Ass6Game {
    /**
     * The main class of the game.
     * @param args , if there is any we want to run the levels by the args order (if valid).
     */
    public static void main(String[]args) {
        AnimationRunner runner = new AnimationRunner();
        GameFlow flow = new GameFlow(runner, runner.getGui().getKeyboardSensor());
        List<LevelInformation> levels = new ArrayList<>();
        WideEasy second = new WideEasy();
        DirectHit first = new DirectHit();
        Green3 third = new Green3();
        FinalFour last = new FinalFour();
        int counter = 0;
        for (String arg : args) {
            if (arg.equals("1")) {
                levels.add(first);
                counter++;
            }
            if (arg.equals("2")) {
                levels.add(second);
                counter++;
            }
            if (arg.equals("3")) {
                levels.add(third);
                counter++;
            }
            if (arg.equals("4")) {
                levels.add(last);
                counter++;
            }
        }
        if (counter == 0) {
            levels.add(first);
            levels.add(second);
            levels.add(third);
            levels.add(last);
        }
        flow.runLevels(levels);
    }
}
