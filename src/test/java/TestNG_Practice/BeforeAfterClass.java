package TestNG_Practice;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class BeforeAfterClass {
        @BeforeClass // executing once before iteration of executing @Test
        public void login(){
            System.out.println("Login...");
        }
        @Test(priority = 1, groups = {"sanity","regression","functional"})
        public void search(){
            System.out.println("search...");
        }
        @Test(priority = 2, groups = {"sanity","regression","functional"})
        public void advancedSearch(){
            System.out.println("This is advanced search...");
        }
        @AfterClass // executing last, after executing @Test
        public void logout(){
            System.out.println("logout...");
        }
    }

