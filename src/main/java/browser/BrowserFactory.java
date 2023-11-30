package browser;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

public class BrowserFactory {
    private Browser browser;

    public BrowserFactory(String driverName) {
        WebDriver driver = chooseDriver(driverName);
        browser = new Browser(driver);
    }

    public Browser getBrowser() {
        return browser;
    }

    private WebDriver chooseDriver(String name) {
        WebDriver driver = null;

        switch (name) {
            case "Chrome":
                ChromeOptions options = new ChromeOptions();
                options.addArguments("--remote-allow-origins=*");
                driver = new ChromeDriver(options);
                break;
            case "Firefox":
                driver = new FirefoxDriver();
                break;
            case "Edge":
                driver = new EdgeDriver();
                break;
            case "Safari":
                driver = new SafariDriver();
                break;
        }

        return driver;
    }
}
