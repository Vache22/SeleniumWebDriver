package TestNG_Practice_Sub;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class C1 {
    @Test
    public void abc(){
        System.out.println("this is from C1...");
    }
    @BeforeTest
    public void bt(){
        System.out.println("this is BeforeTest method from C1...");
    }
}
