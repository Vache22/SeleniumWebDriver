package Practice_Example;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class DisableChomeSeleniumMessage {
    public static void main(String[] args) throws InterruptedException {
        ChromeOptions options = new ChromeOptions();
        options.setExperimentalOption("excludeSwitches", new String[] {"enable-automation"});

        WebDriver driver = new ChromeDriver(options);
        driver.get("https://vitamini.ge/");
        Thread.sleep(4000);
        driver.quit();

    }
}
