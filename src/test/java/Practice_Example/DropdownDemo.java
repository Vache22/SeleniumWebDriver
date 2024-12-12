package Practice_Example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;
import java.util.List;

public class DropdownDemo {
    public static void main(String[] args) {

        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://testautomationpractice.blogspot.com/");
        driver.manage().window().maximize();

        WebElement drpCountryEl = driver.findElement(By.xpath("//select[@id='country']"));
        Select drpCountry = new Select(drpCountryEl);
        drpCountry.selectByVisibleText("Japan");

        // get number of options in Select
        List<WebElement>options = drpCountry.getOptions();
        System.out.println(options.size());


    }
}
