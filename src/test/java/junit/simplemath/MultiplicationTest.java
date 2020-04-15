package junit.simplemath;

import junit.BaseTest;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

public class MultiplicationTest extends BaseTest {

    private static Stream<Arguments> dataForDoubleMultiplication() {
        return Stream.of(
                Arguments.of(4, 2, (4 * 2)),
                Arguments.of(-5, 0.2, (-5 * 0.2)),
                Arguments.of(6.4, -2, (6.4 * -2)),
                Arguments.of(5.3, 0, (5.3 * 0)),
                Arguments.of(1, 7.8, (1 * 7.8)),
                Arguments.of(Double.MAX_VALUE, Double.MAX_VALUE, (Double.MAX_VALUE * Double.MAX_VALUE)),
                Arguments.of(Double.MIN_VALUE, Double.MIN_VALUE, (Double.MIN_VALUE * Double.MIN_VALUE))
        );
    }

    private static Stream<Arguments> dataForLongMultiplication() {
        return Stream.of(
                Arguments.of(0, 0, 0),
                Arguments.of(1, 5, (1 * 5)),
                Arguments.of(0, 5, 0),
                Arguments.of(Long.MAX_VALUE, Long.MAX_VALUE, (Long.MAX_VALUE * Long.MAX_VALUE)),
                Arguments.of(Long.MIN_VALUE, Long.MIN_VALUE, (Long.MIN_VALUE * Long.MIN_VALUE))
        );
    }

    @ParameterizedTest
    @MethodSource("dataForDoubleMultiplication")
    public void testDoubleMultiplication(double firstValue, double secondValue, double expectedResult) {
        double actualResult = calculator.mult(firstValue, secondValue);
        Assertions.assertEquals(actualResult, expectedResult, "Multiplication Failed");
    }

    @ParameterizedTest
    @MethodSource("dataForLongMultiplication")
    public void testLongMultiplication(long firstValue, long secondValue, long expectedResult) {
        long actualResult = calculator.mult(firstValue, secondValue);
        Assertions.assertEquals(actualResult, expectedResult, "Multiplication Failed");
    }

}
