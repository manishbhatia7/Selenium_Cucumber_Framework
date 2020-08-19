package pageobjects;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class addCustomerPage {
    WebDriver ldriver;
    public addCustomerPage(WebDriver rdriver)
    {
        ldriver=rdriver;
        PageFactory.initElements(rdriver,this);
    }
    @FindBy(xpath="(//span[contains(text(),'Customers')])[1]")
    @CacheLookup
    private WebElement lnk_Main_Customer;

    @FindBy(xpath="(//span[contains(text(),'Customers')])[2]")
    @CacheLookup
    private WebElement lnk_Child_Customer;

    @FindBy(xpath="//a[@class='btn bg-blue']")
    @CacheLookup
    private WebElement btn_add_customer;

    @FindBy(id="Email")
    @CacheLookup
    private WebElement txtEmail;

    @FindBy(id="Password")
    @CacheLookup
    private WebElement txtPassword;

    @FindBy(id="FirstName")
    @CacheLookup
    private WebElement txtFirstName;

    @FindBy(id="LastName")
    @CacheLookup
    private WebElement txtLastName;

    @FindBy(xpath="//input[@id='Gender_Male']")
    @CacheLookup
    private WebElement rdGender;

    @FindBy(id="DateOfBirth")
    @CacheLookup
    private WebElement txtDob;

    @FindBy(xpath="(//div[@class='k-multiselect-wrap k-floatwrap'])[1]")
    @CacheLookup
    private WebElement mselectNewsletter_1;

    @FindBy(id="SelectedNewsletterSubscriptionStoreIds_taglist")
    @CacheLookup
    private WebElement mselectNewsletter_2;

    @FindBy(name="save")
    @CacheLookup
    private WebElement btnSubmit;

    @FindBy(xpath="//h1[contains(text(),'Customers')]")
    @CacheLookup
    private WebElement msg_Success;

    public void click_Parent_Customer_link()
    {
        lnk_Main_Customer.click();
    }
    public void click_Child_Customer_link()
    {
        lnk_Child_Customer.click();
    }
    public void assert_Button_is_Visible()
    {
        Assert.assertTrue(btn_add_customer.isDisplayed());
    }
    public void click_on_addcustomer_button()
    {
        btn_add_customer.click();
    }
    public void enterEmail(String email)
    {
        txtEmail.sendKeys(email);
    }

    public void enterPassword(String password)
    {
        txtPassword.sendKeys(password);
    }

    public void enterFirstName(String fname)
    {
        txtFirstName.sendKeys(fname);
    }

    public void enterLastName(String lname)
    {
        txtLastName.sendKeys(lname);
    }
    public void selectGender()
    {
        rdGender.click();
    }
    public void enterDOB(String dob)
    {
        txtDob.sendKeys(dob);
    }

    public void selectNewsLetter(String newsletter)
    {
       String searchText=newsletter;
        mselectNewsletter_1.click();
        List<WebElement> options=mselectNewsletter_2.findElements(By.tagName(("li")));
        for(WebElement option:options)
        {
            if(option.getText().equals(searchText))
            {
                option.click();
                break;
            }
        }
    }

    public void assertRegistrationSuccessful()
    {
        Assert.assertTrue(msg_Success.isDisplayed());
        ldriver.quit();
    }

     public void save_Data()
     {
         btnSubmit.click();
     }

}

