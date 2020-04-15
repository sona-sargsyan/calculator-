package junit.exponentiation;

import junit.BaseTest;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

public class PowerTest extends BaseTest {

    private static Stream<Arguments> dataForPow() {
        return Stream.of(
                Arguments.of(-5, 4, Math.pow(-5, 4)),
                Arguments.of(0, 0, Math.pow(0, 0)),
                Arguments.of(0, 1, Math.pow(0, 1)),
                Arguments.of(10, 0, Math.pow(10, 0))
        );
    }

    @ParameterizedTest
    @MethodSource("dataForPow")
    public void testPow(double number, double power, double expectedResult) {
        double actualResult = calculator.pow(number, power);
        Assertions.assertEquals(actualResult, expectedResult, "Exponentiation Failed!");
    }
}
