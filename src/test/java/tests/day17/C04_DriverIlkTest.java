package tests.day17;

import org.testng.annotations.Test;
import utilities.Driver;

public class C04_DriverIlkTest {
    /*
    TestBase class'ına extend ederek kullandığımız driver yerine artık Driver class'ında kullanacağımız
    getDriver() static methodunu kullanırız.
     */

    @Test
    public void test01() {

        Driver.getDriver().get("https://amazon.com");
        Driver.getDriver().get("https://bestbuy.com");

        Driver.quitDriver();

        Driver.getDriver().get("https://hepsiburada.com");

        Driver.closeDriver();

        Driver.getDriver().get("https://www.facebook.com");

        Driver.closeDriver();

    }
}
