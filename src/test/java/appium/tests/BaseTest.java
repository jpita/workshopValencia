package appium.tests;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

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

    private void createDriver(){
        //Set the Desired Capabilities
        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability("deviceName", "My Phone");
        caps.setCapability("platformName", "Android");
        caps.setCapability("platformVersion", "9");
        caps.setCapability("browserName", "Chrome");
        caps.setCapability("noReset", true);

        //Set ChromeDriver location
        //System.setProperty("webdriver.chrome.driver",runningPath+"/chromedriver264");

        //Instantiate Appium Driver
        AppiumDriver<MobileElement> driver = null;
        try {
            driver = new AndroidDriver<MobileElement>(new URL("http://0.0.0.0:4723/wd/hub"), caps);

        } catch (MalformedURLException e) {
            System.out.println(e.getMessage());
        }

        //Open URL in Chrome Browser
        driver.get("https://www.google.com/search?q=something+wikipedia");
        driver.findElement(By.cssSelector("#rso > div:nth-child(1) > div:nth-child(1) > div > div > div.jGGQ5e > div > a > div.zlBHuf.MUxGbd.v0nnCb")).click();
//        capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, MobilePlatform.ANDROID);
//        capabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, "9");
//        capabilities.setCapability(AndroidMobileCapabilityType.AUTO_GRANT_PERMISSIONS, true);
//        capabilities.setCapability("newCommandTimeout", 120);
//        capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "phone");
//        capabilities.setCapability(MobileCapabilityType.APP, appPath);
//        capabilities.setCapability(AndroidMobileCapabilityType.APP_ACTIVITY,
//                "org.wikipedia.onboarding.InitialOnboardingActivity");
//        driver = new AndroidDriver(appiumServerURL, capabilities);
    }

    @BeforeMethod
    public void setup()
    {
        createDriver();
    }

    @AfterMethod
    public void tearDown()
    {
        driver.quit();
    }
}
