package Practice_Example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class DragAndDropAction {
    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        driver.get("http://dhtmlgoodies.com/scripts/drag-drop-custom/demo-drag-drop-3.html");
        driver.manage().window().maximize();

        Actions act = new Actions(driver);
        WebElement stock = driver.findElement(By.xpath("//div[@id='box2']"));
        WebElement sweden = driver.findElement(By.xpath("//div[@id='box102']"));

        act.dragAndDrop(stock, sweden).perform();
    }
}
