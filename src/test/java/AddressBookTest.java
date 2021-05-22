import net.bytebuddy.utility.RandomString;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pop.*;

import java.util.concurrent.TimeUnit;

public class AddressBookTest {

    public WebDriver driver;
    public HomePage homePage;
    public SignInPage signInPage;
    public SignUpPage signUpPage;
    public AddressesListPage addressesListPage;
    public NewAddressPage newAddressPage;
    public ShowAddressPage showAddressPage;

    @BeforeClass
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "./src/test/java/data/chromedriver");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.manage().window().maximize();
    }

    @Test
    public void mainTest() {
        String email = RandomString.make(5) + "@upsmail.com";
        String password = "zxcvpoiu1209";
        String[] dane = {"Ania", "Bania", "Cichutka 5", "Ciechocinek", "54300"};
        driver.get("http://a.testaddressbook.com/");
        homePage = new HomePage(driver);
        signInPage = homePage.gotoSignInPage();
        signUpPage = signInPage.goToSignUpLink();
        signUpPage.fillRegisterForm(email, password);
        addressesListPage = homePage.gotoAddressesPage();
        newAddressPage = addressesListPage.goToNewAddressPage();
        showAddressPage = newAddressPage.fillAndSendForm(dane);
        String successText = driver.findElement(By.xpath("//div[@data-test='notice']")).getText();
        Assert.assertEquals(successText, "Address was successfully created.");
    }

    @AfterClass(alwaysRun = true)
    public void tearDown() {
        driver.quit();
    }
}

