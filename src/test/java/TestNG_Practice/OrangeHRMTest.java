package TestNG_Practice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import java.time.Duration;
@Listeners(TestNG_Practice.ExtentReportManager.class)
public class OrangeHRMTest {
    WebDriver driver;
    @Test(priority = 1)
    void openApp(){
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
        driver.manage().window().maximize();
    }

    @Test(priority = 2, groups = {"smoke"})
    void testLogo(){
        boolean status = driver.findElement(By.xpath("//img[@alt='company-branding']")).isDisplayed();
        System.out.println("logo displayed: "+ status);
    }

    @Test(priority = 3, groups = {"regression"})
    void testLogin(){
        driver.findElement(By.xpath("//input[@placeholder='Username']")).sendKeys("Admin");
        driver.findElement(By.xpath("//input[@placeholder='Password']")).sendKeys("admin123");
        driver.findElement(By.xpath("//button[normalize-space()='Login']")).click();
        

    }

    @Test(priority = 4)
    void closeApp(){
        driver.quit();
    }
}
