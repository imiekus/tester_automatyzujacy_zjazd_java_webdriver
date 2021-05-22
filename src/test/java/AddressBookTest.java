import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pop.HomePage;
import pop.SignInPage;

import java.util.concurrent.TimeUnit;

public class AddressBookTest {

    public WebDriver driver;
    public HomePage homePage;
    public SignInPage signInPage;

    @BeforeClass
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "./src/test/java/data/chromedriver");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.manage().window().maximize();
    }

    @Test
    public void mainTest() {
        driver.get("http://a.testaddressbook.com/");
        homePage = new HomePage(driver);
        signInPage = homePage.gotoSignInPage();
    }

    @AfterClass(alwaysRun = true)
    public void tearDown() {
        driver.quit();
    }
}

