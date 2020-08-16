/**
 * A counter.
 */
public class Counter {
    private int counter;

    /**
     * Constructor.
     */
    public Counter() {
        this.counter = 0;
    }
    /**
     * Add number to current count.
     * @param number the number we want to add.
     */
    public void increase(int number) {
        this.counter = this.counter + number;
    }

    /**
     * subtract number from current count.
     * @param number the number we want to subtract.
     */
    public void decrease(int number) {
        this.counter = this.counter - number;
    }

    /**
     * This program returns the current count.
     * @return the current count.
     */

    public int getValue() {
        return this.counter;
    }
}