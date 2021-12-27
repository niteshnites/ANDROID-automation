package calculator_tests;

import driver.BaseDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;

public class DivisionTest  extends BaseDriver {

    @Test
    public void divisionTest_01() {
        HomePage homePage = new HomePage(driver);

        homePage.clickOnDigit_1();
        homePage.clickOnDigit_0();
        homePage.clickOnDivideOperation();
        homePage.clickOnDigit_2();
        homePage.clickOnEqualsOperation();
        Assert.assertEquals(homePage.getCalculationResult(), "5");

    }
}
