package tests.day23;

import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.AmazonPage;
import utilities.ConfigReader;
import utilities.Driver;

public class C01_DataProvider {

    AmazonPage amazonPage;

    @DataProvider  //site içinde aratmak istediğimiz kelimeleri tek tek (ana sayfaya dönerek yeniden) aratmak için
                   //oluşturduğumuz method'dur.
    public static Object[][] AranacakKelimeler() {
        return new Object[][]{{"java"},{"selenium"},{"samsung"},{"iphone"}};
    }

    @Test (dataProvider = "AranacakKelimeler") // once bunu olusturduk altini cizdi ustteki kısmı olusturduk
                                    /* arayacagimiz kelimeleri bir liste gibi tutup
                                     bana yollayacak bir veri saglayicisi olusturacagiz*/

    public void test02(String kelimeler){
        amazonPage = new AmazonPage();

        //amazon anasayfaya gidelim

        Driver.getDriver().get(ConfigReader.getProperty("amazonURL"));

        //Nutella, Java, cigdem ve Netherlands icin arama yapalim

        try { //Bazen açılan hatalı sayfaları önlemek için yapıldı
            amazonPage.aramaKutusu.sendKeys(kelimeler, Keys.ENTER);
        } catch (Exception e) {
            Driver.getDriver().navigate().refresh();
        }


        //amazonPage.aramaKutusu.sendKeys(kelimeler+ Keys.ENTER);

        // Sonuclarin aradigimiz kelime icerdigini test ederlim

        String actualKelime = amazonPage.aramaSonucuElementi.getText();
        Assert.assertTrue(actualKelime.contains(kelimeler));
        Driver.closeDriver();

    }

    @Test(dependsOnMethods = "test02")
    public void test03() {
        Driver.quitDriver();

    }
}
/*@DataProvider bir TestNG annotation’idir.
Dolayisiyla sadece TestNG ile kullanilir.
Veri sağlamak için kullanılır.
DDT (Data Driven Test) yapilir.*/
