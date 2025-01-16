package PageObjectModel;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {
    WebDriver driver;

    // Constructor
    LoginPage(WebDriver driver){
        this.driver = driver;
    }

    // Locators
    By username = By.xpath("//input[@placeholder='Username']");
    By password = By.xpath("//input[@placeholder='Password']");
    By login_btn = By.xpath("//button[normalize-space()='Login']");

    public void setUsername(String user){
        driver.findElement(username).sendKeys(user);
    }

    public void setPassword(String pwd){
        driver.findElement(password).sendKeys(pwd);
    }

    public void clickLogin(){
        driver.findElement(login_btn).click();
    }
}
