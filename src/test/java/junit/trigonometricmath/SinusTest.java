package junit.trigonometricmath;

import junit.BaseTest;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

public class SinusTest extends BaseTest {

    private static Stream<Arguments> dataForSinus() {
        return Stream.of(
                Arguments.of(0, Math.sin(0)),
                Arguments.of(1, Math.sin(1)),
                Arguments.of(Math.PI / 6, Math.sin(Math.PI / 6)),
                Arguments.of(Math.PI / 4, Math.sin(Math.PI / 4)),
                Arguments.of(Math.PI / 3, Math.sin(Math.PI / 3))
        );
    }

    @ParameterizedTest
    @MethodSource("dataForSinus")
    public void testSinus(double sinusValue, double expectedResult) {
        double actualResult = calculator.sin(sinusValue);
        Assertions.assertEquals(actualResult, expectedResult, "Sinus Failed");
    }

}
