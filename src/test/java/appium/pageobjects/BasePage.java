package appium.pageobjects;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class BasePage {

    private final AppiumDriver driver;
    @AndroidFindBy(id = "org.wikipedia.alpha:id/fragment_onboarding_forward_button")
    protected MobileElement nextPageButton;

    @FindBy(id = "org.wikipedia.alpha:id/view_onboarding_page_image_centered")
    protected MobileElement onBoardingImage;

    @FindBy(id = "org.wikipedia.alpha:id/view_onboarding_page_primary_text")
    protected MobileElement onBoardingTitle;

    public BasePage(AppiumDriver driver){
        this.driver=driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    public Boolean checkForOnBoardingImagePresence(){
        return onBoardingImage.isDisplayed();
    }

    public SecondOnBoardingPage tapNextPageButton(){
        nextPageButton.click();
        return new SecondOnBoardingPage(driver);
    }

}
