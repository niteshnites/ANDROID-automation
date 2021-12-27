package driver;

import java.net.URL;
import java.io.File;
import java.util.Map;
import java.util.HashMap;
import java.util.Properties;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.BeforeClass;
import org.openqa.selenium.remote.DesiredCapabilities;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.service.local.AppiumDriverLocalService;

public class BaseDriver extends Loader {
    public AppiumDriver <MobileElement> driver;
    private int timeOut;
    private String appPath;
    private String deviceName;
    private String platformName;
    private String appPackage;
    private String appActivity;
    private String orientation;
    private String automationName;
    private String appiumServiceUrl;
    static AppiumDriverLocalService appiumService;
    private static final Map<Long, AppiumDriver> runningDrivers = new HashMap<>();
    final static ThreadLocal<AppiumDriver> singleSharedDriver = new ThreadLocal<>();

    /**
     * Method to set Base Driver
     * @return Driver
     */
    @BeforeClass(alwaysRun = true)
    @Parameters({"udid","systemPort","platformVersion"})
    public void setBaseDriver(String udid, String systemPort, String platformVersion) {
        setAppiumDriver(new BaseDriver(getProperties()).loadDriver(udid, systemPort, platformVersion));
    }

    public BaseDriver(Properties properties) {
        this.appPath = properties.getProperty("appPath");
        this.appPackage = properties.getProperty("appPackage");
        this.appActivity = properties.getProperty("appActivity");
        this.orientation = properties.getProperty("orientation");
        this.platformName = properties.getProperty("platformName");
        this.automationName = properties.getProperty("automationName");
        this.appiumServiceUrl = properties.getProperty("appiumServiceUrl");
        this.timeOut = Integer.parseInt(properties.getProperty("timeOut"));
    }

    public BaseDriver() {

    }

    public AppiumDriver<MobileElement> loadDriver(String udid, String systemPort, String platformVersion) {
        appiumService = AppiumDriverLocalService.buildDefaultService();
        appiumService.clearOutPutStreams();
        appiumService.start();
        appiumServiceUrl = appiumService.getUrl().toString();
        return loadLocalAndroidDriver(appiumServiceUrl,udid,systemPort,platformVersion);
    }


    private AppiumDriver<MobileElement> loadLocalAndroidDriver(String url, String udid, String systemPort, String platformVersion ) {
        try {
            DesiredCapabilities caps = new DesiredCapabilities();
            caps.setCapability(MobileCapabilityType.UDID, udid);
            caps.setCapability("appPackage", appPackage);
            caps.setCapability("appActivity", appActivity);
            caps.setCapability("resetKeyboard", true);
            caps.setCapability("unicodeKeyboard", true);
            caps.setCapability(MobileCapabilityType.NO_RESET, false);
            caps.setCapability(MobileCapabilityType.DEVICE_NAME, deviceName);
            caps.setCapability(MobileCapabilityType.ORIENTATION, orientation);
            caps.setCapability(MobileCapabilityType.PLATFORM_NAME, platformName);
            caps.setCapability(AndroidMobileCapabilityType.SYSTEM_PORT,systemPort);
            caps.setCapability(MobileCapabilityType.AUTOMATION_NAME, automationName);
            caps.setCapability(MobileCapabilityType.PLATFORM_VERSION, platformVersion);

            File file = new File(appPath);
            caps.setCapability(MobileCapabilityType.APP, file.getAbsolutePath());

            singleSharedDriver.set(new AppiumDriver<>(new URL(url), caps));
            runningDrivers.put(Thread.currentThread().getId(), singleSharedDriver.get());
            return driver = singleSharedDriver.get();

        } catch (Exception e) {
            System.out.println("INFO: try to load Local Android Driver");
            return null;
        }
    }

    /**
     * Method to Set Appium Driver Instance
     *
     * @param driver driver
     */
    protected void setAppiumDriver(AppiumDriver<MobileElement> driver) {
        this.driver = driver;
    }

    /**
     * Method to get Driver Instance
     *
     * @return driver
     */
    public AppiumDriver<MobileElement> getDriver() {
        return this.driver;
    }


    /**
     * Method to stop driver
     */
    @AfterMethod
    public void stopBaseDriver() {
        if(driver != null) {
            driver.quit();
        }
    }

    /**
     * Method to stop appium service
     */
    @AfterClass
    public void stopAppiumService() {
        appiumService.stop();
    }
}
