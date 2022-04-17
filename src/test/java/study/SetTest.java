package study;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import static org.assertj.core.api.Assertions.*;

public class SetTest {

    @Test
    @DisplayName("Set.size() 테스트")
    void Set_사이즈_테스트() {
        Set<String> input = new HashSet<>();
        input.add("A");
        input.add("b");

        assertThat(input.size())
                .isEqualTo(2);
    }


    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3})
    @DisplayName("set contain 테스트")
    void Set_컨테인_테스트(int number) {
        Set<Integer> input = new HashSet<>();
        input.add(1);
        input.add(2);
        input.add(3);
        assertThat(input.contains(number)).isTrue();
    }

    @ParameterizedTest
    @DisplayName("set contains 입력값:출력값 테스트")
    @CsvSource(value = {"1:true", "2:true", "3:true", "4:false", "5:false"}, delimiter = ':')
    void Set_입출력_테스트(int number, boolean expected) {
        Set<Integer> input = new HashSet<>();
        input.add(1);
        input.add(2);
        input.add(3);
        assertThat(input.contains(number)).isEqualTo(expected);
    }
}
