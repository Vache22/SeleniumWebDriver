package Practice_Example;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class NewTabBrowser {
    public static void main(String[] args) throws InterruptedException {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--user-agent=Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/91.0.4472.124 Safari/537.36");

        WebDriver driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://demo.nopcommerce.com/");
        driver.manage().window().maximize();
        WebElement register = driver.findElement(By.xpath("//a[normalize-space()='Register']"));
        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfAllElements(register));

        Actions act = new Actions(driver);
        try {
            Thread.sleep(2000);  // Sleep for 2 seconds
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


        // click ctrl
        act.keyDown(Keys.COMMAND).click(register).keyUp(Keys.COMMAND).perform();

        // switching to registration page
        List<String> ids = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(ids.get(1));

    }

}
