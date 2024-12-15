package Data_Driven_Testing;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.Set;

public class ReadingPropertiesFile {
    public static void main(String[] args) throws IOException {
        // location of properties file
        FileInputStream file = new FileInputStream(System.getProperty("user.dir")+"/testData/config.properties");

        // loading properties of file
        Properties propertiesobj=new Properties();
        propertiesobj.load(file);

        // reading data from properties file
        String url = propertiesobj.getProperty("appUrl");
        String email = propertiesobj.getProperty("email");
        String pass = propertiesobj.getProperty("password");
        String orderid = propertiesobj.getProperty("orderid");
        String customerid = propertiesobj.getProperty("customerid");

       // System.out.println(url +" "+ email +" "+ pass +" "+ orderid+ " " + customerid);

        Set<String> keys =  propertiesobj.stringPropertyNames();
        System.out.println(keys);

        file.close();

    }
}
