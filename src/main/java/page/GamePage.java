package page;

import base.BaseForm;
import browser.Browser;
import element.*;
import model.Email;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import util.RandomUtil;

public class GamePage extends BaseForm {
    private final Button helpBtn = new Button(By.linkText("Help"), "Help button");
    private final Label helpResponse = new Label(By.xpath("//div[@class = 'help-form__response']"), "Help response");
    private final Timer timer = new Timer(By.xpath("//div[@class = 'timer timer--white timer--center']"), "Timer");
    private final Input usernameInput = new Input(By.xpath("//input[@placeholder='Your email']"), "Username input");
    private final Input domainInput = new Input(By.xpath("//input[@placeholder='Domain']"), "Domain input");
    private final Input passwordInput = new Input(By.xpath("//input[@placeholder='Choose Password']"), "Password input");
    private final Label ddLabel = new Label(By.xpath("//div[@class='dropdown__field']"), "Dropdown label");
    private final Checkbox termsCheckbox = new Checkbox(By.xpath("//span[@class='icon icon-check checkbox__check']"), "Terms checkbox");
    private final Button nextBtn = new Button(By.xpath("//a[@class='button--secondary']"), "Next button");
    private final Button resetBtn = new Button(By.xpath("//a[@class='button--secondary u-right']"), "Reset button");

    public GamePage() {
        super(By.xpath("//div[@class='logo__icon']"), "Game page");
    }

    public void clickOnHelpBtn() {
        helpBtn.click();
    }

    public boolean isHelpResponseDisplayed() {
        return helpResponse.isDisplayed();
    }

    public boolean startsFromZero() {
        String t = timer.getText();

        if (t.equals("00:00:00") || t.equals("00:00:01")
                || t.equals("00:00:02") || t.equals("00:00:03")) {
            return true;
        } else {
            return false;
        }
    }

    public void inputRandomValidEmail() {
        WebDriver driver = Browser.getDriver();
        Email email = RandomUtil.getValidEmail();

        usernameInput.sendKeys(email.getUsername());
        domainInput.sendKeys(email.getDomain());

        ddLabel.click();
        driver.findElements(By.cssSelector(".dropdown__list>div")).get(email.getTld()).click();
    }

    public void inputRandomValidPassword() {
        passwordInput.sendKeys(RandomUtil.getValidPassword());
    }

    public void inputRandomInvalidPassword() {
        passwordInput.sendKeys(RandomUtil.getInvalidPassword());
    }

    public void acceptTermsAndConditions() {
        termsCheckbox.click();
    }

    public void clickOnNextBtn() {
        nextBtn.click();
    }

    public void clickOnResetBtn() {
        resetBtn.click();
    }

    public boolean isReset() {
        if (usernameInput.getText().equals("") && domainInput.getText().equals("")
                && ddLabel.getText().equals("other") && passwordInput.getText().equals("")) {
            return true;
        } else {
            return false;
        }
    }
}
