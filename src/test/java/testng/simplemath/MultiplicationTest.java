package testng.simplemath;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import testng.BaseTest;

public class MultiplicationTest extends BaseTest {

    @DataProvider(name = "dataForDoubleMultiplicationTest")
    public Object[][] dataForDoubleMultiplication() {
        return new Object[][]{
                {4, 2, (4 * 2)},
                {-5, 0.2, (-5 * 0.2)},
                {6.4, -2, (6.4 * -2)},
                {5.3, 0, (5.3 * 0)},
                {1, 7.8, (1 * 7.8)},
                {Double.MAX_VALUE, Double.MAX_VALUE, (Double.MAX_VALUE * Double.MAX_VALUE)},
                {Double.MIN_VALUE, Double.MIN_VALUE, (Double.MIN_VALUE * Double.MIN_VALUE)}
        };
    }

    @DataProvider(name = "dataForLongMultiplicationTest")
    public Object[][] dataForLongMultiplication() {
        return new Object[][]{
                {0, 0, 0},
                {1, 5, (1 * 5)},
                {0, 5, 0},
                {Long.MAX_VALUE, Long.MAX_VALUE, (Long.MAX_VALUE * Long.MAX_VALUE)},
                {Long.MIN_VALUE, Long.MIN_VALUE, (Long.MIN_VALUE * Long.MIN_VALUE)}
        };
    }

    @Test(dataProvider = "dataForDoubleMultiplicationTest", groups = "bugs")
    public void testDoubleMultiplication(double firstValue, double secondValue, double expectedResult) {
        double actualResult = calculator.mult(firstValue, secondValue);
        Assert.assertEquals(actualResult, expectedResult, "Multiplication Failed!");
    }

    @Test(dataProvider = "dataForLongMultiplicationTest")
    public void testLongMultiplication(long firstValue, long secondValue, long expectedResult) {
        long actualResult = calculator.mult(firstValue, secondValue);
        Assert.assertEquals(actualResult, expectedResult, "Multiplication Failed!");
    }

}
