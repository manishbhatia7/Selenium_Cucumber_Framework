package bindings;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import pageobjects.addCustomerPage;

public class add_customer extends baseclass {
    @Given("I have already logged into application")
    public void i_have_already_logged_into_application() {
        
        ac=new addCustomerPage(driver);
    }

    @When("I click on Parent customer link")
    public void i_click_on_Parent_customer_link() {
        ac.click_Parent_Customer_link();
    }

    @When("I click on child customer link")
    public void i_click_on_child_customer_link() {
        ac.click_Child_Customer_link();
    }

    @Then("Add Customer button should be visible")
    public void add_Customer_button_should_be_visible() {
        ac.assert_Button_is_Visible();
    }
    @When("I click on Add new customer button")
    public void i_click_on_Add_new_customer_button() throws InterruptedException {
        ac=new addCustomerPage(driver);
        Thread.sleep(5000);
        ac.click_on_addcustomer_button();
    }

    @When("I enter Email as {string}")
    public void i_enter_Email_as(String email) {
        ac.enterEmail(email);
        
    }

    @When("I enter Password as {string}")
    public void i_enter_Password_as(String password) {
        ac.enterPassword(password);
    }

    @When("I enter FirstName as {string}")
    public void i_enter_FirstName_as(String fname) {
        ac.enterFirstName(fname);
        
    }

    @When("I enter LastName as {string}")
    public void i_enter_LastName_as(String lname) {
        ac.enterLastName(lname);
        
    }

    @When("I select Gender")
    public void i_select_Gender() {
        ac.selectGender();
        
    }

    @When("I enter  DOB as {string}")
    public void i_enter_DOB_as(String dob) {
        ac.enterDOB(dob);
    }

    @When("I select Newsletter as {string}")
    public void i_select_Newsletter_as(String newsletter) {
        ac.selectNewsLetter(newsletter);
    }

    @When("I click on save")
    public void i_click_on_save() {
        dc=ac.save_Data();
        
    }

    @Then("New customer should be added")
    public boolean new_customer_should_be_added() {
        boolean result = false;
        int attempts = 0;
        while(attempts < 2) {
            try {
                ac.assert_Button_is_Visible();
                result = true;
                break;
            } catch(Exception e) {
            }
            attempts++;
        }
        return result;
    }


}
