package pop;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class NewAddressPage {
    private WebDriver driver;
    private By name = By.id("address_first_name");
    private By surname = By.id("address_last_name");
    private By address1 = By.id("address_street_address");
    private By city = By.id("address_city");
    private By zip = By.id("address_zip_code");
    private By button = By.xpath("//input[@name='commit']");

    public NewAddressPage(WebDriver driver) {
        this.driver = driver;
    }

    public ShowAddressPage fillAndSendForm(String[] dane) {
        driver.findElement(name).sendKeys(dane[0]);
        driver.findElement(surname).sendKeys(dane[1]);
        driver.findElement(address1).sendKeys(dane[2]);
        driver.findElement(city).sendKeys(dane[3]);
        driver.findElement(zip).sendKeys(dane[4]);
        driver.findElement(button).click();
        return new ShowAddressPage(driver);
    }
}
