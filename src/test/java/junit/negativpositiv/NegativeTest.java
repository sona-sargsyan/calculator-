package junit.negativpositiv;

import junit.BaseTest;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

public class NegativeTest extends BaseTest {

    private static Stream<Arguments> dataForNegative() {
        return Stream.of(
                Arguments.of(5, false),
                Arguments.of(0, false),
                Arguments.of(-1, true)
        );
    }

    @ParameterizedTest
    @MethodSource("dataForNegative")
    public void testIsNegative(long value, boolean expectedResult) {
        boolean actualResult = calculator.isNegative(value);
        Assertions.assertEquals(actualResult, expectedResult, "Is Negative Failed!");
    }
}
