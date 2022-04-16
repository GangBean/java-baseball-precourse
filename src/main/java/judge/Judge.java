package judge;

import ball.Ball;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.Arrays;

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

    private static void validateNumberLength( String input ){
        if( input.length() != BALL_COUNT ){
            throw new IllegalArgumentException("Not enough length");
        }
    }

    public void createNumber(){
        this.balls = new int[BALL_COUNT];
        for (int i = 0; i < BALL_COUNT; i++) {
            this.balls[i] = pickExclusiveNumber();
        }
    }

    private int pickExclusiveNumber(){
        int number = Randoms.pickNumberInRange(MIN_BALL_NUMBER, MAX_BALL_NUMBER);
        while( this.checkInclusive( number ) ) {
            number = Randoms.pickNumberInRange(MIN_BALL_NUMBER, MAX_BALL_NUMBER);
        }
        return number;
    }

    private boolean checkInclusive( int number ){
        return Arrays.asList(balls).contains(number);
    }

    private static void validateNumberFormat( String input ){
        for( char number: input.toCharArray() ){
            validateEachNumberFormat(number);
        }
    }

    private static void validateEachNumberFormat( char number ){
        if( number < '0' || number > '9'){
            throw new IllegalArgumentException( "Not a number format input" );
        }
    }

    public String judge( String input ){
        validateNumberLength( input );
        validateNumberFormat( input );
        Ball[] inputBalls = new Ball[ BALL_COUNT ];
        for( int i = 0; i < BALL_COUNT; i++ ){
            inputBalls[i] = new Ball( input.charAt(i) - '0', i );
        }
        judgeBalls( inputBalls );

        return this.makeCall();
    }

    private String makeCall(){
        StringBuilder stringBuilder = new StringBuilder();
        if( this.ballCount == 0 && this.strikeCount == 0 ){
            stringBuilder.append( "낫싱" );
        }
        if( this.ballCount > 0 ){
            stringBuilder.append( this.ballCount ).append("볼").append(" ");
        }
        if( this.strikeCount > 0 ){
            stringBuilder.append( this.strikeCount ).append("스트라이크");
        }
        this.ballCount = 0;
        this.strikeCount = 0;
        return stringBuilder.toString();
    }

    private void judgeBalls( Ball[] balls ){
        for( Ball ball : balls ){
            this.judgeStrike( ball );
            this.judgeBall( ball );
        }
    }

    private void judgeStrike( Ball ball ) {
        int number = ball.getNumber();
        int idx = ball.getIdx();
        if( number == this.balls[idx] ){
            this.strikeCount++;
        }
    }

    private void judgeBall( Ball ball ) {
        int number = ball.getNumber();
        int idx = ball.getIdx();
        if( number == this.balls[ (idx + 1) % BALL_COUNT ]
            || number == this.balls[ (idx + 2) % BALL_COUNT ] ){
            this.ballCount++;
        }
    }
}
