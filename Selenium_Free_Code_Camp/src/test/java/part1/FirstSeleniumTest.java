package part1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class FirstSeleniumTest {

    // WebDriver is a interface
    // driver is a object reference
    // Purpose of WebDriver is to  control a web browser.
    WebDriver driver;

    @BeforeClass
    public void setUp() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
    }

    @AfterClass

    public void tearDown() {
        driver.quit();
    }

    @Test
    public void testLogin() throws InterruptedException {
        Thread.sleep(2000);
        WebElement username = driver.findElement(By.name("username"));
        username.sendKeys("Admin");

        var password = driver.findElement(By.name("password"));
        password.sendKeys("admin123");

        // Without Using the Object Reference
        driver.findElement(By.tagName("button")).click();

        Thread.sleep(2000);
        String actualResult = driver.findElement((By.tagName("h6"))).getText();
        String expectedResult = "Dashboard";

        Assert.assertEquals(actualResult, expectedResult);
        // If we need to fail test on purpose we can use
        // Assert.assertNotEquals(actualResult, expectedResult);
    }

}

// Difference Between driver.quite() and driver.close()
// driver.quite() - Close the browser
// driver.close() - Close the current window
// By is a class to Find the element, there are total 8 locator in selenium
