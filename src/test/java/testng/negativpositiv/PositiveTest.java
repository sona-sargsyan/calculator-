package testng.negativpositiv;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import testng.BaseTest;

public class PositiveTest extends BaseTest {

    @DataProvider(name = "dataForPositiveTest")
    public Object[][] dataForPositive() {
        return new Object[][]{
                {5, true},
                {0, false},
                {-1, false}
        };
    }

    @Test(dataProvider = "dataForPositiveTest")
    public void testIsNegative(long number, boolean expectedResult) {
        boolean actualResult = calculator.isPositive(number);
        Assert.assertEquals(actualResult, expectedResult, "Is Positive Failed!");
    }
}
