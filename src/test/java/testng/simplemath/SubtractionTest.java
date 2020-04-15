package testng.simplemath;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import testng.BaseTest;

public class SubtractionTest extends BaseTest {

    @DataProvider(name = "dataForDoubleSubtractionTest")
    public Object[][] dataForDoubleSubtraction() {
        return new Object[][]{
                {4, 2, 2},
                {-5, 0.2, (-5 - 0.2)},
                {6.4, -2, (6.4 - (-2))},
                {Double.MAX_VALUE, Double.MAX_VALUE, 0}
        };
    }

    @DataProvider(name = "dataForLongSubtractionTest")
    public Object[][] dataForLongSubtraction() {
        return new Object[][]{
                {4, 2, 2},
                {0, 5, -5},
                {Long.MAX_VALUE, Long.MAX_VALUE, 0}
        };
    }

    @Test(dataProvider = "dataForDoubleSubtractionTest")
    public void testDoubleSub(double firstValue, double secondValue, double expectedResult) {
        double actualResult = calculator.sub(firstValue, secondValue);
        Assert.assertEquals(expectedResult, actualResult, "Subtraction Failed!");
    }

    @Test(dataProvider = "dataForLongSubtractionTest")
    public void testSub(long firstValue, long secondValue, long expectedResult) {
        long actualResult = calculator.sub(firstValue, secondValue);
        Assert.assertEquals(expectedResult, actualResult, "Subtraction Failed!");
    }

}
