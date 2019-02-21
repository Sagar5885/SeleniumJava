package demos;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Login {
    public static void main(String args[]){
        //Define the web driver
        System.setProperty("webdriver.chrome.driver", "/Users/sdodia/Downloads/chromedriver");
        WebDriver driver = new ChromeDriver();

        //Open Browser & Navigate to Page
        driver.get("http://sdettraining.com/trguitransactions/AccountManagement.aspx");

        //Enter Email
        driver.findElement(By.name("ctl00$MainContent$txtUserName")).sendKeys("tim@testemail.com");

        //Enter Password
        driver.findElement(By.name("ctl00$MainContent$txtPassword")).sendKeys("trpass");

        //Click Login
        driver.findElement(By.name("ctl00$MainContent$btnLogin")).click();

        //Get Confirmation
        String message = driver.findElement(By.id("conf_message")).getText();
        System.out.println(message);

        String title = driver.getTitle();
        if(title.equals("SDET Training | Account Management")){
            System.out.println("Page title pass!");
        }

        //Close Browser
        driver.close();
    }
}
