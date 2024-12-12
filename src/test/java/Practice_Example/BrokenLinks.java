package Practice_Example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.net.HttpURLConnection;
import java.net.URL;
import java.time.Duration;
import java.util.List;

public class BrokenLinks {
    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("http://www.deadlinkcity.com/");
        driver.manage().window().maximize();

        // capture all the link
        List<WebElement>links = driver.findElements(By.tagName("a"));
        System.out.println("Count of links: " +links.size());

        int numberOfBrokenLinks = 0;

        for(WebElement link : links){
          String hrefValue =   link.getAttribute("href");
          if(hrefValue == null || hrefValue.isEmpty()){
              System.out.println("href value is null or empty, not possible to check.");
              continue;
          }
          try {
              URL linkUrl = new URL(hrefValue);
              HttpURLConnection connectLinkUrl = (HttpURLConnection) linkUrl.openConnection(); // open connection to the server
              connectLinkUrl.connect(); // connect to server and sent request the server
              if (connectLinkUrl.getResponseCode() >= 400) {
                  System.out.println("Broken link: "+hrefValue);
                  numberOfBrokenLinks++;
              }else{
                  System.out.println("not broken link: "+hrefValue);
              }
          }catch(Exception e){

          }
        }
        System.out.println("Number of broken links " + numberOfBrokenLinks);
    }
}
