package first_package;

import org.openqa.selenium.By;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ShadowRoot {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        // example how to locate shadowRoot element
        SearchContext shadow = driver.findElement(By.xpath("#shdow-root")).getShadowRoot();
        Thread.sleep(1000);
        shadow.findElement(By.cssSelector("#shadow-element"));

        // if we want to find SVG than we have to add rel xPath + //*[name()='svg']

    }
}
