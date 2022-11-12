package tests.day22;

import org.openqa.selenium.Keys;
import org.testng.annotations.Test;
import pages.BlueRentalCarsPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;
import utilities.TestBaseRapor;

public class C01_NegatifRaporluTest extends TestBaseRapor {


    BlueRentalCarsPage blueRentalCarsPage = new BlueRentalCarsPage();

    @Test
    public void bluerentalCarsNegatifTest() {
        extentTest = extentReports.createTest("BlueRentalCar", "Test ici yapilan islemler bildirilmeli.");

        //blurentalcars anasayfasına gidin

        String blueRentalCarsURL = ConfigReader.getProperty("blueRentalCarsURL");
        Driver.getDriver().get(blueRentalCarsURL);
        extentTest.info("blueRentalCars sayfasina gidildi.");

        //login butonuna tıklayın
        blueRentalCarsPage.birinciLoginButton.click();
        extentTest.info("Ilk login butonuna tiklandi.");

        //email adres = customer@bluerentalcars.com
        //password =12345
        //Giris yapın (Enter ile)
        ReusableMethods.getActions().click(blueRentalCarsPage.email)
                .sendKeys(ConfigReader.getProperty("blueRentalCarsWrongEmail"))
                .sendKeys(Keys.TAB).sendKeys(ConfigReader.getProperty("blueRentalCarsWrongPassword"))
                .sendKeys(Keys.ENTER).perform();
        extentTest.info("Hatali giris bilgili");

        //Değerler girilemediğini test edin
        ReusableMethods.getSoftAssert().assertTrue(blueRentalCarsPage.ikinciLoginButton.isDisplayed());
        extentTest.fail("Giris hatalidir");

        Driver.closeDriver();

        //eğer hata raporu alırsak ve raporda resmi görüntülemek istersek rapor üzerine sağ click
        //open, explorer secip resimli raporu görüntüleyebiliriz.
    }

}
