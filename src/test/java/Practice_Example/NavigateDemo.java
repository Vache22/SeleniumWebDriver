package Practice_Example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class NavigateDemo {

    public static void main(String[] args) {

        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
        driver.manage().window().maximize();

        driver.findElement(By.xpath("//a[normalize-space()='OrangeHRM, Inc']")).click();
        Set<String> windowIDs = driver.getWindowHandles();

        List<String> windowList = new ArrayList<>(windowIDs);

        // Approach 1
        String parentID = windowList.get(0);
        String childID = windowList.get(1);

        // Switch to child window
        driver.switchTo().window(childID);
        System.out.println(driver.getTitle());

        //switch to parent window
        driver.switchTo().window(parentID);
        System.out.println(driver.getTitle());

        // so command is : driver.switchTo().window(windowID)

        //Approach 2

        for (String windId : windowIDs){
            driver.switchTo().window(windId).getTitle();
        }

    }
}
