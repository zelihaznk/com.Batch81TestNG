package tests.day16;

import org.testng.annotations.Test;
import utilities.TestBaseBeforeMethodAfterMethod;

public class C01_BeforeMethodAfterMethod extends TestBaseBeforeMethodAfterMethod {

    //TestNG framework'unde @Before ve @After notasyonları yerine  @BeforeMethod ve  @AfterMethod kullanılır
    //Çalışma prensibi JUnitdeki Before, After ile aynıdır.

    @Test(groups = "grup1")
    public void amazonTesti() {

        driver.get("https://www.amazon.com");
        driver.quit();

    }

    @Test
    public void bestBuyTesti() {

        driver.get("https://www.bestbuy.com");

    }


    @Test
    public void techproeducationTesti() {

        driver.get("https://techproeducation.com/");

    }
}
