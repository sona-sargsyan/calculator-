package testng.simplemath;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import testng.BaseTest;

public class DivisionTest extends BaseTest {

    @DataProvider(name = "dataForDoubleDivisionTest")
    public Object[][] dataForDoubleDivision() {
        return new Object[][]{
                {4, 2, (4 / 2)},
                {-5.5, 5.5, (-5.5 / 5.5)},
                {0, 0.65, (0 / 0.65)},
                {0.6, 1, (0.6 / 1)},
                {1.00, 50, (1.00 / 50)},
                {Double.MIN_VALUE, Double.MAX_VALUE, (Double.MIN_VALUE / Double.MAX_VALUE)}
        };
    }

    @DataProvider(name = "dataForLongDivisionTest")
    public Object[][] dataForLongDivision() {
        return new Object[][]{
                {4, 2, (4 / 2)},
                {-5, 5, (-5 / 5)},
                {0, 5, 0},
                {4, 4, (4 / 4)},
                {5, 1, (5 / 1)},
                {Long.MIN_VALUE, Long.MAX_VALUE, (Long.MIN_VALUE / Long.MAX_VALUE)}
        };
    }

    @Test(dataProvider = "dataForDoubleDivisionTest", groups = "bugs")
    public void testDoubleDivision(double firstValue, double secondValue, double expectedResult) {
        double actualResult = calculator.div(firstValue, secondValue);
        Assert.assertEquals(actualResult, expectedResult, "Division Failed!");
    }

    @Test(dataProvider = "dataForLongDivisionTest", groups = "bugs")
    public void testLongDivision(double firstValue, double secondValue, double expectedResult) {
        double actualResult = calculator.div(firstValue, secondValue);
        Assert.assertEquals(actualResult, expectedResult, "Division Failed!");
    }

    @Test
    public void testDivLongByZero() {
        Assert.assertThrows(NumberFormatException.class, () -> calculator.div(2, 0));
    }

    @Test(groups = "bugs")
    public void testDivDoubleByZero() {
        Assert.assertThrows(NumberFormatException.class, () -> calculator.div(2.3, 0));
    }

}
