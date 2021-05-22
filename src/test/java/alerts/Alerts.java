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

    @Test(testName = "Alert")
    public void alertTest() {
        driver.findElement(By.id("alertexamples")).click();
        new WebDriverWait(driver, 5).until(ExpectedConditions.alertIsPresent());
        Alert alert = driver.switchTo().alert();
        String txt = alert.getText();
        Assert.assertEquals(txt, "I am an alert box!");
        alert.accept();
    }

    @Test
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

    @Test
    public void promptTest() {
        driver.findElement(By.id("promptexample")).click();
        new WebDriverWait(driver, 5).until(ExpectedConditions.alertIsPresent());
        Alert alert = driver.switchTo().alert();
        alert.sendKeys("Text");
        alert.accept();
        String result = driver.findElement(By.id("promptreturn")).getText();
        Assert.assertEquals(result, "Text");


    }

    @AfterClass(alwaysRun = true)
    public void tearDown() {
        driver.quit();
    }
}
