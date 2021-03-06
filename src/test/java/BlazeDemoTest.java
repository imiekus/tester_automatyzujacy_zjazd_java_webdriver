import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pop.blazeDemo.LoginPage;
import pop.blazeDemo.RegisterPage;
import sun.rmi.runtime.Log;

import java.util.concurrent.TimeUnit;

public class BlazeDemoTest {

    public WebDriver driver;
    public LoginPage loginPage;
    public RegisterPage registerPage;

    @BeforeClass
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "./src/test/java/data/chromedriver");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.manage().window().maximize();
    }

    @Test
    @Parameters({"name", "company", "email", "passwd"})
    public void mainTest(String name, String company, String email, String passwd) {
        String[] dane = new String[5];
        dane[0] = name;
        dane[1] = company;
        dane[2] = email;
        dane[3] = passwd;
        dane[4] = passwd;
//        String[] dane = {"Ania", "CDV", "randjij2ejsgnq@randjejwj.com", "password1234!", "password1234!"}; // after data-driven was introduced
        loginPage = new LoginPage(driver);
        driver.get("https://blazedemo.com/login");
        registerPage = loginPage.goToRegisterLink();
        loginPage = registerPage.fillAndSendForm(dane);
        String message = driver.findElement(By.className("message")).getText();
        Assert.assertEquals(message, "Page Expired"); // sometimes works like this, sometimes goes to login page, sometimes to dashboard...
    }

    @AfterClass(alwaysRun = true)
    public void tearDown() {
        driver.quit();
    }
}
