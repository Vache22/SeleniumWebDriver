package first_package;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class JavascriptExecutorDemo {
    public static void main(String[] args) {
        ChromeDriver driver = new ChromeDriver();
        driver.get("https://testautomationpractice.blogspot.com/");
        driver.manage().window().maximize();

        WebElement inputName = driver.findElement(By.xpath("//input[@id='name']"));

        // passing text to inputbox - alternate to sendKeys()
        JavascriptExecutor js = driver;
        js.executeScript("arguments[0].setAttribute('value','Davit')", inputName);

        // click action
        WebElement radioBtn = driver.findElement(By.xpath("//input[@id='male']"));
        js.executeScript("arguments[0].click()", radioBtn);
    }
}
