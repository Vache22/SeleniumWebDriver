package PageObjectModel;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;

import java.time.Duration;

public class Logintest {

    // Create a Logger instance using Log4j
    private static final Logger logger = LogManager.getLogger(Logintest.class);

    WebDriver driver;

    @BeforeClass
    void setup(){
        logger.info("Starting setup...");

        // Initialize WebDriver
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        // Navigate to the login page
        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
        driver.manage().window().maximize();

        logger.info("Setup completed, browser launched and navigated to the login page.");
    }

    @Test
    void testLogin(){
        logger.info("Test started: testLogin");

        // Initialize the LoginPage object (assuming you have a Page Object Model setup)
        LoginPage_Factory lp = new LoginPage_Factory(driver);

        logger.debug("Setting username and password.");
        lp.setUsername("Admin");
        lp.setPassword("admin123");

        logger.debug("Clicking login button.");
        lp.clickLogin();

        // Assert that the page title is correct after login
        String expectedTitle = "OrangeHRM";
        String actualTitle = driver.getTitle();

        // Logging the result of the assertion
        logger.info("Verifying page title: Expected = {}, Actual = {}", expectedTitle, actualTitle);
        Assert.assertEquals(actualTitle, expectedTitle);

        logger.info("Test completed: testLogin");
    }

    @AfterClass
    void tearDown(){
        logger.info("Tearing down the driver and closing the browser.");

        // Quit the browser
        driver.quit();

        logger.info("Browser closed, test completed.");
    }
}
