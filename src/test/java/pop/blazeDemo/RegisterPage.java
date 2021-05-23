package pop.blazeDemo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class RegisterPage {

    private WebDriver driver;
    private By name = By.id("name");
    private By company = By.id("company");
    private By email = By.id("email");
    private By password = By.id("password");
    private By confirmPassword = By.id("password-confirm");
    private By button = By.xpath("//button[@type='submit']");

    public RegisterPage(WebDriver driver) {
        this.driver = driver;
    }

    public LoginPage fillAndSendForm(String[] data){
        driver.findElement(name).sendKeys(data[0]);
        driver.findElement(company).sendKeys(data[1]);
        driver.findElement(email).sendKeys(data[2]);
        driver.findElement(password).sendKeys(data[3]);
        driver.findElement(confirmPassword).sendKeys(data[4]);
        driver.findElement(button).click();
        return new LoginPage(driver);
    }
}
