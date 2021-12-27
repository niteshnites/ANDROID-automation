import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class CalculatorTest {

    public static void main(String [] args) throws MalformedURLException {

        // Capabilities for Android automation
        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability(MobileCapabilityType.UDID, "69db29dc");
        caps.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
        caps.setCapability(MobileCapabilityType.PLATFORM_VERSION, "11.0");
        caps.setCapability(MobileCapabilityType.DEVICE_NAME, "OnePlus A6000");

        File file = new File(System.getProperty("user.dir")+"\\src\\main\\resources\\Calculator.apk");
        caps.setCapability(MobileCapabilityType.APP, file.getAbsolutePath());

        caps.setCapability("appPackage", "com.google.android.calculator");
        caps.setCapability("appActivity", "com.android.calculator2.Calculator");

        AppiumDriverLocalService  appiumService = AppiumDriverLocalService.buildDefaultService();
        appiumService.start();
        String appiumServiceUrl = appiumService.getUrl().toString();
        System.out.println(appiumServiceUrl);

        AppiumDriver<MobileElement> driver = new AppiumDriver<>(new URL(appiumServiceUrl), caps);
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

        MobileElement digit_3 = driver.findElement(By.xpath("//android.widget.Button[@text='3']"));
        digit_3.isDisplayed();
        digit_3.click();
        MobileElement digit_6 = driver.findElementById("digit_6");
        digit_6.isDisplayed();

        driver.closeApp();
        appiumService.stop();
    }
}
