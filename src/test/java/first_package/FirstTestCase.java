package first_package;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class FirstTestCase {

    public static void main(String[] args)  {
        WebDriver driver = new ChromeDriver();
        // explicit wait -> what we use daily
        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));

        // implicit wait
        //driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

        // Get url of webPage
        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
        driver.manage().window().maximize();

        //driver.findElement(By.xpath("//input[@placeholder='Username']")).sendKeys("some");
      WebElement userName=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@placeholder='Username']")));
      userName.sendKeys("Admin");

      WebElement password = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@placeholder='Password']")));
      password.sendKeys("admin123");

      WebElement loginBtn = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"app\"]/div[1]/div/div[1]/div/div[2]/div[2]/form/div[3]/button")));
      loginBtn.click();

    }
}
