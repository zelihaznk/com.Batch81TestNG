package tests.day20;

import org.openqa.selenium.Keys;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;
import pages.HotelMyCampPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;

public class C03_E2ETest {  //Baştan sona tüm sitenin test edildiği teste E2ETest denir

    @Test
    public void E2ETest() throws InterruptedException {

        //3. https://www.hotelmycamp.com adresine git.
        Driver.getDriver().get(ConfigReader.getProperty("hotelmycampURL"));

        HotelMyCampPage hotelMyCampPage = new HotelMyCampPage();
        hotelMyCampPage.login.click();

        //4. Username textbox ve password metin kutularını locate edin ve asagidaki verileri girin.
        //a. Username : manager
        //b. Password : Manager1!
        //5. Login butonuna tıklayın.

        ReusableMethods.getActions().click(hotelMyCampPage.username)
                .sendKeys(ConfigReader.getProperty("usernameHotel"))
                .sendKeys(Keys.TAB).sendKeys(ConfigReader.getProperty("passwordHotel"))
                .sendKeys(Keys.TAB).sendKeys(Keys.ENTER).perform();

        //Hotel Management/Room reservation menusunden ADD ROOM RESERVATION butonuna tiklayin
        hotelMyCampPage.hotelManagementButton.click();
        Thread.sleep(1000);
        hotelMyCampPage.roomReservatios.click();

        //Açılan sayfadaki tüm metin kutularına istediğiniz verileri girin.
        hotelMyCampPage.addRoomReservation.click();

        ReusableMethods.select(hotelMyCampPage.idUser).selectByVisibleText("manager");
        ReusableMethods.getActions().sendKeys(Keys.TAB).sendKeys("Happy Hotel").
                sendKeys(Keys.TAB).sendKeys("1500").sendKeys(Keys.TAB).sendKeys("10/02/2022")
                .sendKeys(Keys.TAB).sendKeys(Keys.TAB).sendKeys("10/13/2022").
                sendKeys(Keys.TAB).sendKeys(Keys.TAB).sendKeys("2").sendKeys(Keys.TAB).sendKeys("2")
                .sendKeys(Keys.TAB).sendKeys(ReusableMethods.getFaker().name().fullName()).sendKeys(Keys.TAB).
                sendKeys(ReusableMethods.getFaker().phoneNumber().cellPhone()).sendKeys(Keys.TAB)
                .sendKeys(ReusableMethods.getFaker().internet().emailAddress()).sendKeys(Keys.TAB).sendKeys("skajdlaksjdaasd")
                .sendKeys(Keys.TAB).sendKeys(Keys.SPACE).sendKeys(Keys.TAB).sendKeys(Keys.TAB)
                .sendKeys(Keys.ENTER).perform();

        //Save butonuna tıklayın.
        //“RoomReservation was inserted successfully” textinin göründüğünü test edin.
        //OK butonuna tıklayın.

        ReusableMethods.getSoftAssert().assertTrue(hotelMyCampPage.roomReservationSuccessfully.isDisplayed());
        hotelMyCampPage.okButton.click();


    }
}
/*
        Driver.select(hotelMyCampPage.idUser).selectByVisibleText("manager");
        Driver.select(hotelMyCampPage.idHotelRoom).selectByVisibleText("Happy Hotel");
        hotelMyCampPage.price.sendKeys("15$");
        hotelMyCampPage.dateStart.sendKeys("01.10.2022");
        Thread.sleep(5000);
        hotelMyCampPage.dateEnd.sendKeys("10.10.2022");


        Driver.getActions().click(hotelMyCampPage.adultAmount).sendKeys("4")
                .sendKeys(Keys.TAB).sendKeys("2")
                .sendKeys(Keys.TAB).sendKeys(Driver.getFaker().name().fullName())
                .sendKeys(Keys.TAB).sendKeys(Driver.getFaker().phoneNumber().cellPhone())
                .sendKeys(Keys.TAB).sendKeys(Driver.getFaker().internet().emailAddress())
                .sendKeys(Keys.TAB).sendKeys("Lutfen belirtilen tarihe hazir olsun")
                .sendKeys(Keys.TAB).sendKeys(Keys.SPACE)
                .sendKeys(Keys.TAB).sendKeys(Keys.TAB)
                .sendKeys(Keys.ENTER).perform();

         */

 /*
         actions.sendKeys(Keys.TAB).sendKeys("Happy Hotel").
                sendKeys(Keys.TAB).sendKeys("1500").sendKeys(Keys.TAB).sendKeys("10/02/2022")
                .sendKeys(Keys.TAB).sendKeys(Keys.TAB).sendKeys("10/13/2022").
                sendKeys(Keys.TAB).sendKeys(Keys.TAB).sendKeys("2").sendKeys(Keys.TAB).sendKeys("2")
                .sendKeys(Keys.TAB).sendKeys(faker.name().fullName()).sendKeys(Keys.TAB).
                sendKeys(faker.phoneNumber().cellPhone()).sendKeys(Keys.TAB)
                .sendKeys(faker.internet().emailAddress()).sendKeys(Keys.TAB).sendKeys("skajdlaksjdaasd")
                .sendKeys(Keys.TAB).sendKeys(Keys.SPACE).sendKeys(Keys.TAB).sendKeys(Keys.TAB)
                .sendKeys(Keys.ENTER).perform();
         */