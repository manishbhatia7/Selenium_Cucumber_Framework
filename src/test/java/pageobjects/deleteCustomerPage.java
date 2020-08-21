package pageobjects;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class deleteCustomerPage {
    WebDriver ldriver;
    public deleteCustomerPage(WebDriver rdriver)
    {
        ldriver=rdriver;
        PageFactory.initElements(rdriver,this);
    }
    @FindBy(id="SearchEmail")
    @CacheLookup
    private WebElement txtSearchEmail;

    @FindBy(id="search-customers")
    @CacheLookup
    private WebElement btnSearchCustomers;

    @FindBy(xpath="//a[@class='btn btn-default']")
    @CacheLookup
    private WebElement btnEdit;

    @FindBy(xpath="//span[@id='customer-delete']")
    @CacheLookup
    private WebElement btnDelete;

    @FindBy(xpath="//button[@class='btn bg-red pull-right']")
    @CacheLookup
    private WebElement btnAlertDelete;

    @FindBy(xpath="//div[@class='alert alert-success alert-dismissable']")
    @CacheLookup
    private WebElement msg_Success;

    @FindBy(xpath="//td[@class='dataTables_empty']")
    @CacheLookup
    private WebElement txt_Empty_Table;
    
    public void enterEmailId(String emailid)
    {
        txtSearchEmail.sendKeys(emailid);
    }
    public void enterSecondEmailId(String emailid)
    {
        txtSearchEmail.clear();
        txtSearchEmail.sendKeys(emailid);
    }

    public void clickSearchButton()
    {
        btnSearchCustomers.click();
    }
    public void clickEditButton()
    {
        btnEdit.click();
    }

    public void clickDeleteonPage()
    {
        btnDelete.click();
    }

    public void clickDeleteonAlertPage()
    {
        btnAlertDelete.click();
    }

    public void assertMessage()
    {
        Assert.assertTrue(msg_Success.isDisplayed());
    }
    public void assertEmptyRow()
    {
        Assert.assertTrue(txt_Empty_Table.isDisplayed());
    }



}
