package pop;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AddressesListPage {
    private WebDriver driver;
//    By newAddressLink = By.linkText("New Address");
    By newAddressLink = By.xpath("//a[@data-test='create']");

    public AddressesListPage(WebDriver driver) {
        this.driver = driver;
    }

    public NewAddressPage goToNewAddressPage() {
        driver.findElement(newAddressLink).click();
        return new NewAddressPage(driver);
    }
}
