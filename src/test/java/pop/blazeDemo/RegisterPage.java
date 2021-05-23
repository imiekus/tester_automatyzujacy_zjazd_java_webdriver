package pop.blazeDemo;

//import org.openqa.selenium.By; // before Page Factory was introduced
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RegisterPage {

    private WebDriver driver;
//    private By name = By.id("name"); // before Page Factory was introduced
//    private By company = By.id("company");
//    private By email = By.id("email");
//    private By password = By.id("password");
//    private By confirmPassword = By.id("password-confirm");
//    private By button = By.xpath("//button[@type='submit']");
    @FindBy(id = "name")
    private WebElement name;
    @FindBy(id = "company")
    private WebElement company;
    @FindBy(id = "email")
    private WebElement email;
    @FindBy(id = "password")
    private WebElement password;
    @FindBy(id = "password-confirm")
    private WebElement confirmPassword;
    @FindBy(xpath = "//button[@type='submit']")
    private WebElement button;

    public RegisterPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public LoginPage fillAndSendForm(String[] data){
        name.sendKeys(data[0]);
        company.sendKeys(data[1]);
        email.sendKeys(data[2]);
        password.sendKeys(data[3]);
        confirmPassword.sendKeys(data[4]);
        button.click();
//        driver.findElement(name).sendKeys(data[0]); // before Page Factory was introduced
//        driver.findElement(company).sendKeys(data[1]);
//        driver.findElement(email).sendKeys(data[2]);
//        driver.findElement(password).sendKeys(data[3]);
//        driver.findElement(confirmPassword).sendKeys(data[4]);
//        driver.findElement(button).click();
        return new LoginPage(driver);
    }
}
