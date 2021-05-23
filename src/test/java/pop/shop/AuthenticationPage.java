package pop.shop;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.FindBy;

public class AuthenticationPage {

    private WebDriver driver;
    @FindBy(id = "email_create")
    private WebElement emailCreate;
    @FindBy(id = "SubmitCreate")
    private WebElement submit;

    public AuthenticationPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void fillAndSendEmail(String email) {
        emailCreate.sendKeys(email);
        submit.click();
    }

}
