package junit.negativpositiv;

import junit.BaseTest;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

public class PositiveTest extends BaseTest {

    private static Stream<Arguments> dataForPositive() {
        return Stream.of(
                Arguments.of(5, true),
                Arguments.of(0, false),
                Arguments.of(-1, false)
        );
    }

    @ParameterizedTest
    @MethodSource("dataForPositive")
    public void testIsPositive(long value, boolean expectedResult) {
        boolean actualResult = calculator.isPositive(value);
        Assertions.assertEquals(actualResult, expectedResult, "Is Positive Failed!");
    }
}
