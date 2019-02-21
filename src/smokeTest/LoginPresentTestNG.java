package smokeTest;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import static utilities.DriverFactory.open;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginPresentTestNG {

    WebDriver driver;
    String url = "http://sdettraining.com/trguitransactions/AccountManagement.aspx";

    @Test
    public void loginElementsPresent(){
        driver.get(url);
        boolean loginEmailBox = driver.findElement(By.id("MainContent_txtUserName")).isDisplayed();
        boolean loginPasswordBox = driver.findElement(By.id("MainContent_txtPassword")).isDisplayed();
        Assert.assertTrue(loginEmailBox, "Email box is present on page!");
        Assert.assertTrue(loginPasswordBox, "Password box is present on page!");

    }

    @BeforeMethod
    public void setup(){
        System.out.println("Initialize driver in beforemethod setup method!");
        driver = open("chrome");
    }

    @AfterMethod
    public void teardown(){
        System.out.println("Close driver in aftermethod teardown method!");
        driver.close();
    }
}
