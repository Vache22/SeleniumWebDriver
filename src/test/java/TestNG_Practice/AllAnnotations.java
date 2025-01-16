package TestNG_Practice;
import org.testng.annotations.*;

public class AllAnnotations {
    @BeforeSuite
    public void bs(){
        System.out.println("This is before suite...");
    }

    @AfterSuite
    public void as(){
        System.out.println("This is after suite...");
    }

    @BeforeTest
    public void bt(){
        System.out.println("This is before test...");
    }

    @AfterTest
    public void at(){
        System.out.println("This is after test...");
    }

    @BeforeClass
    public void bc(){
        System.out.println("This is before class...");
    }

    @AfterClass
    public void ac(){
        System.out.println("This is after class...");
    }

    @BeforeMethod
    public void bm(){
        System.out.println("This is before method...");
    }


    @Test
    public void search(){
        System.out.println("testing advanced search...");
    }


    @AfterMethod
    public void am(){
        System.out.println("This is after method...");
    }
}
