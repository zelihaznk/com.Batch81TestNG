package utilities;

import com.github.javafaker.Faker;
import io.github.bonigarcia.wdm.WebDriverManager;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.asserts.SoftAssert;

import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public abstract class TestBaseBeforeClassAfterClass {

    protected WebDriver driver;
    protected Actions actions;
    protected Faker faker;
    protected String tarih;
    protected LocalDateTime date;

    protected SoftAssert softAssert;


    // @BeforeClass ve @AfterClass notasyonlarını TestNG de kullanırken JUnit'teki gibi static yapmaya gerek yoktur

    @BeforeClass(groups = "grup1")
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        actions = new Actions(driver);
        faker = new Faker();

        date = LocalDateTime.now();
        DateTimeFormatter formater = DateTimeFormatter.ofPattern("YYYYMMddHHmmss");
        tarih = date.format(formater);

        softAssert = new SoftAssert();

    }

    @AfterClass(groups = "grup1")
    public void tearDown(){
        // driver.quit();
    }
}
