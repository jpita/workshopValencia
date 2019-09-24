package appium.tests;

import appium.pageobjects.FirstOnBoardingPage;
import appium.pageobjects.SecondOnBoardingPage;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.net.MalformedURLException;

public class OnBoardingTests extends BaseTest{
    public OnBoardingTests() throws MalformedURLException {
    }

    @Test
    public void checkOnBoardingTest(){
        FirstOnBoardingPage firstOnBoardingPage = new FirstOnBoardingPage(driver);
        Assert.assertTrue(firstOnBoardingPage.checkForOnBoardingImagePresence(),
                "OOPS! image is not showing");
        Assert.assertTrue(firstOnBoardingPage.isFirstOnBoardingPageTitleCorrect(),
                "OOPS! title is not correct");
        SecondOnBoardingPage secondOnBoardingPage = firstOnBoardingPage.tapNextPageButton();
        Assert.assertTrue(secondOnBoardingPage.checkForOnBoardingImagePresence(),
                "OOPS! image is not showing");
        Assert.assertTrue(secondOnBoardingPage.isSecondOnBoardingPageTitleCorrect(),
                "OOPS! title is not correct");
    }
}