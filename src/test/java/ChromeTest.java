import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class ChromeTest {
    public static void main(String [] args) throws MalformedURLException {

        // Capabilities for Android automation
        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
        caps.setCapability(MobileCapabilityType.UDID, "69db29dc");
        caps.setCapability(MobileCapabilityType.DEVICE_NAME, "OnePlus A6000");
        caps.setCapability(MobileCapabilityType.PLATFORM_VERSION, "11.0");

        caps.setCapability(MobileCapabilityType.BROWSER_NAME, "Chrome");

        AppiumDriverLocalService appiumService = AppiumDriverLocalService.buildDefaultService();
        appiumService.start();
        String appiumServiceUrl = appiumService.getUrl().toString();
        System.out.println(appiumServiceUrl);

        AppiumDriver<WebElement>driver = new AndroidDriver<>(new URL(appiumServiceUrl), caps);
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);

        driver.get("https://www.calculator.net/scientific-calculator.html");

        WebElement digit_5 = driver.findElement(By.xpath("//span[@class='scinm' ][text()='5']"));
        digit_5.click();

        WebElement factorial = driver.findElement(By.xpath("//span[@class='scifunc' ][text()='n!']"));
        factorial.click();

        WebElement output = driver.findElement(By.cssSelector("#sciOutPut"));
        String result = output.getText().trim();
        Assert.assertEquals(result, "120");

        driver.close();
        appiumService.stop();
    }
}
