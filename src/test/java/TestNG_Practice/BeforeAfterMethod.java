package TestNG_Practice;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class BeforeAfterMethod {
    @BeforeMethod  // executing before every iteration of executing @Test
    public void login(){
        System.out.println("Login...");
    }
    @Test(priority = 1)
    public void search(){
        System.out.println("search...");
    }
    @Test(priority = 2)
    public void advancedSearch(){
        System.out.println("This is advanced search...");
    }
    @AfterMethod // executing after every iteration of executing @Test
    public void logout(){
        System.out.println("logout...");
    }
}
