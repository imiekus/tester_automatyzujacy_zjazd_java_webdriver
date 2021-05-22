package pop;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage {
    private WebDriver driver;
    private By loginLink = By.id("sign-in");

    public HomePage(WebDriver driver) {
        this.driver = driver;
    }

    public SignInPage gotoSignInPage() {
        driver.findElement(loginLink).click();
        return new SignInPage(driver);
    }
}
