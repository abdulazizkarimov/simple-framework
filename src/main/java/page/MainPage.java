package page;

import base.BaseForm;
import element.Link;
import org.openqa.selenium.By;

public class MainPage extends BaseForm {
    private final Link hereLink = new Link(By.linkText("HERE"), "Here link");

    public MainPage() {
        super(By.xpath("//div[@class='logo__icon']"), "Main page");
    }

    public void clickOnHereLink() {
        hereLink.click();
    }
}
