package first_package;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.time.Month;
import java.util.HashMap;
import java.util.List;

public class DatePickerDemo3 {

    // User-defined method for converting month from string --> Month
    static Month convertMonth(String month) {
        // Mapping for both full and abbreviated month names
        HashMap<String, Month> monthMap = new HashMap<>();
        monthMap.put("January", Month.JANUARY);
        monthMap.put("February", Month.FEBRUARY);
        monthMap.put("March", Month.MARCH);
        monthMap.put("April", Month.APRIL);
        monthMap.put("May", Month.MAY);
        monthMap.put("June", Month.JUNE);
        monthMap.put("July", Month.JULY);
        monthMap.put("August", Month.AUGUST);
        monthMap.put("September", Month.SEPTEMBER);
        monthMap.put("October", Month.OCTOBER);
        monthMap.put("November", Month.NOVEMBER);
        monthMap.put("December", Month.DECEMBER);

        // Handling abbreviated months like "Jan", "Feb", etc.
        monthMap.put("Jan", Month.JANUARY);
        monthMap.put("Feb", Month.FEBRUARY);
        monthMap.put("Mar", Month.MARCH);
        monthMap.put("Apr", Month.APRIL);
        monthMap.put("Jun", Month.JUNE);
        monthMap.put("Jul", Month.JULY);
        monthMap.put("Aug", Month.AUGUST);
        monthMap.put("Sep", Month.SEPTEMBER);
        monthMap.put("Oct", Month.OCTOBER);
        monthMap.put("Nov", Month.NOVEMBER);
        monthMap.put("Dec", Month.DECEMBER);

        // Get the full month from the map (could be null if invalid)
        Month vmonth = monthMap.get(month);

        // Print an error message and return null if invalid month
        if (vmonth == null) {
            System.out.println("Invalid Month: " + month);
        }
        return vmonth;
    }

    static void selectDate(WebDriver driver, String requiredYear, String requiredMonth, String requiredDate) throws InterruptedException {
        // Open the date picker
        driver.findElement(By.xpath("//input[@id='datepicker']")).click();

        // Convert abbreviated month to full month name
        Month expectedMonth = convertMonth(requiredMonth);
        if (expectedMonth == null) {
            driver.quit();  // Exit if the month is invalid
            return;
        }

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));

        // Loop through to find the correct year and month
        while (true) {
            // Get current year and displayed month in the date picker
            String displayedYear = driver.findElement(By.xpath("//span[@class='ui-datepicker-year']")).getText();
            String displayedMonth = driver.findElement(By.xpath("//span[@class='ui-datepicker-month']")).getText();

            // Debugging: Print current year and month
            System.out.println("Displayed Year: " + displayedYear + ", Displayed Month: " + displayedMonth);

            WebElement prevArrow = driver.findElement(By.xpath("//span[@class='ui-icon ui-icon-circle-triangle-w']"));
            WebElement nextArrow = driver.findElement(By.xpath("//span[@class='ui-icon ui-icon-circle-triangle-e']"));

            // Convert the displayed year and required year to integer for comparison
            int currentYear = Integer.parseInt(displayedYear);
            int targetYear = Integer.parseInt(requiredYear);

            // Compare the years
            if (currentYear < targetYear) {
                nextArrow.click(); // Go to the next year if the current is less than the target
            } else if (currentYear > targetYear) {
                prevArrow.click(); // Go to the previous year if the current is greater than the target
            } else {
                // When the current year matches the required year, check the month
                Month currentMonth = convertMonth(displayedMonth);
                if (currentMonth == null) {
                    System.out.println("Invalid month: " + displayedMonth);
                    break; // Exit if there's an issue with month conversion
                }

                // Compare the months after the year is matched
                if (currentMonth.equals(expectedMonth)) {
                    System.out.println("Found the correct month and year: " + displayedMonth + " " + displayedYear);
                    break; // Break if both the year and month are matched
                } else if (currentMonth.compareTo(expectedMonth) < 0) {
                    nextArrow.click(); // Go to the next month if the current month is less than the target
                } else {
                    prevArrow.click(); // Go to the previous month if the current month is greater than the target
                }
            }

            // Wait for the calendar to update
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[@class='ui-datepicker-month']")));
            Thread.sleep(500); // Adding a short wait to ensure the page has time to update
        }

        // Once the correct month and year are displayed, select the required date
        List<WebElement> availableDates = driver.findElements(By.xpath("//table[@class='ui-datepicker-calendar']//td"));
        for (WebElement date : availableDates) {
            String dateText = date.getText();
            if (dateText.equals(requiredDate)) {
                date.click(); // Click the required date
                break;
            }
        }

        // Wait for a few seconds to see the result
        Thread.sleep(2000);
        driver.quit(); // Close the browser
    }

    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://testautomationpractice.blogspot.com/");
        driver.manage().window().maximize();

        // Input dates
        String requiredYear = "2025";
        String requiredMonth = "Jul"; // Abbreviated month
        String requiredDate = "30";

        selectDate(driver,requiredYear,requiredMonth,requiredDate);
    }
}
