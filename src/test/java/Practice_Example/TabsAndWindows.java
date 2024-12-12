package Practice_Example;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;

public class TabsAndWindows {
    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        driver.get("http://dhtmlgoodies.com/scripts/drag-drop-custom/demo-drag-drop-3.html");
        driver.manage().window().maximize();

        driver.switchTo().newWindow(WindowType.TAB);

        driver.get("https://www.youtube.com/results?search_query=bypass+cloudflare+selenium+java");
    }
}
