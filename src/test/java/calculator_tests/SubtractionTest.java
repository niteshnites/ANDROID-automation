package calculator_tests;

import driver.BaseDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;

public class SubtractionTest extends BaseDriver {

    @Test
    public void subtractionTest_01() {
        HomePage homePage = new HomePage(driver);

        homePage.clickOnDigit_9();
        homePage.clickOnSubtractionOperation();
        homePage.clickOnDigit_3();
        homePage.clickOnEqualsOperation();
        Assert.assertEquals(homePage.getCalculationResult(), "6");
    }
}