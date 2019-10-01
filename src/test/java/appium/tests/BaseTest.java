package appium.tests;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.IOSMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class BaseTest {
    public AppiumDriver driver = null;
    private URL appiumServerURL = new URL("http://localhost:4723/wd/hub");
    private DesiredCapabilities capabilities = new DesiredCapabilities();
    private String runningPath = System.getProperty("user.dir");
    private String appPathAndroid = runningPath+"/apps/app-alpha-debug.apk";
    private String appPathIOS = runningPath+"/apps/Wikipedia.app";

    public BaseTest() throws MalformedURLException {
    }

    private void createDriver(String platformName, String udid, String platformVersion){
        capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, platformName);
        capabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, platformVersion);
        capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, udid);
        capabilities.setCapability("newCommandTimeout", 120);


        if(platformName.equals("android")) {
            capabilities.setCapability(AndroidMobileCapabilityType.AUTO_GRANT_PERMISSIONS, true);
            capabilities.setCapability(AndroidMobileCapabilityType.APP_ACTIVITY,
                    "org.wikipedia.onboarding.InitialOnboardingActivity");
            capabilities.setCapability(MobileCapabilityType.APP, appPathAndroid);
            driver = new AndroidDriver(appiumServerURL, capabilities);
        }
        else if (platformName.equals("ios")){
            capabilities.setCapability(MobileCapabilityType.APP, appPathIOS);
            capabilities.setCapability(IOSMobileCapabilityType.AUTO_ACCEPT_ALERTS,
                    true);
            capabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, "XCUITest");
            driver = new IOSDriver(appiumServerURL, capabilities);
        }
        else System.out.println("OOPS, something bad happened with the platform name");

        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    }

    @BeforeMethod(alwaysRun = true)
    @Parameters( {"platform","udid", "platformVersion"} )
    public void setup(@Optional("ios") String platformName,
                      @Optional("iPhone 8")String udid,
                      @Optional("12.0") String platformVersion) {
        createDriver(platformName, udid, platformVersion);
    }

    @AfterMethod(alwaysRun = true)
    public void tearDown()
    {
        driver.quit();
    }
}
