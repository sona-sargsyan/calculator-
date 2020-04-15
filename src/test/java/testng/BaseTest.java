package testng;

import com.epam.tat.module4.Calculator;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

public class BaseTest {
    protected Calculator calculator;

    @BeforeClass(alwaysRun = true)
    protected void setUp() {
        calculator = new Calculator();
    }

    @AfterClass
    protected void tearDown() {
        calculator = null;
    }

}
