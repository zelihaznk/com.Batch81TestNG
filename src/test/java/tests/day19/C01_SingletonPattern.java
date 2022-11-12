package tests.day19;

import org.testng.annotations.Test;
import utilities.ConfigReader;
import utilities.Driver;

public class C01_SingletonPattern {

    @Test
    public void test01() {
        //Driver obj = new Driver();
        //obj.getDriver().get(ConfigReader.getProperty("amazonUrl"));
        /*
        SingletonPattern : tekli kullanım demektir. Bir class'ın farklı class'lardan
        obje oluşturarak kullanımını engellemektir.
         */
    }
}

//SingletonPattern : tekli kullanim demektir. Bir class'in farkli class'lardan
//obje olusturarak kullanimini engellemektir bu sebeple defoult consractir yerine
// private Driver() consraktiri ekledik
