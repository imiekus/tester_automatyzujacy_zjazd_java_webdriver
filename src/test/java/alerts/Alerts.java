package alerts;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import ru.yandex.qatools.ashot.AShot;
import ru.yandex.qatools.ashot.Screenshot;
import ru.yandex.qatools.ashot.shooting.ShootingStrategies;

import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class Alerts {

    public WebDriver driver;

    @BeforeClass
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "./src/test/java/data/chromedriver");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get("http://testpages.herokuapp.com/styled/alerts/alert-test.html");
    }

    @Test(testName = "Alert", enabled = false)
    public void alertTest() {
        driver.findElement(By.id("alertexamples")).click();
        new WebDriverWait(driver, 5).until(ExpectedConditions.alertIsPresent());
        Alert alert = driver.switchTo().alert();
        String txt = alert.getText();
        Assert.assertEquals(txt, "I am an alert box!");
        alert.accept();
    }

    @Test(enabled = false)
    public void confirmTest() {
        driver.findElement(By.id("confirmexample")).click();
        new WebDriverWait(driver, 5).until(ExpectedConditions.alertIsPresent());
        Alert alert = driver.switchTo().alert();
        alert.accept();
        String result = driver.findElement(By.id("confirmreturn")).getText();
        Assert.assertEquals(result, "true");
        driver.findElement(By.id("confirmexample")).click();
        new WebDriverWait(driver, 5).until(ExpectedConditions.alertIsPresent());
        alert.dismiss();
        String result2 =driver.findElement(By.id("confirmreturn")).getText();
        Assert.assertEquals(result2, "false");
    }

    @Test(enabled = false)
    public void promptTest() {
        driver.findElement(By.id("promptexample")).click();
        new WebDriverWait(driver, 5).until(ExpectedConditions.alertIsPresent());
        Alert alert = driver.switchTo().alert();
        alert.sendKeys("Text");
        alert.accept();
        String result = driver.findElement(By.id("promptreturn")).getText();
        Assert.assertEquals(result, "Text");
    }

    @Test
    public void screenshotTest() {
        driver.get("https://www.onet.pl/");
        Screenshot screenshot = new AShot().shootingStrategy(ShootingStrategies.viewportPasting(500)).takeScreenshot(driver);
        try {
            ImageIO.write(screenshot.getImage(), "jpg", new File("./screenshots/onet.jpg"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @AfterClass(alwaysRun = true)
    public void tearDown() {
        driver.quit();
    }
}
