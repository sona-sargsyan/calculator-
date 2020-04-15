package junit.simplemath;

import junit.BaseTest;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

public class SumTest extends BaseTest {

    private static Stream<Arguments> dataForLongSum() {
        return Stream.of(
                Arguments.of(4, 2, 4 + 2),
                Arguments.of(0, 0, 0 + 0),
                Arguments.of(Long.MAX_VALUE, -Long.MAX_VALUE, 0),
                Arguments.of(-10, -10, -10 + (-10))
        );
    }

    private static Stream<Arguments> dataForDoubleSum() {
        return Stream.of(
                Arguments.of(6.4, -2, (6.4 + (-2))),
                Arguments.of(1.6, 5.7, (1.6 + 5.7)),
                Arguments.of(Double.MAX_VALUE, -Double.MAX_VALUE, 0),
                Arguments.of(5, 6, 5 + 6)
        );
    }

    @ParameterizedTest
    @MethodSource("dataForLongSum")
    public void testLongSum(long firstValue, long secondValue, long expectedResult) {
        long actualResult = calculator.sum(firstValue, secondValue);
        Assertions.assertEquals(actualResult, expectedResult, "Sum Failed");
    }

    @ParameterizedTest
    @MethodSource("dataForDoubleSum")
    public void testDoubleSum(double firstValue, double secondValue, double expectedResult) {
        double actualResult = calculator.sum(firstValue, secondValue);
        Assertions.assertEquals(actualResult, expectedResult, "Sum Failed");
    }
}
