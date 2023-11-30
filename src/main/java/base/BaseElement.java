package base;

import browser.Browser;
import browser.Waits;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public abstract class BaseElement {
    private By locator;
    private String name;
    private WebDriver driver;
    private Waits waits;

    protected BaseElement(By locator, String name) {
        this.locator = locator;
        this.name = name;
        driver = Browser.getDriver();
        waits = Browser.getWaits();
    }

    public void click() {
        WebElement element = waits.waitForToBeClickable(locator);
        element.click();
    }

    public boolean isDisplayed() {
        WebElement element = waits.waitForToBeDisplayed(locator);
        return element.isDisplayed();
    }

    public String getText() {
        WebElement element = waits.waitForToBeDisplayed(locator);
        return element.getText();
    }

    public void sendKeys(String str) {
        WebElement element = waits.waitForToBeDisplayed(locator);
        element.clear();
        element.sendKeys(str);
    }
}
