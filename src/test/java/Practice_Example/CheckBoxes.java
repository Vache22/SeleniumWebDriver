package Practice_Example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class CheckBoxes {
    public static void main(String[] args) {

        WebDriver driver = new ChromeDriver();
        driver.get("https://testautomationpractice.blogspot.com/");
        driver.manage().window().maximize();

        List<WebElement>checkboxes = driver.findElements(By.xpath("//input[@class=\"form-check-input\" and @type=\"checkbox\"]"));

         // 1.select specific checkbox
        //driver.findElement(By.xpath("//input[@id='tuesday']")).click();

        // 2. select all the checkboxes
//        for(WebElement checkbox : checkboxes){
//            checkbox.click();
//        }
        // 3. Select last 3 checkboxes
        for(int i= checkboxes.size()- 3; i < checkboxes.size(); i++){
            if(checkboxes.get(i).isSelected()) {
                checkboxes.get(i).click();
            }
        }

    }
}
