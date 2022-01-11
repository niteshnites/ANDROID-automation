package calculator_tests;

import driver.BaseDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;

public class MultiplicationTest extends BaseDriver {

    @Test
    public void multiplicationTest_01() {
        HomePage homePage = new HomePage(driver);

        homePage.clickOnDigit_4();
        homePage.clickOnMultiplyOperation();
        homePage.clickOnDigit_3();
        homePage.clickOnEqualsOperation();
        Assert.assertEquals(homePage.getCalculationResult(), "12");
    }
}
