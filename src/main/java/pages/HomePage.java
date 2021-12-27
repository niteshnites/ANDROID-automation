package pages;

import controls.ControlledElement;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;

public class HomePage extends Page {


    final String DIGIT_0 = "digit_0";
    final String DIGIT_1 = "digit_1";
    final String DIGIT_2 = "digit_2";
    final String DIGIT_3 = "//android.widget.Button[@text='3']";
    final String DIGIT_4 = "digit_4";
    final String DIGIT_5 = "digit_5";
    final String DIGIT_6 = "//android.widget.Button[@text='6']";
    final String DIGIT_7 = "digit_7";
    final String DIGIT_8 = "digit_8";
    final String DIGIT_9 = "//android.widget.Button[@text='9']";
    final String FINAL_RESULT = "result_final";

    final String DIVIDE = "divide";
    final String MULTIPLY = "multiply";
    final String MINUS = "minus";
    final String PLUS = "plus";
    final String EQUALS = "equals";

    MobileElement digit0;
    MobileElement digit1;
    MobileElement digit2;
    MobileElement digit3;
    MobileElement digit4;
    MobileElement digit5;
    MobileElement digit6;
    MobileElement digit7;
    MobileElement digit8;
    MobileElement digit9;
    MobileElement divide;
    MobileElement plus;
    MobileElement minus;
    MobileElement equals;
    MobileElement multiply;
    ControlledElement controlledElement;

    public HomePage(AppiumDriver<MobileElement> driver) {
        super(driver);
        controlledElement = new ControlledElement(driver);
        digit0 = driver.findElementById(DIGIT_0);
        digit1 = driver.findElementById(DIGIT_1);
        digit2 = driver.findElementById(DIGIT_2);
        digit3 = driver.findElementByXPath(DIGIT_3);
        digit4 = driver.findElementById(DIGIT_4);
        digit5 = driver.findElementById(DIGIT_5);
        digit6 = driver.findElementByXPath(DIGIT_6);
        digit7 = driver.findElementById(DIGIT_7);
        digit8 = driver.findElementById(DIGIT_8);
        digit9 = driver.findElementByXPath(DIGIT_9);
        divide = driver.findElementByAccessibilityId(DIVIDE);
        multiply = driver.findElementByAccessibilityId(MULTIPLY);
        minus = driver.findElementByAccessibilityId(MINUS);
        plus = driver.findElementByAccessibilityId(PLUS);
        equals = driver.findElementByAccessibilityId(EQUALS);
    }

    public void clickOnDigit_0() {
        controlledElement.shouldBeDisplayed(digit0);
        digit0.click();
    }

    public void clickOnDigit_1() {
        controlledElement.shouldBeDisplayed(digit1);
        digit1.click();
    }

    public void clickOnDigit_2() {
        controlledElement.shouldBeDisplayed(digit2);
        digit2.click();
    }

    public void clickOnDigit_3() {
        controlledElement.shouldBeDisplayed(digit3);
        digit3.click();
    }

    public void clickOnDigit_4() {
        controlledElement.shouldBeDisplayed(digit4);
        digit4.click();
    }

    public void clickOnDigit_5() {
        controlledElement.shouldBeDisplayed(digit5);
        digit5.click();
    }

    public void clickOnDigit_6() {
        controlledElement.shouldBeDisplayed(digit6);
        digit6.click();
    }

    public void clickOnDigit_7() {
        controlledElement.shouldBeDisplayed(digit7);
        digit7.click();
    }

    public void clickOnDigit_8() {
        controlledElement.shouldBeDisplayed(digit8);
        digit8.click();
    }

    public void clickOnDigit_9() {
        controlledElement.shouldBeDisplayed(digit9);
        digit9.click();
    }

    public void clickOnAdditionOperation(){
        controlledElement.shouldBeDisplayed(plus);
        plus.click();
    }

    public void clickOnSubtractionOperation(){
        controlledElement.shouldBeDisplayed(minus);
        minus.click();
    }

    public void clickOnMultiplyOperation(){
        controlledElement.shouldBeDisplayed(multiply);
        multiply.click();
    }

    public void clickOnDivideOperation(){
        controlledElement.shouldBeDisplayed(divide);
        divide.click();
    }

    public void clickOnEqualsOperation(){
        controlledElement.shouldBeDisplayed(equals);
        equals.click();
    }

    public String getCalculationResult(){
        MobileElement result = driver.findElementById(FINAL_RESULT);
        return result.getText();
    }

}