package tests.day18;

import com.github.javafaker.Faker;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.FacebookPage;
import utilities.ConfigReader;
import utilities.Driver;

public class C01_PageClassFacebookTest {

    @Test
    public void test01() {

        //https://www.facebook.com/ adresine gidin
        Driver.getDriver().get(ConfigReader.getProperty("facebookURL"));


        //POM’a uygun olarak email, sifre kutularini ve giris yap
        //butonunu locate edin
        //Faker class’ini kullanarak email ve sifre degerlerini
        //yazdirip, giris butonuna basin


        FacebookPage facebookPage = new FacebookPage();
        Faker faker = new Faker();
        Actions actions = new Actions(Driver.getDriver());

        actions.click(facebookPage.email).sendKeys(faker.internet().emailAddress())
                .sendKeys(Keys.TAB).sendKeys(faker.internet().password())
                .sendKeys(Keys.ENTER).perform();


        //Basarili giris yapilamadigini test edin
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(facebookPage.hataliGiris.isEnabled());

        /* Bilgileri yazdırmak için
         String mail=faker.internet().emailAddress();
        String sifre=faker.internet().password();
        facebookPage.email.sendKeys(mail);
        facebookPage.sifre.sendKeys(sifre);
        System.out.println("mail = " + mail);
        System.out.println("sifre = " + sifre);
         */

    }
}
