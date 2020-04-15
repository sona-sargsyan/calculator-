package testng.exponentiation;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import testng.BaseTest;

public class PowerTest extends BaseTest {

    @DataProvider(name = "dataForPowerTest")
    public Object[][] dataForPower() {
        return new Object[][]{
                {-5, 4, Math.pow(-5, 4)},
                {0, 0, Math.pow(0, 0)},
                {0, 1, Math.pow(0, 1)},
                {10, 0, Math.pow(10, 0)}
        };
    }

    @Test(dataProvider = "dataForPowerTest")
    public void testPow(double number, double power, double expectedResult) {
        double actualResult = calculator.pow(number, power);
        Assert.assertEquals(actualResult, expectedResult, "Exponentiation Failed!");
    }
}
