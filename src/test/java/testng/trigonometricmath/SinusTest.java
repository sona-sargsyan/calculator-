package testng.trigonometricmath;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import testng.BaseTest;

public class SinusTest extends BaseTest {

    @DataProvider(name = "dataForSinusTest")
    public Object[][] dataForSinus() {
        return new Object[][]{
                {0, Math.sin(0)},
                {1, Math.sin(1)},
                {Math.PI / 6, Math.sin(Math.PI / 6)},
                {Math.PI / 4, Math.sin(Math.PI / 4)},
                {Math.PI / 3, Math.sin(Math.PI / 3)},
        };
    }

    @Test(dataProvider = "dataForSinusTest")
    public void testSinus(double sinValue, double expectedResult) {
        double actualResult = calculator.sin(sinValue);
        Assert.assertEquals(actualResult, expectedResult);
    }
}
