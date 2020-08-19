package utlities;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class readConfig {
    Properties prop;
    public readConfig() {
        File src = new File("./configuration/config.properties");
        try {
            FileInputStream fis = new FileInputStream(src);
            prop = new Properties();
            prop.load(fis);

        } catch (Exception e) {
            System.out.println("File not found" + e.getMessage());
        }
    }
        public String getApplicationUrl()
        {
           String Url=prop.getProperty("baseurl");
           return Url;
        }




    }

