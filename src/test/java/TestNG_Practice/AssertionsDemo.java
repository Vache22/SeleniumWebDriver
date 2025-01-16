package TestNG_Practice;

import org.testng.Assert;
import org.testng.annotations.Test;

public class AssertionsDemo {
    @Test
    public void testTitle(){
        String exp_title="Opencart";
        String act_title="Openshot";

        Assert.assertEquals(exp_title,act_title);
    }
}
