package tests;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;
import pages.LoginPageFactory;

import static utilities.DriverFactory.open;

public class LoginFactory {

    String username = "tim@testeamil.com";
    String password = "trpass";

    @Test
    public void loginPageFactoryTest(){
        WebDriver driver = open("chrome");
        driver.get("http://sdettraining.com/trguitransactions/AccountManagement.aspx");

        LoginPageFactory loginPageFactory = new LoginPageFactory(driver);
        loginPageFactory.login(username, password);
    }
}
