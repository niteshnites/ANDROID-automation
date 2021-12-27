package calculator_tests;

import pages.HomePage;
import driver.BaseDriver;
import org.testng.annotations.Test;

public class HomePageValidationTest extends BaseDriver {

    @Test
    public void homePageValidationTest_01() {
        HomePage homePage = new HomePage(driver);

        homePage.clickOnDigit_0();
        homePage.clickOnDigit_1();
        homePage.clickOnDigit_2();
        homePage.clickOnDigit_3();
        homePage.clickOnDigit_4();
        homePage.clickOnDigit_5();
        homePage.clickOnDigit_6();
        homePage.clickOnDigit_7();
        homePage.clickOnDigit_8();
        homePage.clickOnDigit_9();

    }
}
