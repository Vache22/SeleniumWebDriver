package Practice_Example;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class ScrollIntoPage {
    public static void main(String[] args) throws InterruptedException {
        ChromeDriver driver = new ChromeDriver();
        driver.get("https://www.vitamini.ge/");
        driver.manage().window().maximize();

        WebElement blogs = driver.findElement(By.xpath("//a[contains(text(),'რა არის სინეფრინი?')]"));
        JavascriptExecutor js = driver;
        /* 1. scroll till the element

        js.executeScript("arguments[0].scrollIntoView(true);", blogs);

        // 2.scroll down page by pixel number
        js.executeScript("window.scrollBy(0,1500)", ""); */

        // 3. scroll page till end of the page
        js.executeScript("window.scrollBy(0,document.body.scrollHeight)");

        Thread.sleep(3000);

        // 4. scroll page up
        js.executeScript("window.scrollBy(0,-document.body.scrollHeight)");
    }
}
