package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class TheInternetPage {

    public TheInternetPage(){

        PageFactory.initElements(Driver.getDriver(),this);

    }

    @FindBy(xpath = "//*[text()='Click Here']")
    public WebElement clickButton;

    @FindBy(xpath = "//h3")
    public WebElement newWindow;



}
