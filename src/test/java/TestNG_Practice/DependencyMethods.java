package TestNG_Practice;

import org.testng.Assert;
import org.testng.annotations.Test;

public class DependencyMethods {
    @Test(priority = 1)
    public void openapp(){
        Assert.assertTrue(true);
    }
    @Test(priority = 2, groups = {"sanity","functional"})
    public void login(){
        Assert.assertTrue(true);
    }
    @Test(priority = 3, dependsOnMethods = {"openapp"})
    public void search(){
        Assert.assertTrue(true);
    }
    @Test(priority = 4, dependsOnMethods = {"login"})
    public void advSearch(){
        Assert.assertTrue(true);

    }
    @Test(priority = 5, dependsOnMethods = {"login"})
    public void logOut(){
        Assert.assertTrue(true);

    }

}
