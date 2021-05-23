package pop.shop;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import pop.blazeDemo.LoginPage;

public class HomePage {
    private WebDriver driver;
    @FindBy(className = "login")
    private WebElement login;

    public HomePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public AuthenticationPage goToAuthenticationPage() {
        login.click();
        return new AuthenticationPage(driver);
    }
}
