package junit.squareroot;

import junit.BaseTest;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

public class SquareRootTest extends BaseTest {

    private static Stream<Arguments> dataForSquareRoot() {
        return Stream.of(
                Arguments.of(5.3, Math.sqrt(5.3)),
                Arguments.of(16, Math.sqrt(16)),
                Arguments.of(0, Math.sqrt(0)),
                Arguments.of(-8, Math.sqrt(-8)),
                Arguments.of(1, Math.sqrt(1))
        );
    }

    @ParameterizedTest
    @MethodSource("dataForSquareRoot")
    public void testSquareRoot(double number, double expectedResult) {
        double actualResult = calculator.sqrt(number);
        Assertions.assertEquals(actualResult, expectedResult, "Square Root Failed!");
    }

}
