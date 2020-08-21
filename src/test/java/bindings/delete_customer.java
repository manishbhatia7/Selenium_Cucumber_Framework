package bindings;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import pageobjects.deleteCustomerPage;

public class delete_customer extends baseclass {
    @When("I type {string} in Email textbox")
    public void i_type_in_Email_textbox(String email) {
        dc=new deleteCustomerPage(driver);
        dc.enterEmailId(email);
    }

    @When("click on search button")
    public void click_on_search_button() {
        dc.clickSearchButton();
    }

    @Then("I should be able to click on edit button")
    public void i_should_be_able_to_click_on_edit_button() throws InterruptedException {
        Thread.sleep(5000);
        dc.clickEditButton();
    }
    @And("^I type \"([^\"]*)\" second time in Email textbox$")
    public boolean i_type_something_second_time_in_email_textbox(String email) throws Throwable {
        dc=new deleteCustomerPage(driver);
        Thread.sleep(5000);
        boolean result = false;
        int attempts = 0;
        while(attempts < 2) {
            try {
                dc.enterSecondEmailId(email);
                dc.clickSearchButton();
                result = true;
                break;
            } catch(Exception e) {
            }
            attempts++;
        }
        return result;

    }

    @And("click on Delete button")
    public void click_on_Delete_button() throws InterruptedException {
        Thread.sleep(5000);
        dc.clickDeleteonPage();
    }

    @Then("on alert confirm the deletion")
    public void on_alert_confirm_the_deletion() throws InterruptedException {
        Thread.sleep(5000);
        dc.clickDeleteonAlertPage();
    }



    @Then("record should be deleted")
    public void record_should_be_deleted() throws InterruptedException {
        Thread.sleep(5000);
        dc.assertMessage();
        dc.assertEmptyRow();
        
    }



}
