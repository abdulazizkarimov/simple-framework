package base;

import browser.Browser;
import browser.Waits;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public abstract class BaseForm {
    private By elemLocator;
    private String name;
    private WebDriver driver;
    private Waits waits;

    protected BaseForm(By elemLocator, String name) {
        this.elemLocator = elemLocator;
        this.name = name;
        driver = Browser.getDriver();
        waits = Browser.getWaits();
    }

    public boolean isOpen() {
        if(driver.findElements(elemLocator).isEmpty()) {
            return false;
        } else {
            return true;
        }
    }
}
