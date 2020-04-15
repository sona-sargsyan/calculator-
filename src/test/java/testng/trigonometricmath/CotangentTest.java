package testng.trigonometricmath;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import testng.BaseTest;

public class CotangentTest extends BaseTest {

    @DataProvider(name = "dataForCotangentTest")
    public Object[][] dataForCotangent() {
        return new Object[][]{
                {0, (Math.cos(0) / Math.sin(0))},
                {1, (Math.cos(1) / Math.sin(1))},
                {Math.PI / 6, (Math.cos(Math.PI / 6) / Math.sin(Math.PI / 6))},
                {Math.PI / 4, (Math.cos(Math.PI / 4) / Math.sin(Math.PI / 4))},
                {Math.PI / 3, (Math.cos(Math.PI / 3) / Math.sin(Math.PI / 3))},
        };
    }

    @Test(dataProvider = "dataForCotangentTest")
    public void testCotangent(double ctgValue, double expectedResult) {
        double actualResult = calculator.ctg(ctgValue);
        Assert.assertEquals(actualResult, expectedResult);
    }
}
