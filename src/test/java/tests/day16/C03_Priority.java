package tests.day16;

import org.testng.annotations.Test;
import utilities.TestBaseBeforeMethodAfterMethod;

public class C03_Priority extends TestBaseBeforeMethodAfterMethod {

    /*
      - @Test notasyonunun yanına (priority = sayı) yazarsak testlerin çalışma sırasını belirlemiş oluruz.
      - Önce en küçük olan çalışır
      - priority olarak herhangi bir sayı yazılmamışsa 0 olarak kabul edilir.
    */

    //Testlerimizi çalıştırırken istediğimiz sıraya göre çalışmasını istersek priority kullanırız.
    //Priority kullanmazsak default olarak 0 kabul eder. Alfabetik sıralama yapar.


    @Test (priority = 1) //Önce gitmek istersek
    public void youtubeTest() {

        driver.get("https://www.youtube.com");

        driver.quit();

    }

    @Test (priority = 3)
    public void bestbuyTest() {

        driver.get("https://www.bestbuy.com");

        driver.quit();

    }


    @Test (priority = 2)
    public void amazonTest() {

        driver.get("https://www.amazon.com/");

        driver.quit();

    }

    @Test (priority = -1, groups = "grup1")
    public void hepsiburadaTest() {

        driver.get("https://www.hepsiburada.com/");

        driver.quit();

    }


}
/*
➢ TestNG (default) olarak @Test methodlarıni alfabetik sıraya göre run eder. (Yukardan asagi degil!)

➢ priority annotation Testlere öncelik vermek için kullanılır. Kucuk olan Numara daha once calisir

➢ priority yazmayan Test method’u varsa priority= 0 kabul edilir, siralama buna gore yapilir
 */
