package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class FacebookPage {

    public FacebookPage(){

        PageFactory.initElements(Driver.getDriver(),this);

    }

    //email
    @FindBy(xpath = "//*[@name='email']")
    public WebElement email;

    //sifre
    @FindBy(xpath = "//*[@id='passContainer']")
    public WebElement sifre;

    //Giris
    @FindBy(xpath = "//*[@name='login']")
    public WebElement giris;

    //giris basarılı degil
    @FindBy(xpath = "//*[@class=\"_9ay7\"]")
    public WebElement hataliGiris;

}
