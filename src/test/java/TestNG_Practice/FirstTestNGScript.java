package TestNG_Practice;

import org.testng.annotations.Test;

public class FirstTestNGScript {
    @Test(priority = 1)
     public void openApp(){
        System.out.println("opening app");
    }
    @Test(priority = 2)
     public void login(){
        System.out.println("login to app..");
    }
    @Test(priority = 3)
     public void logout(){
        System.out.println("logout from app...");
    }

}
