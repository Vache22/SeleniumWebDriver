package TestNG_Practice;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class SoftAssertion {
        @Test
        void test(){
            System.out.println("test 1");
            SoftAssert sa = new SoftAssert();
            sa.assertEquals("xyz","xyz"); // hard assertion terminates processs - soft assertion is not
            System.out.println("test 2");
    }
}
