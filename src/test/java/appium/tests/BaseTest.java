package appium.tests;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.remote.MobilePlatform;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;

public class BaseTest {
    public AppiumDriver driver = null;
    private URL appiumServerURL = new URL("http://localhost:4723/wd/hub");
    private DesiredCapabilities capabilities = new DesiredCapabilities();
    private String runningPath = System.getProperty("user.dir");
    private String appPath = runningPath+"/apps/app-alpha-debug.apk";

    public BaseTest() throws MalformedURLException {
    }

    @Test
    public void firstTest()
    {
        capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, MobilePlatform.ANDROID);
        capabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, "9");
        capabilities.setCapability(AndroidMobileCapabilityType.AUTO_GRANT_PERMISSIONS, true);
        capabilities.setCapability("newCommandTimeout", 120);
        capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "phone");
        capabilities.setCapability(MobileCapabilityType.APP, appPath);
        capabilities.setCapability(AndroidMobileCapabilityType.APP_ACTIVITY,
                "org.wikipedia.onboarding.InitialOnboardingActivity");
        driver = new AndroidDriver(appiumServerURL, capabilities);
    }
}
