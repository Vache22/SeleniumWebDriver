package first_package;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import java.time.Duration;

public class MouseActions {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://vitamini.ge/product/nutrex-cla");
        driver.manage().window().maximize();

       WebElement kategoriebi = driver.findElement(By.xpath("//span[@class='menu-opener color-scheme-light has-bg']"));
       WebElement danamatebi = driver.findElement(By.xpath("//body/div[contains(@class,'website-wrapper')]/header[contains(@class,'whb-header whb-sticky-shadow whb-scroll-slide whb-sticky-clone')]/div[contains(@class,'whb-main-header')]/div[contains(@class,'whb-row whb-header-bottom whb-not-sticky-row whb-without-bg whb-border-fullwidth whb-color-dark whb-flex-flex-middle whb-hidden-mobile')]/div[contains(@class,'container')]/div[contains(@class,'whb-flex-row whb-header-bottom-inner')]/div[contains(@class,'whb-column whb-col-left whb-visible-lg')]/div[contains(@role,'navigation')]/div[contains(@class,'header-categories-nav-wrap')]/div[contains(@class,'categories-menu-dropdown vertical-navigation woodmart-navigation')]/div[contains(@class,'menu-categories-container')]/ul[@id='menu-categories']/li[1]/a[1]"));

       Actions act = new Actions(driver);
       //act.moveToElement(kategoriebi).moveToElement(danamatebi).click().build().perform();

       // Right click action
        // act.contextClick(danamatebi).perform();

      // Double click action on the button
        // act.doubleClick(button).perform();

    // Actions -> class, will be used to perform mouse actions
        //Action -> interface, will be used to store created actions
    }
}
