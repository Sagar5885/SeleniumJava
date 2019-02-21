package stepImplementation;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.After;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static utilities.DriverFactory.open;

public class BDDLoginTest {
    WebDriver driver;

    @Given("^user is on the login page$")
    public void user_is_on_the_login_page(){
        System.out.println("User is on login page");
        driver = open("chrome");
        driver.get("http://sdettraining.com/trguitransactions/AccountManagement.aspx");
    }

    @When("^user enters correct username and password$")
    public void user_enters_correct_username_and_password(){
        System.out.println("User enter username and password");
        driver.findElement(By.name("ctl00$MainContent$txtUserName")).sendKeys("tim@testemail.com");
        driver.findElement(By.name("ctl00$MainContent$txtPassword")).sendKeys("trpass");
        driver.findElement(By.name("ctl00$MainContent$btnLogin")).click();
    }

    @When("^user enters (.*)$")
    public void user_enters_username(String username){
        System.out.println(username);
        driver.findElement(By.name("ctl00$MainContent$txtUserName")).sendKeys(username);
    }

    @And("^user enters (.*)$")
    public void user_enters_password(String password){
        System.out.println(password);
        driver.findElement(By.name("ctl00$MainContent$txtPassword")).sendKeys(password);
        //driver.findElement(By.name("ctl00$MainContent$btnLogin")).click();
    }

    @And("^user click on login$")
    public void user_click_on_login(){
        driver.findElement(By.name("ctl00$MainContent$btnLogin")).click();
    }

    @Then("^user gets confirmation$")
    public void user_gets_confirmation(){
        System.out.println("User gets confirmation");
        String message = driver.findElement(By.id("conf_message")).getText();
        //System.out.println(message);
        Assert.assertTrue(message.contains("successfully"));
    }

    @After
    public void teardown(){
        driver.quit();
    }
}
