package ball;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.*;

public class BallTest extends NsTest {

    @ParameterizedTest
    @DisplayName("Ball 생성 시 정상 숫자 테스트")
    @ValueSource(ints = {1,2,3,4,5,6,7,8,9})
    void 공_숫자_정상_테스트( int number ){
        Ball ball = new Ball( number, 0 );
        assertThat( ball.getNumber() ).isEqualTo( number );
    }

    @ParameterizedTest
    @DisplayName("Ball 생성 시 비정상 숫자 테스트")
    @ValueSource(ints = {0,10,11,12,13,14,15})
    void 공_숫자_비정상_테스트( int number ){
        assertThatThrownBy(()->{
            Ball ball = new Ball( number, 0);
        })
                .isInstanceOf( IllegalArgumentException.class );
    }

    @ParameterizedTest
    @DisplayName("Ball 생성 시 인덱스 정상 테스트")
    @ValueSource(ints = {0,1,2})
    void 공_인덱스_정상_테스트( int idx ){
        Ball ball = new Ball(1, idx );
        assertThat( ball.getIdx() ).isEqualTo( idx );
    }

    @ParameterizedTest
    @DisplayName("Ball 생성 시 인덱스 비정상 테스트")
    @ValueSource(ints = {-1,3,10})
    void 공_인덱스_비정상_테스트( int idx ){
        assertThatThrownBy(()->{
            Ball ball = new Ball( 1, idx );
        })
                .isInstanceOf( IllegalArgumentException.class )
                .hasMessage( "Out of index range" );
    }

    @Override
    protected void runMain() {

    }
}
