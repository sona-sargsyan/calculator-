package testng.trigonometricmath;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import testng.BaseTest;

public class CosinusTest extends BaseTest {

    @DataProvider(name = "dataForCosinusTest")
    public Object[][] dataForCosinus() {
        return new Object[][]{
                {0, Math.cos(0)},
                {1, Math.cos(1)},
                {Math.PI / 6, Math.cos(Math.PI / 6)},
                {Math.PI / 4, Math.cos(Math.PI / 4)},
                {Math.PI / 3, Math.cos(Math.PI / 3)},
        };
    }

    @Test(dataProvider = "dataForCosinusTest", groups = "bugs")
    public void testCosinus(double cosValue, double expectedResult) {
        double actualResult = calculator.cos(cosValue);
        Assert.assertEquals(actualResult, expectedResult);
    }
}
