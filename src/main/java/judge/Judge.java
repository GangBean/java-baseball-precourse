package judge;

import ball.Ball;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.regex.Pattern;

public class Judge {
    private static final int BALL_COUNT = 3;
    private static final int MAX_BALL_NUMBER = 9;
    private static final int MIN_BALL_NUMBER = 1;
    private int[] balls;
    private int ballCount;
    private int strikeCount;

    public Judge() {
        createNumber();
    }

    private static void validateNumberLength(String input) {
        if (input.length() != BALL_COUNT) {
            throw new IllegalArgumentException("Input length must be " + BALL_COUNT);
        }
    }

    public void createNumber() {
        this.balls = new int[BALL_COUNT];
        for (int i = 0; i < BALL_COUNT; i++) {
            this.balls[i] = pickExclusiveNumber();
        }
    }

    private int pickExclusiveNumber() {
        int number = Randoms.pickNumberInRange(MIN_BALL_NUMBER, MAX_BALL_NUMBER);
        while (this.checkInclusive(number)) {
            number = Randoms.pickNumberInRange(MIN_BALL_NUMBER, MAX_BALL_NUMBER);
        }
        return number;
    }

    private boolean checkInclusive(int number) {
        boolean isIn = false;
        for (int ball : balls) {
            isIn = isIn | (number == ball);
        }
        return isIn;
    }

    private static void validateNumberFormat(String input) {
        if (!Pattern.matches("^[1-9]*$", input)) {
            throw new IllegalArgumentException("Not a number format input");
        }
    }

    public String judge(String input) {
        validateNumberLength(input);
        validateNumberFormat(input);
        Ball[] inputBalls = new Ball[BALL_COUNT];
        for (int i = 0; i < BALL_COUNT; i++) {
            inputBalls[i] = new Ball(input.charAt(i) - '0', i);
        }
        judgeBalls(inputBalls);

        return this.makeCall();
    }

    private String makeCall() {
        StringBuilder stringBuilder = new StringBuilder();
        if (this.ballCount == 0 && this.strikeCount == 0) {
            stringBuilder.append("낫싱");
        }
        stringBuilder.append(ballCall());
        stringBuilder.append(strikeCall());

        this.ballCount = 0;
        this.strikeCount = 0;
        return stringBuilder.toString().trim();
    }

    private String strikeCall() {
        StringBuilder stringBuilder = new StringBuilder();

        if (this.strikeCount > 0) {
            stringBuilder.append(this.strikeCount).append("스트라이크");
        }
        return stringBuilder.toString();
    }

    private String ballCall() {
        StringBuilder stringBuilder = new StringBuilder();

        if (this.ballCount > 0) {
            stringBuilder.append(this.ballCount).append("볼").append(" ");
        }
        return stringBuilder.toString();
    }

    private void judgeBalls(Ball[] balls) {
        for (Ball ball : balls) {
            this.judgeStrike(ball);
            this.judgeBall(ball);
        }
    }

    private void judgeStrike(Ball ball) {
        int number = ball.getNumber();
        int idx = ball.getIdx();
        if (number == this.balls[idx]) {
            this.strikeCount++;
        }
    }

    private void judgeBall(Ball ball) {
        int number = ball.getNumber();
        int idx = ball.getIdx();
        if (number == this.balls[(idx + 1) % BALL_COUNT]
                || number == this.balls[(idx + 2) % BALL_COUNT]) {
            this.ballCount++;
        }
    }
}
