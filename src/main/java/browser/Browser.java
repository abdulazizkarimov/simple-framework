package browser;

import manager.DataManager;
import org.openqa.selenium.WebDriver;

public class Browser {
    private static WebDriver driver;
    private static Waits waits;

    public Browser(WebDriver driver) {
        this.driver = driver;
        waits = new Waits();
    }

    public static WebDriver getDriver() {
        return driver;
    }

    public static Waits getWaits() {
        return waits;
    }

    public static void navigateToHost() {
        driver.get(DataManager.getProperty("host_url"));
    }
}
