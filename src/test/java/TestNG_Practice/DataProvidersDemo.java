package TestNG_Practice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.time.Duration;

public class DataProvidersDemo {
    WebDriver driver;

    @BeforeClass
    void setup() {
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

    }

    @Test(dataProvider = "dp")
    void testLogin(String email, String pwd) throws InterruptedException {
        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
        driver.manage().window().maximize();
        driver.findElement(By.xpath("//input[@placeholder='Username']")).sendKeys(email);
        driver.findElement(By.xpath("//input[@placeholder='Password']")).sendKeys(pwd);
        driver.findElement(By.xpath("//button[normalize-space()='Login']")).click();
        Thread.sleep(2000);
        boolean status = driver.findElement(By.xpath("//h6[normalize-space()='Dashboard']")).isDisplayed();
        if (status == true) {
            driver.findElement(By.xpath("//img[@class='oxd-userdropdown-img']")).click();
            driver.findElement(By.xpath("//a[normalize-space()='Logout']")).click();
            Assert.assertTrue(true);
        } else {
            Assert.fail();
        }

    }

    @AfterClass
    void tearDown() {
        driver.close();
    }

    @DataProvider(name = "dp",indices = {1})
    Object[][] loginData() {
        Object[][] data = {
                {"test1@gmail.com", "Test12"},
                {"Admin", "admin123"},
                {"test2@gmail.com", "test21"},};
        return data;

    }
}