package appium.pageobjects;

import io.appium.java_client.AppiumDriver;

public class SecondOnBoardingPage extends BasePage{

    private String secondOnBoardingPageTitle = "New ways to explore";

    public SecondOnBoardingPage(AppiumDriver driver) {
        super(driver);
    }

    public boolean isSecondOnBoardingPageTitleCorrect() {
        return onBoardingTitle.getText().equals(secondOnBoardingPageTitle);
    }
}
