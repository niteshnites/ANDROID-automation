package calculator_tests;

import driver.BaseDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;

public class AdditionTest extends BaseDriver {

    @Test
    public void additionTest_01() {
        HomePage homePage = new HomePage(driver);
        homePage.clickOnDigit_5();
        homePage.clickOnAdditionOperation();
        homePage.clickOnDigit_6();
        homePage.clickOnEqualsOperation();
        Assert.assertEquals(homePage.getCalculationResult(), "11");
    }

}
