package first_package;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.JavascriptExecutor;

import java.time.Duration;

public class DynamicPagination {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        driver.get("https://demo.opencart.com/admin/index.php");
        driver.manage().window().maximize();

        WebElement userName = driver.findElement(By.xpath("//input[@id='input-username']"));
        userName.clear();
        userName.sendKeys("demo");

        WebElement passWord = driver.findElement(By.xpath("//input[@id='input-password']"));
        passWord.clear();
        passWord.sendKeys("demo");

        WebElement loginBtn = driver.findElement(By.xpath("//button[@type='submit']"));

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(loginBtn)).click();

        try {
            wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//h1[normalize-space()='Dashboard']")));
        } catch (Exception e) {
            loginBtn.click();
            wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//h1[normalize-space()='Dashboard']")));
        }

        try {
            WebElement closeButton = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@class='btn-close']")));
            if (closeButton.isDisplayed()) {
                closeButton.click();
            }
        } catch (Exception e) {
            System.out.println("No popup detected.");
        }

        WebElement parentLink = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@class='parent collapsed'][normalize-space()='Customers']")));
        parentLink.click();

        WebElement customersLink = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//ul[@id='collapse-5']//a[contains(text(),'Customers')]")));
        customersLink.click();

        String text = driver.findElement(By.xpath("//div[contains(text(),'Pages')]")).getText();
        int total_pages = Integer.parseInt(text.substring(text.indexOf("(") + 1, text.indexOf("Pages") - 1));

        for (int p = 1; p <= total_pages; p++) {
            if (p > 1) {
                try {
                    WebElement pageLink = driver.findElement(By.xpath("//ul[@class='pagination']//a[text()='" + p + "']"));
                    wait.until(ExpectedConditions.elementToBeClickable(pageLink));
                    ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", pageLink);
                    ((JavascriptExecutor) driver).executeScript("arguments[0].click();", pageLink);
                    Thread.sleep(1500);
                    // Re-locate the pagination element to avoid stale element exception
                    wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(text(),'Pages')]")));
                } catch (Exception e) {
                    System.out.println("Exception navigating to page " + p + ": " + e.getMessage());
                }
            }
        }

        //driver.quit();
    }
}
