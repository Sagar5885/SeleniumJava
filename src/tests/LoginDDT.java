package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static utilities.ExcelReader.get1;

public class LoginDDT {

    WebDriver driver;

    @Test(dataProvider = "getData")
    public void testLogin(String name, String email, String password){
        //System.out.println("Name: "+name+"   Email: "+email+"   Password: "+password); //Test Data Provider

        driver.findElement(By.name("ctl00$MainContent$txtUserName")).sendKeys(email);
        driver.findElement(By.name("ctl00$MainContent$txtPassword")).sendKeys(password);
        driver.findElement(By.name("ctl00$MainContent$btnLogin")).click();

        //Get Confirmation
        String message = driver.findElement(By.id("conf_message")).getText();
        System.out.println(message);


    }

    @BeforeMethod
    public void setup(){
        driver = new ChromeDriver();
        driver.get("http://sdettraining.com/trguitransactions/AccountManagement.aspx");
    }

    @AfterMethod
    public void teardown(){
        driver.quit(); //quit close all resources and close only close browser
    }

    @DataProvider
    public Object[][] getData(){
        return get1("/Users/sdodia/Desktop/SeleniumProjectJava/UserLogin.xls");
    }
}
