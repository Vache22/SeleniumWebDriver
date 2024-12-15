package Data_Driven_Testing;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;

import java.io.IOException;
import java.time.Duration;

public class FDCalculator {
    public static void main(String[] args) throws IOException, InterruptedException {
        // Set the path to your ChromeDriver executable
        System.setProperty("webdriver.chrome.driver", "/usr/local/bin/chromedriver");


        // Set the path to your Chrome User Data Directory
        // Replace <Your Profile Name> with the specific profile folder you want to use
        String userDataDir = "/Users/d.vacheishvili/Library/Application Support/Google/Chrome/Profile 1";
        String profileName = "Profile 1";  // You can use 'Default' or other profiles as well

        // Set ChromeOptions
        ChromeOptions options = new ChromeOptions();
        options.addArguments("user-data-dir=" + userDataDir);  // Path to your user data directory
        options.addArguments("profile-directory=" + profileName);  // Path to the profile folder

        // Launch Chrome with the specified profile
        WebDriver driver = new ChromeDriver(options);

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();

        String filePath = System.getProperty("user.dir")+"/testData/InterestRates.xlsx";
        int rows = ExcelUtils.getRowCount(filePath,"1ფურცელი");

        for(int i=1; i<=rows; i++){
            // read data from Excel
            String pric = ExcelUtils.getCellData(filePath,"1ფურცელი",i,0);
            String rateOfInterest = ExcelUtils.getCellData(filePath,"1ფურცელი",i,1);
            String per1 = ExcelUtils.getCellData(filePath,"1ფურცელი",i,2);
            String per2 = ExcelUtils.getCellData(filePath,"1ფურცელი",i,3);
            String frequency = ExcelUtils.getCellData(filePath,"1ფურცელი",i,4);
            String exp_mvalue = ExcelUtils.getCellData(filePath,"1ფურცელი",i,5);

            // pass above data into application
            driver.findElement(By.xpath("//input[@id='principal']")).sendKeys(pric);
            driver.findElement(By.xpath("//input[@id='interest']")).sendKeys(rateOfInterest);
            driver.findElement(By.xpath("//input[@id='tenure']")).sendKeys(per1);

            Select perdrp = new Select(driver.findElement(By.xpath("//select[@id='tenurePeriod']")));
            perdrp.selectByVisibleText(per2);

            Select fredrp= new Select(driver.findElement(By.xpath("//select[@id='frequency']")));
            fredrp.selectByVisibleText(frequency);

            driver.findElement(By.xpath("//div[@class='cal_div']//a[1]")).click();

            // validation
            String act_mvalue=driver.findElement(By.xpath("//span[@id='resp_matval']//strong")).getText();

            if(Double.parseDouble(exp_mvalue)==Double.parseDouble(act_mvalue)){
                System.out.println("Test passed");
                ExcelUtils.setCellData(filePath,"1ფურცელი",i,7,"Passed");
                ExcelUtils.fillGreenColor(filePath,"1ფურცელი",i,7);
            }else{
                System.out.println("Test Failed");
                ExcelUtils.setCellData(filePath,"1ფურცელი",i,7,"Failed");
                ExcelUtils.fillRedColor(filePath,"1ფურცელი",i,7);
            }
            Thread.sleep(3000);
            driver.findElement(By.xpath("//img[@class='PL5']")).click(); // clear fields
        } // end of loop
        driver.quit();
    }

}
