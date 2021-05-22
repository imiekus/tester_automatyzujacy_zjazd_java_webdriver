package pop;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SignUpPage {
    private WebDriver driver;
    By emailForm = By.id("user_email");
    By passwordForm = By.id("user_password");
    By buttonForm = By.xpath("//input[@name='commit']");


    public SignUpPage(WebDriver driver) {
        this.driver = driver;
    }

    public HomePage fillRegisterForm(String email, String password) {
        driver.findElement(emailForm).sendKeys(email);
        driver.findElement(passwordForm).sendKeys(password);
        driver.findElement(buttonForm).click();
        return new HomePage(driver);
    }
}
