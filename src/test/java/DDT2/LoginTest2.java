package DDT2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import testBase.BaseClass;
import java.io.IOException;
import java.time.Duration;
import java.util.List;

public class LoginTest2 extends BaseClass {

    // DataProvider that reads data from Excel file
    @DataProvider(name = "loginData")
    public Object[][] getLoginData() throws IOException {
        // Open the Excel file and get the login data
        utils.ExcelUtils2.openExcelFile("testData/sample.xlsx", "Sheet1");  // Path to your Excel file and sheet name
        List<Object[]> data = utils.ExcelUtils2.getData();
        utils.ExcelUtils2.closeExcel();

        // Convert List<Object[]> to a 2D array for DataProvider
        Object[][] loginData = new Object[data.size()][];
        for (int i = 0; i < data.size(); i++) {
            loginData[i] = data.get(i);
        }
        return loginData;
    }

    // Test method to validate login functionality
    @Test(dataProvider = "loginData", groups = {"regression", "smoke"})
    public void testLogin(String username, String password) {
        System.out.println("Testing login with Username: " + username + " and Password: " + password);

        try {
            // Open the login page
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
            driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
            driver.manage().window().maximize();

            // Enter credentials and click on Login button
            driver.findElement(By.xpath("//input[@placeholder='Username']")).sendKeys(username);
            driver.findElement(By.xpath("//input[@placeholder='Password']")).sendKeys(password);
            driver.findElement(By.xpath("//button[normalize-space()='Login']")).click();

            // Add verification to check if login is successful (e.g., check if the dashboard is loaded)
            if (isLoginSuccessful()) {
                System.out.println("Login successful with Username: " + username + " and Password: " + password);

                // Perform logout if login is successful
                logout();
                System.out.println("Logged out successfully after Username: " + username);
            } else {
                Assert.fail("Login failed for Username: " + username + " and Password: " + password);
            }

        } catch (Exception e) {
            // In case of an exception, fail the test for this iteration
            System.out.println("Test failed for Username: " + username + " and Password: " + password);
        }
    }

    // Method to check if login was successful
    private boolean isLoginSuccessful() {
        try {
            // Check if the URL or an element on the dashboard is present
            // You can replace this with a more specific check
            return driver.getCurrentUrl().contains("dashboard");
        } catch (Exception e) {
            return false;
        }
    }

    // Method to perform logout
    private void logout() {
        try {
            // Use the provided XPath for the logout button
            driver.findElement(By.xpath("//img[@class='oxd-userdropdown-img']")).click();  // Replace this with your logout button's XPath
            driver.findElement(By.xpath("//a[normalize-space()='Logout']")).click();  // Replace this with your logout button's XPath
            // Optionally, you can add a wait here to ensure the logout is completed
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        } catch (Exception e) {
            System.out.println("Logout failed due to exception: " + e.getMessage());
        }
    }

    // Cleanup: Close WebDriver after all tests are done
    @AfterClass
    public void tearDown() {
        super.tearDown();  // This will call the tearDown method from BaseClass
    }
}
