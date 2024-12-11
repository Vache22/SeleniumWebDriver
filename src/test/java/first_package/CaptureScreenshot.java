package first_package;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.File;
import java.time.Duration;

public class CaptureScreenshot {
    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        driver.manage().window().maximize();
        driver.get("https://vitamini.ge/");

        /* 1. full page screenshot
        TakesScreenshot ts = (TakesScreenshot) driver;
        File sourceFile = ts.getScreenshotAs(OutputType.FILE);
        File targetFile = new File(System.getProperty("user.dir")+"/screenshots/fullpage.png");
        sourceFile.renameTo(targetFile); // copy source file to target file */

        // 2. capture screenshot from specific section/element
        WebElement featuredProducts = driver.findElement(By.xpath("//body/div[@class='website-wrapper']/div[@class='main-page-wrapper']/div[@class='container']/div[@class='row content-layout-wrapper align-items-start']/div[@role='main']/article[@id='post-57']/div[@class='entry-content']/div[4]/div[1]/div[1]/div[1]"));
        File sourceFile = featuredProducts.getScreenshotAs(OutputType.FILE);
        File targetFile = new File(System.getProperty("user.dir")+"/screenshots/section.png");
        sourceFile.renameTo(targetFile);
        driver.quit();
    }
}
