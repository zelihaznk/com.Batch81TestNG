package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class HotelMyCampPage {

    public HotelMyCampPage(){

        PageFactory.initElements(Driver.getDriver(),this);

    }

    @FindBy(xpath = "(//*[@class='nav-link'])[7]")
    public WebElement login;

    @FindBy(xpath = "//*[@id='UserName']")
    public WebElement username;

    @FindBy(xpath = "//*[@id='Password']")
    public WebElement password;

    @FindBy(xpath = "//*[@id='btnSubmit']")
    public WebElement loginGiris;

    @FindBy(xpath = "//*[@data-close-others='true']")
    public WebElement basariliGiris;

    @FindBy(xpath = "//*[@id='divMessageResult']")
    public WebElement hataliGiris;

    @FindBy(xpath = "//*[text()='Hotel Management']")
    public WebElement hotelManagementButton;

    @FindBy(xpath = "(//*[@href=\"/admin/RoomReservationAdmin\"])[1]")
    public WebElement roomReservatios;

    @FindBy(xpath = "//*[text()='Add Room Reservation ']")
    public WebElement addRoomReservation;

    @FindBy(xpath = "//*[@id='IDUser']")
    public WebElement idUser;

    @FindBy(xpath = "//*[text()='RoomReservation was inserted successfully']")
    public WebElement roomReservationSuccessfully;

    @FindBy(xpath = "//*[text()='OK']")
    public WebElement okButton;






    @FindBy(xpath = "//*[@id='IDHotelRoom']")
    public WebElement idHotelRoom;

    @FindBy(xpath = "//*[@id='Price']")
    public WebElement price;

    @FindBy(xpath = "//*[@id='DateStart']")
    public WebElement dateStart;

    @FindBy(xpath = "//*[@id='DateEnd']")
    public WebElement dateEnd;

    @FindBy(xpath = "//*[@id='AdultAmount']")
    public WebElement adultAmount;

    @FindBy(xpath = "//*[@id='Approved']")
    public  WebElement approved;

    @FindBy(xpath = "IsPaid")
    public WebElement isPaid;

    @FindBy(xpath = "//*[@id='btnSubmit']")
    public WebElement save;
}
