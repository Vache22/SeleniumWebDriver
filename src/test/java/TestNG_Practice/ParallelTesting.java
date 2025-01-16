package TestNG_Practice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.time.Duration;

public class ParallelTesting {

    WebDriver driver;
    @BeforeClass
    @Parameters({"browser"})
    void setup(String br){
        switch (br){
            case "chrome": driver = new ChromeDriver();
            break;
            case "edge": driver = new EdgeDriver();
            break;
            case "firefox": driver = new FirefoxDriver();
            break;
            default:
                System.out.println("Invalid Browser");
                return;
        }
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
    }
    @Test(priority = 1)
    void testLogo(){
        boolean status = driver.findElement(By.xpath("//div[@class='orangehrm-login-branding']")).isDisplayed();
        Assert.assertTrue(status);
    }
    @Test(priority = 2)
    void testTitle(){
        Assert.assertEquals(driver.getTitle(),"OrangeHRM");
    }
    @Test(priority = 3)
    void testURL(){
        Assert.assertEquals(driver.getCurrentUrl(),"https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");

    }
    @AfterClass
    void tearDown(){
        driver.quit();
    }


}
