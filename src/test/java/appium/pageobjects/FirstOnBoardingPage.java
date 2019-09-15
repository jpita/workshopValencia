package appium.pageobjects;

import io.appium.java_client.AppiumDriver;

public class FirstOnBoardingPage extends BasePage{

    private String firstOnBoardingPageTitle = "The Free Encyclopedia\n" +
            "…in over 300 languages";
    public FirstOnBoardingPage(AppiumDriver driver) {
        super(driver);
    }

    public Boolean isFirstOnBoardingPageTitleCorrect(){
        return onBoardingTitle.getText().equals(firstOnBoardingPageTitle);
    }
}
