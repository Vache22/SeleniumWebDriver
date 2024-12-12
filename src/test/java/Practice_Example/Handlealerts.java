package Practice_Example;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Handlealerts {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.get("https://the-internet.herokuapp.com/javascript_alerts");
        driver.manage().window().maximize();

        // normal alert with Ok button
        driver.findElement(By.xpath("//button[@onclick='jsAlert()']")).click();
        Alert myalert = driver.switchTo().alert();
        myalert.accept();
        // accept() or dismiss()
        // command: driver.switchTo().alert().accept() or dismiss()
        // driver.switchTo().alert().getText()
        // driver.switchTo().alert().sendKeys(text)
    }
}
