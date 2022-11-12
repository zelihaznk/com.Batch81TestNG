package tests.day17;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import utilities.TestBaseBeforeMethodAfterMethod;

public class C03_SoftAssert extends TestBaseBeforeMethodAfterMethod {

    @Test
    public void test01() {
        /*
        SoftAssert baslangic ve bitis satirlari arasindaki tum assertion'lari yapip
        bitis olarak belirtmemiz gereken assertAll() methoduyla test methodumuzdaki
        butun assertion'lari kontrol eder. Failed olan olursa assertion yaptigimiz
        methodun sonuna yazdigimiz mesaji bize konsolda verir.
        */

        //• 1.Adım: SoftAssert objesi olusturalim
        SoftAssert softAssert = new SoftAssert();

        //• 2.Adım: Istedigimiz sayida verification’lari yapalim

        //1-amazon anasayfaya gidin
        driver.get("https://amazon.com");

        //2-title in Amazon içerdigini test edin
        softAssert.assertTrue(driver.getTitle().contains("Amazon"),"Girdiginiz kelimeyi icermiyor");

        //3-arama kutusnun erişilebilir oldugunu tets edin
        WebElement aramaKutusu = driver.findElement(By.id("twotabsearchtextbox"));
        softAssert.assertTrue(aramaKutusu.isEnabled(),"WE erisilemez");

        //4-arama kutusuna Nuella yazıp aratın
        aramaKutusu.sendKeys("Nutella", Keys.ENTER);

        //5-arama yapıldıgını test edin
        WebElement sonuc = driver.findElement(By.xpath("//*[@class='a-section a-spacing-small a-spacing-top-small']"));
        softAssert.assertTrue(sonuc.isDisplayed(),"Sonuc WE goruntulenemedi");

        //6-arama sonucunun Nutella içerdigini test edin
        softAssert.assertTrue(sonuc.getText().contains("Nutella"),"Nutella icermiyor".toUpperCase());

        //• 3.Adım: SoftAssert’in durumu raporlamasini isteyelim
        softAssert.assertAll();//Testtin herhangi bir yerinde eğer hata varsa bile yani assert yanlış olsa bile bu kısma kadar çalışır

    }

}
/*
Soft Assert
• 1.Adım: SoftAssert objesi olusturalim
SoftAssert softAssert = new SoftAssert( );
• 2.Adım: Istedigimiz sayida verification’lari yapalim
softAssert.assertTrue( );
softAssert.assertFalse( ); ….
• 3.Adım: SoftAssert’in durumu raporlamasini isteyelim
softAssert.assertAll();

 */

/*
// Hard Assertions : JUNit'te öğrendiğimiz assertion ile aynıdır.  Assert.assertTrue();  Assert.assertFalse();  Assert.assertEquals();
// Hard Assertions'da herhangi bir assertion failed olursa, test method'un çalışmasını durdurur ve kalan kodları yürütmez.(stop execution)

// Soft Assert : Kullanabilmek için obje oluştururuz, oluşturduktan sonra obje ismi ile kullanırız, Herhangi bir hata verdiğinde test methodu
// çalışmaya devam eder, en sonra rapor verir.    baslangıc  SoftAssert objeadı=new SoftAssert();  bitis objeadı.assertAll();
 */