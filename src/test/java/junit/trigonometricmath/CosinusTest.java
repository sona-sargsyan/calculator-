package junit.trigonometricmath;

import junit.BaseTest;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

public class CosinusTest extends BaseTest {

    private static Stream<Arguments> dataForCosinus() {
        return Stream.of(
                Arguments.of(0, Math.cos(0)),
                Arguments.of(1, Math.cos(1)),
                Arguments.of(Math.PI / 6, Math.cos(Math.PI / 6)),
                Arguments.of(Math.PI / 4, Math.cos(Math.PI / 4)),
                Arguments.of(Math.PI / 3, Math.cos(Math.PI / 3))
        );
    }

    @ParameterizedTest
    @MethodSource("dataForCosinus")
    public void testCosinus(double cosinusValue, double expectedResult) {
        double actualResult = calculator.cos(cosinusValue);
        Assertions.assertEquals(actualResult, expectedResult, "Cosinus Failed");
    }

}
