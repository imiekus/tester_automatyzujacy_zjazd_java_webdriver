package pop.blazeDemo;

//import org.openqa.selenium.By; // before Page Factory was introduced
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

    private WebDriver driver;
//    private By registerLink = By.linkText("Register"); // before Page Factory was introduced
    @FindBy(linkText = "Register")
    @CacheLookup
    private WebElement registerLink;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public RegisterPage goToRegisterLink() {
//        driver.findElement(registerLink).click(); // before Page Factory was introduced
        registerLink.click();
        return new RegisterPage(driver);
    }
}
