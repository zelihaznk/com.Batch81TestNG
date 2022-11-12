package utilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.opera.OperaDriver;
import org.openqa.selenium.safari.SafariDriver;

import java.time.Duration;

public class CrossDriver {

    //BU classı xml ile baglanti kurup istedigimiz browser da calistirabilmek icn duzenledik

    private CrossDriver() {

    }

    static WebDriver driver;

    public static WebDriver getDriver(String browser) {
        //Testlerimizi xml file'dan farkli browserlar ile calistirabilmek icin getDriver() methoduna
        //parametre atmamiz geekir

        browser = browser == null ? ConfigReader.getProperty("browser") : browser;
        //Eger browser'a bir deger atanmamissa properties dosyasinda tanimli browser kullanilir .

        if (driver == null) {

            switch (browser) {
                //CrossBrowser icin bizim gönderdigimiz browser uzerinden calismasi icin
                //buraya parametre olarak girdigimiz degeri yazdik


                case "chrome" :  //browser kısmı değiştirilebilir hangisini istersek onun ayarlamasını yaparız
                    WebDriverManager.chromedriver().setup();
                    driver = new ChromeDriver();
                    break;
                case "edge" :
                    WebDriverManager.edgedriver().setup();
                    driver= new EdgeDriver();
                    break;
                case "safari" :
                    WebDriverManager.safaridriver().setup();
                    driver=new SafariDriver();
                    break;
                case "firefox" :
                    WebDriverManager.firefoxdriver().setup();
                    driver = new FirefoxDriver();
                    break;
                case "headless-chrome" :
                    WebDriverManager.chromedriver().setup();
                    driver = new ChromeDriver(new ChromeOptions().setHeadless(true));
                    break;
                case "opera":
                    WebDriverManager.operadriver().setup();
                    driver=new OperaDriver();
                    break;
                default:
                    WebDriverManager.chromedriver().setup();
                    driver = new ChromeDriver();

            }
        }
        return driver;
    }

    public static void closeDriver() {

        if (driver != null) {
            driver.close();
            driver = null;
        }
    }
}