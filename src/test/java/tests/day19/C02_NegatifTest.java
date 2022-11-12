package tests.day19;

import org.openqa.selenium.Keys;
import org.testng.annotations.Test;
import pages.HotelMyCampPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;

public class C02_NegatifTest {
    @Test
    public void negatifTest() {

        //1 ) Bir Class olustur : NegativeTest
        //2) Bir test method olustur NegativeLoginTest()
        // https://www.hotelmycamp.com/ adresine git

        String hotelMyCampURL = ConfigReader.getProperty("hotelmycampURL");
        Driver.getDriver().get(hotelMyCampURL);

        //login butonuna bas
        //test data username: manager1 ,
        // test data password : manager1!

        HotelMyCampPage hotelMyCampPage = new HotelMyCampPage();
        hotelMyCampPage.login.click();


        ReusableMethods.getActions().click(hotelMyCampPage.username)
                .sendKeys(ConfigReader.getProperty("hotelmycampWrongUser"))
                .sendKeys(Keys.TAB).sendKeys(ConfigReader.getProperty("hotelmycampWrongPassword"))
                .sendKeys(Keys.TAB).sendKeys(Keys.ENTER).perform();


        //Degerleri girildiginde sayfaya girilemedigini test et

        ReusableMethods.getSoftAssert().assertTrue(hotelMyCampPage.hataliGiris.isDisplayed());

    }



}
