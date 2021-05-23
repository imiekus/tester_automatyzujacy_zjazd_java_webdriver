import net.bytebuddy.utility.RandomString;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pop.shop.AuthenticationPage;
import pop.shop.HomePage;

import java.util.concurrent.TimeUnit;

public class ShopTest {
    public WebDriver driver;
    public HomePage homePage;
    public AuthenticationPage authenticationPage;

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
        driver.get("http://automationpractice.com/index.php");
        homePage = new HomePage(driver);
        authenticationPage= homePage.goToAuthenticationPage();
        authenticationPage.fillAndSendEmail(email);
    }

    @AfterClass(alwaysRun = true)
    public void tearDown() {
        driver.quit();
    }
}
