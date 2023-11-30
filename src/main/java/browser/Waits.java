package browser;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Waits {
    private WebDriverWait wait;

    public Waits() {
        wait = new WebDriverWait(
                Browser.getDriver(), Duration.ofSeconds(10));
    }

    public WebElement waitForToBeClickable(By locator) {
        return wait.until(
                ExpectedConditions.elementToBeClickable(locator));
    }

    public WebElement waitForToBeDisplayed(By locator) {
        return wait.until(
                ExpectedConditions.visibilityOfElementLocated(locator));
    }
}
