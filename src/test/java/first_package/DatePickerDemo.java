package first_package;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class DatePickerDemo {
    public static void main(String[] args) throws InterruptedException {

        WebDriver driver = new ChromeDriver();
        driver.get("https://jqueryui.com/datepicker/");
        driver.manage().window().maximize();

        //Switch to frame
        driver.switchTo().frame(0);

        // Method with sendKeys()
        //driver.findElement(By.xpath("//input[@id='datepicker']")).sendKeys("02/02/1997");


        driver.findElement(By.xpath("//input[@id='datepicker']")).click();

        SelectPastDate(driver,"2023","02", "02");
//        select the date


    }

static void  SelectPastDate(WebDriver driver,String year,String month,String date) throws InterruptedException {
    // looping thorough
    while (true){
        String curMonth = driver.findElement(By.xpath("//span[@class='ui-datepicker-month']")).getText();
        String curYear =  driver.findElement(By.xpath("//span[@class='ui-datepicker-year']")).getText();

        if(curMonth.equals(month) && curYear.equals(year)){
            System.out.println("found year and month " + year + month);
            break;
        }
        driver.findElement(By.xpath("//span[@class='ui-icon ui-icon-circle-triangle-w']")).click();
    }
    List<WebElement> allDates = driver.findElements(By.xpath("//table[@class='ui-datepicker-calendar']//tbody//tr//td//a"));
    Thread.sleep(1500);
    for(WebElement dt:allDates){
        if(dt.getText().equals(date)){
            dt.click();
            break;
        }
    }
}
}