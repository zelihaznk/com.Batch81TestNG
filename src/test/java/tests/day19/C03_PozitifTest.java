package tests.day19;

import org.openqa.selenium.Keys;
import org.testng.annotations.Test;
import pages.HotelMyCampPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;

public class C03_PozitifTest {


    @Test
    public void pozitifTest() {

        /*
        Page class'ındaki locate'lerimize ulaşabilmek için
        Page classımızdan bir obje oluşturarak, oluşturmuş olduğumuz obje ile
        page classımızdaki locate'lerimize ulaşabiliriz
        */

        //1) com.techproed altinda bir package olustur : smoketest
        //2) Bir Class olustur : PositiveTest
        //3) Bir test method olustur positiveLoginTest()
        //https://www.hotelmycamp.com adresine git


        String hotelMyCampURL = ConfigReader.getProperty("hotelmycampURL");
        Driver.getDriver().get(hotelMyCampURL);

        //login butonuna bas
        //test data username: manager ,
        //test data password : Manager1!
        //Degerleri girildiginde sayfaya basarili sekilde girilebildigini test et

        HotelMyCampPage hotelMyCampPage = new HotelMyCampPage();
        hotelMyCampPage.login.click();

        ReusableMethods.getActions().click(hotelMyCampPage.username)
                .sendKeys(ConfigReader.getProperty("usernameHotel"))
                .sendKeys(Keys.TAB).sendKeys(ConfigReader.getProperty("passwordHotel"))
                .sendKeys(Keys.TAB).sendKeys(Keys.ENTER).perform();

        /*
        hotelMyCampPage.username.sendKeys("manager");
        hotelMyCampPage.password.sendKeys("Manager1!");
        hotelMyCampPage.loginGiris.click();
         */

        ReusableMethods.getSoftAssert().assertTrue(hotelMyCampPage.basariliGiris.isDisplayed());

        /*
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(hotelMyCampPage.basariliGiris.isDisplayed());
         */

        Driver.closeDriver();




    }

}
