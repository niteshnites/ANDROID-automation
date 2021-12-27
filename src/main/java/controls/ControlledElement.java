package controls;

import driver.BaseDriver;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ControlledElement extends BaseDriver {

    private AppiumDriver<MobileElement> driver;

    public ControlledElement(AppiumDriver<MobileElement> driver) {
        this.driver = driver;
    }

    public void shouldBeDisplayed(MobileElement element) {
        WebDriverWait wait = new WebDriverWait(driver, Integer.parseInt(getProperties().getProperty("timeOut")));
        System.out.println("waiting for element visibilityOf.. " + element.getText());
        long findStart = System.currentTimeMillis();
        wait.until(ExpectedConditions.visibilityOf(element));
        long timeToRetrieveElement = (System.currentTimeMillis() - findStart);
        System.out.println("element " + element.getText() + " is visible in " + timeToRetrieveElement + "ms");
    }
}