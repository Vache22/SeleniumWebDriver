package TestNG_Practice;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class ExtentReportManager implements ITestListener {
    public ExtentSparkReporter sparkReporter; // UI of the report
    public ExtentReports extent; // populate common info on the project
    public ExtentTest test; // creating test case entries in the report and update status of the methods

    public void onStart(ITestContext context){
        sparkReporter = new ExtentSparkReporter(System.getProperty("user.dir")+ "/utilities/myReport.html");
        sparkReporter.config().setDocumentTitle("Automation Report"); // Title of report
        sparkReporter.config().setReportName("Functional Testing"); // report name
        sparkReporter.config().setTheme(Theme.DARK);

        extent = new ExtentReports();
        extent.attachReporter(sparkReporter);

        extent.setSystemInfo("Computer Name", "localhost");
        extent.setSystemInfo("Environment", "QA");
        extent.setSystemInfo("Tester Name", "Vache");
        extent.setSystemInfo("OS", "Windows10");
        extent.setSystemInfo("Browser name", "Chrome");

    }

    public void onTestSuccess(ITestResult result) {
        test = extent.createTest(result.getName());
        test.log(Status.PASS,"Test case PASSED is: " + result.getName());
    }

    public void onTestFailure(ITestResult result){
        test = extent.createTest(result.getName());
        test.log(Status.FAIL,"Test case Failed is : " + result.getName());
        test.log(Status.FAIL,"Test case Failed cause is: " + result.getThrowable());
    }

    public void onTestSkipped(ITestResult result){
        test = extent.createTest(result.getName());
        test.log(Status.SKIP,"Test case Skipped is: " + result.getName());
    }

    public void onFinish(ITestContext context){
        extent.flush();
    }
}
