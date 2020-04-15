package testng.squareroot;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import testng.BaseTest;

public class SquareRootTest extends BaseTest {

    @DataProvider(name = "dataForSquareRootTest")
    public Object[][] dataForSquareRoot() {
        return new Object[][]{
                {5.3, Math.sqrt(5.3)},
                {16, Math.sqrt(16)},
                {0, Math.sqrt(0)},
                {-8, Math.sqrt(-8)},
                {1, Math.sqrt(1)}
        };
    }

    @Test(dataProvider = "dataForSquareRootTest", groups = "bugs")
    public void testSquareRoot(double number, double expectedResult) {
        double actualResult = calculator.sqrt(number);
        Assert.assertEquals(actualResult, expectedResult, "Square Root Failed!");
    }

}
