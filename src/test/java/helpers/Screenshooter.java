package helpers;

import io.appium.java_client.AppiumDriver;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;

import java.io.File;
import java.io.IOException;

public class Screenshooter {
    public static void takeScreenshot(AppiumDriver driver){
        File file = driver.getScreenshotAs(OutputType.FILE);

        // the filename is the folder name on test.screenshot.path property plus the completeTestName
        try {
            FileUtils.copyFile(file,
                    new File("screenshot.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
