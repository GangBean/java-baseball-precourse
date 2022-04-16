package judge;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.*;

public class judgeTest extends NsTest {

    @Test
    @DisplayName( "심판 생성 정상 테스트" )
    void 심판_생성_정상_테스트(){
        Judge judge = new Judge();
        assertThat( judge instanceof Judge ).isEqualTo( true );
    }

    @ParameterizedTest
    @DisplayName( "심판 생성 비정상 테스트" )
    @ValueSource( strings = { "abc", "*&_", "1234", "000", "ABC"} )
    void 심판_생성_비정상_테스트( String input ){
        assertThatThrownBy(()-> {
            Judge judge = new Judge();
            judge.judge( input );
        }).isInstanceOf( IllegalArgumentException.class );
    }

    @ParameterizedTest
    @DisplayName( "심판 정답생성 정상 테스트" )
    @ValueSource( strings = {"123","124","125","126","127","128","129","213","214","456","789"})
    void 심판_정답생성_정상_테스트( String input ){
        Judge judge = new Judge();
        String[] result = {"낫싱","1볼","1스트라이크","2볼","3볼"
                , "2스트라이크", "3스트라이크", "1볼 1스트라이크"
                , "1볼 2스트라이크", "2볼 1스트라이크"};
        System.out.println(judge.judge( input ));
        assertThat( Arrays.asList(result).contains( judge.judge( input ) ) ).isEqualTo( true );
    }

    @ParameterizedTest
    @DisplayName( "심판 정답생성 비정상 테스트 : 중복 수 생성 테스트" )
    @ValueSource( strings = {"111","222","333","444","555","666","777","888","999"})
    void 심판_정답생성_비정상_테스트( String input ){
        Judge judge = new Judge();

        String[] result = {"낫싱", "2볼 1스트라이크"};
        System.out.println(judge.judge( input ));
        assertThat( Arrays.asList(result).contains( judge.judge( input ) ) ).isEqualTo( true );
    }

    @Override
    protected void runMain() {

    }
}
