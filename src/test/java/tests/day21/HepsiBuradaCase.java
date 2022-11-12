package tests.day21;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;
import pages.HepsiBuradaPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;


import java.io.IOException;

public class HepsiBuradaCase {

    HepsiBuradaPage hepsiBuradaPage;

    @Test
    public void hepsiburda() throws IOException {

        // Hepsiburada sayfasına gidiniz
        // Elektronik altında bilgisayar/tablet altındaki tüm linkleri tıklayalım
        // Her linkten sonra o sayfaya gittimizi test edelim ve o sayfanız resmini alalım
        // Sayfayı kapatalım

        hepsiBuradaPage = new HepsiBuradaPage();

        Actions actions = new Actions(Driver.getDriver());

        Driver.getDriver().get(ConfigReader.getProperty("hepsiburadaURL"));

        ilkIkiTiklama(); // method

        int count = 1;
        for (int i = 0; i < hepsiBuradaPage.kucukAltBasliklar.size(); i++) {


            hepsiBuradaPage.kucukAltBasliklar.get(i).click();

            // actions.sendKeys(Keys.PAGE_DOWN).perform();   // sayfayi kaydir

            ReusableMethods.getScreenshot("SS" + count);
            ReusableMethods.waitFor(1);
            count++;


            Driver.getDriver().navigate().back(); //sayfa geri
            ReusableMethods.waitFor(2);


            ilkIkiTiklama(); // method
        }
    }


    public void ilkIkiTiklama() { //method

        //Elektronikten Bilgisayar/Tablet sec
        ReusableMethods.getActions().moveToElement(hepsiBuradaPage.elektronics).perform();
        ReusableMethods.waitFor(1);

        ReusableMethods.getActions().moveToElement(hepsiBuradaPage.bilgisayarTablet).perform();
        ReusableMethods.waitFor(1);
    }
}

/*
 driver.get("https://www.hepsiburada.com/");

        WebElement elektronik = driver.findElement(By.xpath("//li[@class='sf-MenuItems-WulWXvlfIAwNiOUGY7FP']"));

        Actions actions = new Actions(driver);
        actions.moveToElement(elektronik).perform();

        WebElement bilgisayarTablet = driver.findElement(By.xpath("//a[normalize-space()='Bilgisayar/Tablet']"));
        WebElement dizüstüBilgisayar = driver.findElement(By.xpath("//*[text()='Dizüstü Bilgisayar']"));
        WebElement notebook = driver.findElement(By.xpath("//*[text()='Notebook']"));
        WebElement oyunBilgisayari = driver.findElement(By.xpath("//*[text()='Oyun Bilgisayarları']"));
        WebElement grafikTablet  = driver.findElement(By.xpath("//*[text()='Grafik Tablet']"));
        WebElement huion = driver.findElement(By.xpath("//*[text()='Huion']"));


        actions.dragAndDrop(elektronik,bilgisayarTablet)
                .dragAndDrop(dizüstüBilgisayar,bilgisayarTablet).sendKeys(Keys.DOWN).dragAndDrop(bilgisayarTablet,notebook)
                .sendKeys(Keys.RIGHT).dragAndDrop(notebook,oyunBilgisayari).sendKeys(Keys.RIGHT).sendKeys(Keys.DOWN)
                .dragAndDrop(oyunBilgisayari,grafikTablet).sendKeys(Keys.DOWN).dragAndDrop(grafikTablet,huion).click(huion)
                .perform();

 */
