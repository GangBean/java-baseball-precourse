package study;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class StringTest {
    @Test
    void 스플릿_테스트(){
        String[] input = "1,2".split(",");
        assertThat(input)
                .contains("1")
                .contains("2");
    }

    @Test
    void 스플릿_테스트_단독(){
        String[] input = "1".split(",");
        assertThat(input)
                .containsExactly("1");
    }

    @Test
    void 서브스트링_테스트(){
        String input = "(1,2)";
        input = input.substring(1);
        input = input.substring(0, input.length()-1);
        assertThat(input)
                .isEqualTo("1,2");
    }

    @Test
    @DisplayName("String.charAt() 테스트")
    void charAt_테스트(){
        String input = "abc";
        assertThat(input.charAt(0))
                .isEqualTo('a');
        assertThat(input.charAt(1))
                .isEqualTo('b');
        assertThat(input.charAt(2))
                .isEqualTo('c');
    }

    @Test
    @DisplayName("STring.charAt() outofindex 테스트")
    void StringOutOfBoundsException_테스트(){
        String input = "abc";
        assertThatThrownBy(()->{ char c = input.charAt(4);})
                .isInstanceOf(StringIndexOutOfBoundsException.class);
    }
}
