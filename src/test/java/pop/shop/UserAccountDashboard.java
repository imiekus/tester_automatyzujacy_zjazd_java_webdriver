package pop.shop;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

public class UserAccountDashboard {

    private WebDriver driver;
    @FindBy(className = "info-account")
    private WebElement accountWelcome;


    public UserAccountDashboard(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void checkMyAccountInfoExists() {
        String text = accountWelcome.getText();
        Assert.assertEquals(text, "Welcome to your account. Here you can manage all of your personal information and orders.");
    }

}
