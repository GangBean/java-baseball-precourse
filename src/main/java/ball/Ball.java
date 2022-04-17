package ball;

public class Ball {
    private static final int MAX_BALL_NUMBER = 9;
    private static final int MIN_BALL_NUMBER = 1;
    private static final int MAX_INDEX_NUMBER = 2;
    private static final int MIN_INDEX_NUMBER = 0;
    private int number;
    private int idx;

    public Ball(int number, int idx) {
        validateNumberRange(number);
        validateIndexRange(idx);
        this.number = number;
        this.idx = idx;
    }

    public int getNumber() {
        return number;
    }

    public int getIdx() {
        return idx;
    }

    private static void validateNumberRange(int number) {
        if (number < MIN_BALL_NUMBER || number > MAX_BALL_NUMBER) {
            throw new IllegalArgumentException("Out of number range");
        }
    }

    private static void validateIndexRange(int idx) {
        if (idx < MIN_INDEX_NUMBER || idx > MAX_INDEX_NUMBER) {
            throw new IllegalArgumentException("Out of index range");
        }
    }
}
