package tests.day22;

import org.openqa.selenium.Keys;
import org.testng.annotations.Test;
import pages.BlueRentalCarsPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;
import utilities.TestBaseRapor;

public class C01_RaporluTest extends TestBaseRapor {


    @Test
    public void test01() throws InterruptedException {

        extentTest = extentReports.createTest("BlueRentalCar", "Test ici yapilan islemler bildirilmeli.");

        BlueRentalCarsPage blueRentalCarsPage = new BlueRentalCarsPage();

        //    -https://www.bluerentalcars.com/ adresine git
        Driver.getDriver().get(ConfigReader.getProperty("blueRentalCarsURL"));
        extentTest.info("blueRentalCars sayfasina gidildi.");

        //    -login butonuna bas
        //    -test data user email: customer@bluerentalcars.com ,
        //    -test data password : 12345 dataları girip login e basın
        //    -login butonuna tiklayin
        //login butonuna tıklayın
        blueRentalCarsPage.birinciLoginButton.click();
        extentTest.info("Ilk login butonuna tiklandi.");

        Thread.sleep(3000);
        //email adres = customer@bluerentalcars.com
        //password =12345
        //Giris yapın (Enter ile)

        ReusableMethods.getActions().click(blueRentalCarsPage.email)
                .sendKeys(ConfigReader.getProperty("blueRentalCarsEmail"))
                .sendKeys(Keys.TAB).sendKeys(ConfigReader.getProperty("blueRentalCarsPassword"))
                .sendKeys(Keys.ENTER).perform();

        extentTest.info("Bilgiler dogru girilerek sisteme giris yapildi.");


        //    -Degerleri girildiginde sayfaya basarili sekilde girilebildigini test et

        System.out.println(blueRentalCarsPage.girisDogrula.getText());

        Thread.sleep(3000);
        ReusableMethods.getSoftAssert().assertTrue(blueRentalCarsPage.girisDogrula.isDisplayed());
        ReusableMethods.getSoftAssert().assertAll();
        extentTest.info("Degerlerin dogru yazilarak sisteme giris yapildigi dogrulandi.");

        //Driver.closeDriver();


    }
}
