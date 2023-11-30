package page;

import base.BaseForm;
import org.openqa.selenium.By;

public class SecondCardPage extends BaseForm {
    public SecondCardPage() {
        super(By.xpath("//div[@class='avatar-and-interests__avatar-box']"), "Second card page");
    }
}
