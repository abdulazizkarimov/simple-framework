package base;

import browser.Browser;
import browser.BrowserFactory;
import manager.DataManager;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

public abstract class BaseTest {
    private WebDriver driver;

    @BeforeTest
    public void init() {
        BrowserFactory factory
                = new BrowserFactory(DataManager.getProperty("browser"));
        driver = Browser.getDriver();
        driver.manage().window().maximize();
    }

    @AfterTest
    public void destroy() {
        driver.quit();
    }
}
