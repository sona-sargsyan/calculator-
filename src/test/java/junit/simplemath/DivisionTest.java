package junit.simplemath;


import junit.BaseTest;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

public class DivisionTest extends BaseTest {

    private static Stream<Arguments> dataForDoubleDivision() {
        return Stream.of(
                Arguments.of(4, 2, (4 / 2)),
                Arguments.of(-5.5, 5.5, (-5.5 / 5.5)),
                Arguments.of(0, 0.65, (0 / 0.65)),
                Arguments.of(0.6, 1, (0.6 / 1)),
                Arguments.of(1.00, 50, (1.00 / 50)),
                Arguments.of(Double.MIN_VALUE, Double.MAX_VALUE, (Double.MIN_VALUE / Double.MAX_VALUE))
        );
    }

    private static Stream<Arguments> dataForLongDivision() {
        return Stream.of(
                Arguments.of(4, 2, (4 / 2)),
                Arguments.of(-5, 5, (-5 / 5)),
                Arguments.of(0, 5, 0),
                Arguments.of(4, 4, (4 / 4)),
                Arguments.of(5, 1, (5 / 1)),
                Arguments.of(Long.MIN_VALUE, Long.MAX_VALUE, (Long.MIN_VALUE / Long.MAX_VALUE))
        );
    }

    @ParameterizedTest
    @MethodSource("dataForDoubleDivision")
    public void testDoubleDivision(double firstValue, double secondValue, double expectedResult) {
        double actualResult = calculator.div(firstValue, secondValue);
        Assertions.assertEquals(actualResult, expectedResult, "Division Failed");
    }

    @ParameterizedTest
    @MethodSource("dataForLongDivision")
    public void testLongDivision(long firstValue, long secondValue, long expectedResult) {
        long actualResult = calculator.div(firstValue, secondValue);
        Assertions.assertEquals(actualResult, expectedResult, "Division Failed");
    }

    @Test
    public void testDivLongByZero() {
        Assertions.assertThrows(NumberFormatException.class, () -> calculator.div(2, 0));
    }

    @Test
    public void testDivDoubleByZero() {
        Assertions.assertThrows(NumberFormatException.class, () -> calculator.div(2.3, 0));
    }

}
