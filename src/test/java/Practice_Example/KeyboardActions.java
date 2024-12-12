package Practice_Example;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import java.time.Duration;

public class KeyboardActions {
    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://text-compare.com/");
        driver.manage().window().maximize();

        // Find and interact with the first text area
        driver.findElement(By.xpath("//textarea[@id='inputText1']")).sendKeys("Hello");

        // Create an Actions object to handle keyboard events
        Actions act = new Actions(driver);

        // ctrl+A - Selects the text (CONTROL instead of COMMAND for Windows)
        act.keyDown(Keys.COMMAND).sendKeys("A").keyUp(Keys.CONTROL).perform();

        // Adding a small delay before performing next action (for clarity)
        try {
            Thread.sleep(500);  // Sleep for half a second
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // ctrl+C - Copy the selected text (CONTROL instead of COMMAND for Windows)
        act.keyDown(Keys.COMMAND).sendKeys("C").keyUp(Keys.COMMAND).perform();

        // Adding a small delay before switching to the second textarea
        try {
            Thread.sleep(500);  // Sleep for half a second
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // Tab - Switch focus to the second text area
        act.sendKeys(Keys.TAB).perform();

        // Adding a small delay before pasting
        try {
            Thread.sleep(500);  // Sleep for half a second
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // ctrl+V - Paste the copied text into the second textarea (CONTROL instead of COMMAND for Windows)
        act.keyDown(Keys.COMMAND).sendKeys("V").keyUp(Keys.COMMAND).perform();

        // Optionally, add a wait to see the results

        // Quit the browser
        //driver.quit();
    }
}
