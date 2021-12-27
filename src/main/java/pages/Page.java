package pages;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;

public abstract class Page {
    AppiumDriver<MobileElement> driver;

    public Page(AppiumDriver<MobileElement> driver){
        this.driver = driver;
    }
}
