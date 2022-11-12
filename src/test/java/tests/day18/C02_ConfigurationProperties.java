package tests.day18;

import org.testng.annotations.Test;
import utilities.ConfigReader;
import utilities.Driver;

public class C02_ConfigurationProperties {

    @Test
    public void test01() {

        //Amazona gidelim ve facebook sayfasına gidelim
        String urlAmazon = ConfigReader.getProperty("amazonURL");
        String urlFacebook = ConfigReader.getProperty("facebookURL");

        Driver.getDriver().get(urlAmazon);
        Driver.getDriver().get(urlFacebook);

        Driver.closeDriver();

    }
}
