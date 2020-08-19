package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class loginPage {
    WebDriver ldriver;
    public loginPage(WebDriver rdriver)
    {
        ldriver=rdriver;
        PageFactory.initElements(rdriver,this);
    }
    @FindBy(id="Email")
    @CacheLookup
    private WebElement username;

    @FindBy(id="Password")
    @CacheLookup
    private WebElement password;

    @FindBy(xpath ="//input[@value='Log in']" )
    @CacheLookup
    private WebElement btnSubmit;

    public void enterUserName(String user)
    {
        username.clear();
        username.sendKeys(user);
    }

    public void enterPassword(String pwd)
    {
        password.clear();
        password.sendKeys(pwd);
    }

    public addCustomerPage submitCredentials()
    {
        btnSubmit.click();
        return new addCustomerPage(ldriver);
    }


}
