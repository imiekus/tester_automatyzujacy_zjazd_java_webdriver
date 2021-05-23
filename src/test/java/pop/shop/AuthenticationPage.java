package pop.shop;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AuthenticationPage {

    private WebDriver driver;
    @FindBy(id = "email_create")
    private WebElement emailCreate;
    @FindBy(id = "SubmitCreate")
    private WebElement registerButton;
    @FindBy(id = "account-creation_form")
    private WebElement registerForm;
    @FindBy(id = "customer_firstname")
    private WebElement firstName;
    @FindBy(id = "customer_lastname")
    private WebElement lastName;
    @FindBy(id = "passwd")
    private WebElement password;
    @FindBy(id = "address1")
    private WebElement address1;
    @FindBy(id = "city")
    private WebElement city;
    @FindBy(id = "id_state")
    private WebElement state;
    @FindBy(id = "postcode")
    private WebElement postcode;
    @FindBy(id = "id_country")
    private WebElement country;
    @FindBy(id = "phone_mobile")
    private WebElement phone;
    @FindBy(id = "submitAccount")
    private WebElement submitButton;

    public AuthenticationPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void fillAndSendEmail(String email) {
        emailCreate.sendKeys(email);
        registerButton.click();
        new WebDriverWait(driver, 5).until(ExpectedConditions.visibilityOf(registerForm));
    }

    public UserAccountDashboard fillAndSendRegisterForm(String[] data) {
        firstName.sendKeys(data[0]);
        lastName.sendKeys(data[1]);
        password.sendKeys(data[2]);
        address1.sendKeys(data[3]);
        city.sendKeys(data[4]);
        new Select(state).selectByVisibleText(data[5]);
        postcode.sendKeys(data[6]);
        phone.sendKeys(data[7]);
        submitButton.click();
        return new UserAccountDashboard(driver);
    }

}
