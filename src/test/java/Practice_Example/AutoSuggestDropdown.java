package Practice_Example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.List;

public class AutoSuggestDropdown {
    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://www.google.com/");
        driver.manage().window().maximize();

        WebElement searchtext = driver.findElement(By.xpath("//textarea[@id='APjFqb']"));
        searchtext.sendKeys("selenium");

        List<WebElement>opt = driver.findElements(By.xpath("//ul[@role='listbox']//li//div[@role='option']"));

        for (int i = 0; i < opt.size(); i++) {
            if(opt.get(i).getText().equals("selenium")){
                opt.get(i).click();
            }
        }

//        WebElement searchBtn = driver.findElement(By.xpath("//span[@class='QCzoEc z1asCe MZy1Rb']//*[name()='svg']"));
//        searchBtn.click();

    }
}
