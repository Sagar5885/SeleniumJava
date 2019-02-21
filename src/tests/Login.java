package tests;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.DashboardPage;
import pages.LoginPage;

import static utilities.DriverFactory.open;

public class Login {

    @Test
    public void testLoginUsingPOM(){
        WebDriver driver = open("chrome");
        driver.get("http://sdettraining.com/trguitransactions/AccountManagement.aspx");

        //Login page
        LoginPage loginPage = new LoginPage(driver);
        loginPage.setUserName("tim@testemail.com");
        loginPage.setPassword("trpass");
        loginPage.submit();

        //Dashboard Page
        DashboardPage dashboardPage = new DashboardPage(driver);
        String conf = dashboardPage.confirmationMessage();
        Assert.assertTrue(conf.contains("successfully"));

        driver.quit();
    }
}
