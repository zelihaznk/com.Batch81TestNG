package tests.day17;

import org.testng.annotations.Test;
import utilities.TestBaseBeforeMethodAfterMethod;

public class C01_DependsOnMethods extends TestBaseBeforeMethodAfterMethod {

    @Test
    public void test01() {

        driver.get("https://amazon.com");

    }

    @Test (dependsOnMethods = "test01")
    public void test02() {

        driver.get("https://www.facebook.com/");

    }

    @Test (dependsOnMethods = "test02")
    public void test03() {

        driver.get("https://bestbuy.com");

    }

    @Test (priority = -1)
    public void test04() {

        driver.get("https://youtube.com");


    }
}

/*
dependsOnMethods
➢ Bu yontem, bir metodun diğer bir metoda bağlı olmasını sağlamak için kullanılır.

➢ Yandaki ornekte, amazonAnasayfaTest metdod’u  amazonTest method’una bağlıdır. Yani, amazonTest
başarılı olursa amazonAnasayfaTest de çalisacaktir.

➢ Diger durumda yani, amazonTest başarısız olursa  amazonAnasayfaTest ignore edilecek, hic
çalismayacaktir.

➢ Yalnızca amazonAnasayfaTest method’unu çalıştırırsak bile, TestNG önce amazonTest metodunu
çalıştırır. amazonTest başarılı olursa searchTest yürütülür

➢ Ustteki madde sadece 2 method icin gecerlidir. 3 method’u birbirine baglayip 3.method’u calistirirsaniz,
1.method’a kadar gitmez.
 */
