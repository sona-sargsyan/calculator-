package junit.simplemath;

import junit.BaseTest;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

public class SubtractionTest extends BaseTest {

    private static Stream<Arguments> dataForDoubleSubtraction() {
        return Stream.of(
                Arguments.of(5, 4, (5 - 4)),
                Arguments.of(-5, 0.2, (-5 - 0.2)),
                Arguments.of(6.4, -2, (6.4 - (-2))),
                Arguments.of(Double.MAX_VALUE, Double.MAX_VALUE, 0)
        );
    }

    private static Stream<Arguments> dataForLongSubtraction() {
        return Stream.of(
                Arguments.of(5, 4, (5 - 4)),
                Arguments.of(0, 5, (0 - 5)),
                Arguments.of(Long.MAX_VALUE, Long.MAX_VALUE, 0)
        );
    }

    @ParameterizedTest
    @MethodSource("dataForDoubleSubtraction")
    public void testDoubleSum(double firstValue, double secondValue, double expectedResult) {
        double actualResult = calculator.sub(firstValue, secondValue);
        Assertions.assertEquals(actualResult, expectedResult, "Subtraction Failed");
    }

    @ParameterizedTest
    @MethodSource("dataForLongSubtraction")
    public void testLongSum(long firstValue, long secondValue, long expectedResult) {
        long actualResult = calculator.sub(firstValue, secondValue);
        Assertions.assertEquals(actualResult, expectedResult, "Subtraction Failed");
    }

}
