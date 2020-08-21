package bindings;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.log4j.Logger;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import pageobjects.addCustomerPage;
import pageobjects.deleteCustomerPage;
import pageobjects.loginPage;
import utlities.readConfig;

public class baseclass {
    public static Logger logger;
    public static WebDriver driver;
    public loginPage lp;
    public addCustomerPage ac;
    public deleteCustomerPage dc;
    readConfig read = new readConfig();
    String url=read.getApplicationUrl();

    public void initaliseBrowser(String browser)
    {

        if(browser.equalsIgnoreCase("chrome"))
        {
            WebDriverManager.chromedriver().setup();
            driver=new ChromeDriver();
        }
        else if (browser.equalsIgnoreCase("firefox"))
        {
            WebDriverManager.firefoxdriver().setup();
            driver=new FirefoxDriver();
        }
        else
        {
            WebDriverManager.edgedriver().setup();
            driver=new EdgeDriver();
        }
        driver.get(url);
        driver.manage().window().maximize();
    }

}