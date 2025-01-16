package TestNG_Practice;

import org.testng.Assert;
import org.testng.annotations.Test;

public class HardAssertions {
    @Test
    void test(){
        System.out.println("test 1");
        Assert.assertEquals("xyz","xyz"); // hard assertion terminates processs - soft assertion is not
        System.out.println("test 2");
    }
}



