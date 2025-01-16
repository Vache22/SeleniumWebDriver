package TestNG_Practice_Sub;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class C3 {
    @Test
    public void foo(){
        System.out.println("this is foo from C3...");
    }
    @AfterSuite
    public void foo1(){
        System.out.println("this is AfterSuite foo1 from C3...");
    }
    @BeforeSuite
    public void foo2(){
        System.out.println("this is beforeSuite foo2 from C3...");
    }
}
