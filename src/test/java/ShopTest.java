import net.bytebuddy.utility.RandomString;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pop.shop.AuthenticationPage;
import pop.shop.HomePage;
import pop.shop.UserAccountDashboard;

import java.util.concurrent.TimeUnit;

public class ShopTest {
    public WebDriver driver;
    public HomePage homePage;
    public AuthenticationPage authenticationPage;
    public UserAccountDashboard userAccountDashboard;

    @BeforeClass
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "./src/test/java/data/chromedriver");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.manage().window().maximize();
    }

    @Test
    public void mainTest() {
        String[] data = new String[8];
        data[0] = "Ania";
        data[1] = "Bania";
        data[2] = "Password12345";
        data[3] = "Cichutka 500";
        data[4] = "New York";
        data[5] = "New York";
        data[6] = "38122";
        data[7] = "337890654";
        String email = RandomString.make(5) + "@upsmail.com";
        driver.get("http://automationpractice.com/index.php");
        homePage = new HomePage(driver);
        authenticationPage= homePage.goToAuthenticationPage();
        authenticationPage.fillAndSendEmail(email);
        userAccountDashboard = authenticationPage.fillAndSendRegisterForm(data);
        userAccountDashboard.checkMyAccountInfoExists();
    }

    @AfterClass(alwaysRun = true)
    public void tearDown() {
        driver.quit();
    }
}
