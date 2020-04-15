package testng.negativpositiv;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import testng.BaseTest;

public class NegativeTest extends BaseTest {

    @DataProvider(name = "dataForNegativeTest")
    public Object[][] dataForNegative() {
        return new Object[][]{
                {5, false},
                {0, false},
                {-1, true}
        };
    }

    @Test(dataProvider = "dataForNegativeTest")
    public void testIsNegative(long number, boolean expectedResult) {
        boolean actualResult = calculator.isNegative(number);
        Assert.assertEquals(actualResult, expectedResult, "Is Negative Failed!");
    }
}
