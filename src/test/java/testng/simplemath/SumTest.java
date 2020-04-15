package testng.simplemath;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import testng.BaseTest;

public class SumTest extends BaseTest {

    @DataProvider(name = "dataForLongSumTest")
    public Object[][] dataForLongSum() {
        return new Object[][]{
                {4, 2, 4 + 2},
                {0, 0, 0 + 0},
                {Long.MAX_VALUE, -Long.MAX_VALUE, 0},
                {-10, -10, -10 + (-10)}
        };
    }

    @DataProvider(name = "dataForDoubleSumTest")
    public Object[][] dataForDoubleSum() {
        return new Object[][]{
                {6.4, -2, (6.4 + (-2))},
                {1.6, 5.7, (1.6 + 5.7)},
                {5, 6, 5 + 6},
                {Double.MAX_VALUE, -Double.MAX_VALUE, 0}
        };
    }

    @Test(dataProvider = "dataForDoubleSumTest")
    public void testDoubleSum(double firstValue, double secondValue, double expectedResult) {
        double actualResult = calculator.sum(firstValue, secondValue);
        Assert.assertEquals(actualResult, expectedResult, "Sum Fail!");
    }

    @Test(dataProvider = "dataForLongSumTest")
    public void testLongSum(long firstValue, long secondValue, long expectedResult) {
        long actualResult = calculator.sum(firstValue, secondValue);
        Assert.assertEquals(actualResult, expectedResult, "Sum Fail!");
    }
}
