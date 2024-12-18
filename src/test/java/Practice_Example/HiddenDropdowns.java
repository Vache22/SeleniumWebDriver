package Practice_Example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class HiddenDropdowns {
    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));

        // implicit wait
        //driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

        // Get url of webPage
        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php");
        driver.manage().window().maximize();

        //driver.findElement(By.xpath("//input[@placeholder='Username']")).sendKeys("some");
        WebElement userName=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@placeholder='Username']")));
        userName.sendKeys("Admin");

        WebElement password = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@placeholder='Password']")));
        password.sendKeys("admin123");

        WebElement loginBtn = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"app\"]/div[1]/div/div[1]/div/div[2]/div[2]/form/div[3]/button")));
        loginBtn.click();

        WebElement pim = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[normalize-space()='PIM']")));
        pim.click();

        // clicked on dropdown

       WebElement title =  wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//body/div[@id='app']/div[@class='oxd-layout orangehrm-upgrade-layout']/div[@class='oxd-layout-container']/div[@class='oxd-layout-context']/div[@class='orangehrm-background-container']/div[@class='oxd-table-filter']/div[@class='oxd-table-filter-area']/form[@class='oxd-form']/div[@class='oxd-form-row']/div[@class='oxd-grid-4 orangehrm-full-width-grid']/div[6]/div[1]/div[2]/div[1]/div[1]")));
       title.click();
        //select single
        driver.findElement(By.xpath("//span[normalize-space()='Finance Manager']")).click();
        WebElement titlelist = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[normalize-space()='Finance Manager']")));
        titlelist.click();
    }
}
