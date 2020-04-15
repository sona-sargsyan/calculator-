package junit.trigonometricmath;

import junit.BaseTest;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

public class TangentTest extends BaseTest {

    private static Stream<Arguments> dataForTangent() {
        return Stream.of(
                Arguments.of(0, (Math.sin(0) / Math.cos(0))),
                Arguments.of(1, (Math.sin(1) / Math.cos(1))),
                Arguments.of(Math.PI / 6, (Math.sin(Math.PI / 6) / Math.cos(Math.PI / 6))),
                Arguments.of(Math.PI / 4, (Math.sin(Math.PI / 4) / Math.cos(Math.PI / 4))),
                Arguments.of(Math.PI / 3, (Math.sin(Math.PI / 3) / Math.cos(Math.PI / 3)))
        );
    }

    @ParameterizedTest
    @MethodSource("dataForTangent")
    public void testTangent(double tangentValue, double expectedResult) {
        double actualResult = calculator.tg(tangentValue);
        Assertions.assertEquals(actualResult, expectedResult, "Tangent Failed");
    }

}
