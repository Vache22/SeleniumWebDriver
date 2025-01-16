package TestNG_Practice_Sub;

import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

public class C2 {
    @Test
    public void abc(){
        System.out.println("this is from C2...");
    }
    @AfterTest
    public void bt(){
        System.out.println("this is AfterTest method...");
    }
}
