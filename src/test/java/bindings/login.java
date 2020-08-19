package bindings;

import cucumber.api.java.Before;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.testng.Assert;
import pageobjects.loginPage;


public class login extends baseclass {

    @Before
    public void setup()
    {
        logger= Logger.getLogger("nopCommerceSDET");
        PropertyConfigurator.configure("Log4j.properties");
        logger.setLevel(Level.DEBUG);


   }
    @When("user launches the application")
    public void user_launches_the_application() {

        initaliseBrowser("Chrome");
        lp=new loginPage(driver);
        logger.info("Application launched");
    }

    @And("enters username as {string}")
    public void enters_username_as(String username) {
        logger.info("Email entered");
        lp.enterUserName(username);
        }

    @And("password as {string}")
    public void password_as(String password) {
        logger.info("Password cleared");
        logger.info("Password submitted");
        lp.enterPassword(password);
    }

    @And("click on submit button")
    public void click_on_submit_button() {
        logger.info("Login after credentials are submitted");
        ac=lp.submitCredentials();
    }

    @Then("login should be successful")
    public void login_should_be_successful() {
        logger.info("Check whether login is successful");
        Assert.assertEquals(driver.getTitle(),"Dashboard / nopCommerce administration");
    }




}
