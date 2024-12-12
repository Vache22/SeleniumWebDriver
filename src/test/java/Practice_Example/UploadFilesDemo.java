package Practice_Example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class UploadFilesDemo {
    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.get("https://davidwalsh.name/demo/multiple-file-upload.php");

        String file1 = "/Users/d.vacheishvili/Desktop/test.png";
        String file2 = "/Users/d.vacheishvili/Downloads/Sofi-ai-12-02-2024_03_  23_PM.png";

        // uploading multiple files same time
        driver.findElement(By.xpath("//input[@id='filesToUpload']")).sendKeys(file1+"\n"+file2);




    }
}
