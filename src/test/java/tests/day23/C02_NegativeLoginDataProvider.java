package tests.day23;

import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.BlueRentalCarsPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;

public class C02_NegativeLoginDataProvider {

    BlueRentalCarsPage blueRentalCarsPage;

    @DataProvider
    public static Object[][] kullaniciListesi() {

        Object[][] kullaniciBilgileri = {{"ipek@nehaber.com","54875"},
                {"sum@benbuisibilirim.com","65874"},
                {"irem@hollandadanselam.com","85967"}};
        return kullaniciBilgileri;
    }

    @Test(dataProvider = "kullaniciListesi")
    public void brcYanlisGiris(String userMail,String password) throws InterruptedException {
        blueRentalCarsPage = new BlueRentalCarsPage();
        // https://www.bluerentalcars.com/ adresine git
        Driver.getDriver().get(ConfigReader.getProperty("blueRentalCarsURL"));

        //login butonuna tikla

        blueRentalCarsPage.birinciLoginButton.click();

        /*
        //user email : dataProvider'dan alalim
        blueRentalCarsPage.email.sendKeys(userMail);

        //password :dataProvider'dan alalim
        blueRentalCarsPage.password.sendKeys(password);

        //login butonuna tiklayin
        blueRentalCarsPage.ikinciLoginButton.click();

         */


        ReusableMethods.getActions().click(blueRentalCarsPage.email)
                .sendKeys(ConfigReader.getProperty("blueRentalCarsEmail"))
                .sendKeys(Keys.TAB).sendKeys(ConfigReader.getProperty("blueRentalCarsPassword"))
                .sendKeys(Keys.ENTER).perform();



        //Degerleri girildiginde sayfaya basarili bir sekilde girilemedigini test et
        Assert.assertTrue(blueRentalCarsPage.ikinciLoginButton.isDisplayed());
        Driver.closeDriver();

    }

}
