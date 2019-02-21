package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

import static utilities.DriverFactory.open;

public class Expedia {

    WebDriver driver;
    String city = "New York, NY";
    String checkin = "10/02/2019";
    String checkout = "10/09/2019";
    //String noOfGuests = "2";
    String rating = "star4";
    String searchResult = "3";

    @Test
    public void hotalReservation(){
        driver.findElement(By.id("tab-hotel-tab-hp")).click();
        driver.findElement(By.id("hotel-destination-hp-hotel")).clear();
        driver.findElement(By.id("hotel-destination-hp-hotel")).sendKeys(city);
        driver.findElement(By.id("hotel-checkin-hp-hotel")).clear();
        driver.findElement(By.id("hotel-checkin-hp-hotel")).sendKeys(checkin);
        driver.findElement(By.id("hotel-checkout-hp-hotel")).clear();
        driver.findElement(By.id("hotel-checkout-hp-hotel")).sendKeys(checkout);
        //new Select(driver.findElement(By.id("traveler-selector-hp-hotel"))).selectByValue(noOfGuests);
        driver.findElement(By.xpath("//*[@id=\"gcw-hotel-form-hp-hotel\"]/div[10]/label/button")).click();

        //Print name of city
        String cityAct = driver.findElement(By.id("hotelResultTitle")).getText();
        System.out.println(cityAct);

        //Modify Search Result
        driver.findElement(By.cssSelector("#"+rating+"")).click();

        //Select 3 item from Search result
        driver.findElement(By.xpath("//*[@id=\"resultsContainer\"]/section/article["+searchResult+"]/div[2]/div/a")).click(); //TODO: We build this xpath not copied

        //Tell WebDriver Switch Windows or Popup
        ArrayList<String> windows = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(windows.get(1));

        System.out.println(driver.findElement(By.xpath("//*[@id=\"hotel-name\"]")).getText());
        //System.out.println(driver.findElement(By.xpath("/html/body/div[3]/div[9]/section/section/div[3]/article/div/div[1]/table/tbody/tr/td[1]/div/div[3]/div[2]/span[1]")).getText());

        //Reserve It
        driver.findElement(By.xpath("//*[@id=\"rooms-and-rates\"]/div/article/table/tbody[1]/tr[1]/td[4]/div/form/div[1]/button")).click();
    }

    @BeforeMethod
    public void setup(){
        driver = open("chrome");
        driver.manage().timeouts().implicitlyWait(7, TimeUnit.SECONDS);
        driver.get("https://www.expedia.com/");
    }

    @AfterMethod
    public void teardown(){
        driver.quit();
    }
}
