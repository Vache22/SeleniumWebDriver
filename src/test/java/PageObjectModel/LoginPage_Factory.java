package PageObjectModel;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage_Factory {
    WebDriver driver;

    // Constructor
    public LoginPage_Factory(WebDriver driver){
        this.driver = driver;
        // Initialize elements using PageFactory
        PageFactory.initElements(driver, this);
    }

    // Locators using @FindBy annotation
    @FindBy(xpath = "//input[@placeholder='Username']")
    WebElement username;

    @FindBy(xpath = "//input[@placeholder='Password']")
    WebElement password;

    @FindBy(xpath = "//button[normalize-space()='Login']")
    WebElement login_btn;

    // Actions
    public void setUsername(String user){
        username.sendKeys(user);
    }

    public void setPassword(String pwd){
        password.sendKeys(pwd);
    }

    public void clickLogin(){
        login_btn.click();
    }
}
