import base.BaseTest;
import browser.Browser;
import org.testng.Assert;
import org.testng.annotations.Test;
import page.GamePage;
import page.MainPage;
import page.SecondCardPage;

public class MyTest extends BaseTest {

    @Test
    public void helpFormTest() {
        Browser.navigateToHost();
        MainPage mainPage = new MainPage();
        Assert.assertTrue(mainPage.isOpen(), "Main page is not open");

        mainPage.clickOnHereLink();
        GamePage gamePage = new GamePage();
        Assert.assertTrue(gamePage.isOpen(), "Game page is not open");

        gamePage.clickOnHelpBtn();
        Assert.assertTrue(gamePage.isHelpResponseDisplayed(), "Help response is not displayed");
    }

    @Test
    public void timerTest() {
        Browser.navigateToHost();
        MainPage mainPage = new MainPage();
        Assert.assertTrue(mainPage.isOpen(), "Main page is not open");

        mainPage.clickOnHereLink();
        GamePage gamePage = new GamePage();
        Assert.assertTrue(gamePage.isOpen(), "Game page is not open");

        Assert.assertTrue(gamePage.startsFromZero(),"Timer does not start from zero");
    }

    @Test
    public void validPasswordTest() {
        Browser.navigateToHost();
        MainPage mainPage = new MainPage();
        Assert.assertTrue(mainPage.isOpen(), "Main page is not open");

        mainPage.clickOnHereLink();
        GamePage gamePage = new GamePage();
        Assert.assertTrue(gamePage.isOpen(), "Game page is not open");

        gamePage.inputRandomValidEmail();
        gamePage.inputRandomValidPassword();
        gamePage.acceptTermsAndConditions();
        gamePage.clickOnNextBtn();

        SecondCardPage cardPage = new SecondCardPage();
        Assert.assertTrue(cardPage.isOpen(), "Second card is not open");
    }

    @Test
    public void invalidPasswordTest() {
        Browser.navigateToHost();
        MainPage mainPage = new MainPage();
        Assert.assertTrue(mainPage.isOpen(), "Main page is not open");

        mainPage.clickOnHereLink();
        GamePage gamePage = new GamePage();
        Assert.assertTrue(gamePage.isOpen(), "Game page is not open");

        gamePage.inputRandomValidEmail();
        gamePage.inputRandomInvalidPassword();
        gamePage.acceptTermsAndConditions();
        gamePage.clickOnNextBtn();

        SecondCardPage cardPage = new SecondCardPage();
        Assert.assertFalse(cardPage.isOpen(), "Second card is open");
    }

    @Test
    public void resetButtonTest() {
        Browser.navigateToHost();
        MainPage mainPage = new MainPage();
        Assert.assertTrue(mainPage.isOpen(), "Main page is not open");

        mainPage.clickOnHereLink();
        GamePage gamePage = new GamePage();
        Assert.assertTrue(gamePage.isOpen(), "Game page is not open");

        gamePage.inputRandomValidEmail();
        gamePage.inputRandomValidPassword();
        gamePage.clickOnResetBtn();

        Assert.assertTrue(gamePage.isReset(), "Game page is reset");
    }
}
