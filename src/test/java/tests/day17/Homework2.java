package tests.day17;

import com.github.javafaker.Faker;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import utilities.TestBaseBeforeMethodAfterMethod;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Homework2 extends TestBaseBeforeMethodAfterMethod {

    @Test
    public void test01() {

        //Yeni bir Class Olusturun : C03_SoftAssert
        //1. “http://zero.webappsecurity.com/” Adresine gidin
        driver.navigate().to("http://zero.webappsecurity.com/");

        //2. Sign in butonuna basin
        driver.findElement(By.xpath("//*[@id='signin_button']")).click();

        //3. Login kutusuna “username” yazin
        //4. Password kutusuna “password” yazin
        //5. Sign in tusuna basin
        WebElement username= driver.findElement(By.xpath("//*[@id='user_login']"));
        faker = new Faker();
        actions.click(username).sendKeys("username")
                .sendKeys(Keys.TAB).sendKeys("password").sendKeys(Keys.ENTER).perform();

        //Güvenli bağlantı yazısı için tekrar sayfaya gidildi
        driver.navigate().to("http://zero.webappsecurity.com/");

        //6. Online banking menusu icinde Pay Bills sayfasina gidin
        driver.findElement(By.xpath("//*[text()='Online Banking']")).click();
        driver.findElement(By.xpath("//*[text()='Pay Bills']")).click();

        //7. “Purchase Foreign Currency” tusuna basin
        driver.findElement(By.xpath("//*[text()='Purchase Foreign Currency']")).click();

        //8. “Currency” drop down menusunden Eurozone’u secin
        WebElement currencyDDM = driver.findElement(By.xpath("//*[@id='pc_currency']"));
        Select select = new Select(currencyDDM);
        select.selectByVisibleText("Eurozone (euro)");

        //9. soft assert kullanarak "Eurozone (Euro)" secildigini test edin
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertNotEquals(select.getFirstSelectedOption().getText(), "Eurozone (Euro)", "Eurozone (euro) secilemedi");

        //10. soft assert kullanarak DropDown listesinin su secenekleri oldugunu test edin
        //"Select One", "Australia (dollar)", "Canada (dollar)","Switzerland (franc)","China
        //(yuan)","Denmark (krone)","Eurozone (euro)","Great Britain (pound)","Hong Kong
        //(dollar)","Japan (yen)","Mexico (peso)","Norway (krone)","New Zealand
        //(dollar)","Sweden (krona)","Singapore (dollar)","Thailand (baht)"

        List<WebElement> ddmList = select.getOptions();

        List<String> expectedDdm = new ArrayList<>(Arrays.asList("Select One",
                "Australia (dollar)", "Canada (dollar)", "Switzerland (franc)",
                "China (yuan)", "Denmark (krone)", "Eurozone (euro)",
                "Great Britain (pound)", "Hong Kong (dollar)", "Japan (yen)",
                "Mexico (peso)", "Norway (krone)", "New Zealand (dollar)",
                "Sweden (krona)", "Singapore (dollar)", "Thailand (baht)"));

        for (int i = 0; i < ddmList.size(); i++) {

            softAssert.assertEquals(ddmList.get(i).getText(), expectedDdm.get(i), "Dropdown secenekleri beklenen liste ile esit degil");
        }
        softAssert.assertAll();

        driver.close();

    }
}
