package pop;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SignInPage {
    private WebDriver driver;
    public By signUpLink = By.linkText("Sign up");

    public SignInPage(WebDriver driver) {
        this.driver = driver;
    }

    public SignUpPage goToSignUpLink() {
        driver.findElement(signUpLink).click();
        return new SignUpPage(driver);
    }
}