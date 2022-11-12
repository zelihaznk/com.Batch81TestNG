package tests.day20;

import org.openqa.selenium.Keys;
import org.testng.annotations.Test;
import pages.HotelMyCampPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;

public class C02_SmokeNegatifTest {

    @Test
    public void yanlisKullanici() {// 1.Senoryo: yanlış kullanıcı, doğru şifre

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
                .sendKeys(Keys.TAB).sendKeys(ConfigReader.getProperty("passwordHotel"))
                .sendKeys(Keys.TAB).sendKeys(Keys.ENTER).perform();


        //Degerleri girildiginde sayfaya girilemedigini test et

        ReusableMethods.getSoftAssert().assertTrue(hotelMyCampPage.hataliGiris.isDisplayed());

    }

    @Test
    public void yanlisSifre() {//2.Seneryo: Doğru kullanıcı, Yanlış Şifre

        // https://www.hotelmycamp.com/ adresine git

        String hotelMyCampURL = ConfigReader.getProperty("hotelmycampURL");
        Driver.getDriver().get(hotelMyCampURL);

        //login butonuna bas
        //test data username: manager1 ,
        // test data password : manager1!

        HotelMyCampPage hotelMyCampPage = new HotelMyCampPage();
        hotelMyCampPage.login.click();

        ReusableMethods.getActions().click(hotelMyCampPage.username)
                .sendKeys(ConfigReader.getProperty("usernameHotel"))
                .sendKeys(Keys.TAB).sendKeys(ConfigReader.getProperty("hotelmycampWrongPassword"))
                .sendKeys(Keys.TAB).sendKeys(Keys.ENTER).perform();


        //Degerleri girildiginde sayfaya girilemedigini test et

        ReusableMethods.getSoftAssert().assertTrue(hotelMyCampPage.hataliGiris.isDisplayed());



    }

    @Test
    public void yanlisKullaniciSifre() { // 3. Senoryo: Yanlış kullanıcı, Yanlış şifre

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
