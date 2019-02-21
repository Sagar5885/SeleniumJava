package demos;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

import static utilities.DriverFactory.open;

public class CreateAccount {
    public static void main(String args[]){
        //Parameters
        String name = "Mary Smith";
        String email = "ms@testemail.com";
        String phone = "1231231234";
        String password = "mspass";
        String country = "United States";
        String browserType = "chrome";
        Boolean weeklyEmail = true;

        //Define Web Driver
        WebDriver driver = open(browserType);

        driver.get("http://sdettraining.com/trguitransactions/AccountManagement.aspx");
        driver.findElement(By.xpath("/html/body/form/div[3]/div[2]/div/div[2]/a")).click();

        //Define Web Elements
        WebElement nameElement = driver.findElement(By.name("ctl00$MainContent$txtFirstName"));
        WebElement emailElement = driver.findElement(By.id("MainContent_txtEmail"));
        WebElement phoneElement = driver.findElement(By.xpath("//*[@id=\"MainContent_txtHomePhone\"]"));
        WebElement passElement = driver.findElement(By.cssSelector("#MainContent_txtPassword"));
        WebElement passreElement = driver.findElement(By.name("ctl00$MainContent$txtVerifyPassword"));
        WebElement radioBtn = driver.findElement(By.id("MainContent_Female"));
        WebElement countryElement = driver.findElement(By.id("MainContent_menuCountry"));
        WebElement weeklyCheckbox = driver.findElement(By.name("ctl00$MainContent$checkWeeklyEmail"));

        nameElement.sendKeys(name);
        emailElement.sendKeys(email);
        phoneElement.sendKeys(phone);
        passElement.sendKeys(password);
        passreElement.sendKeys(password);
        radioBtn.click();
        new Select(countryElement).selectByVisibleText(country);

        if(weeklyEmail){
            if(!weeklyCheckbox.isSelected()) {
                weeklyCheckbox.click();
            }
        }else{
            if(weeklyCheckbox.isSelected()){
                weeklyCheckbox.click();
            }
        }
        driver.findElement(By.id("MainContent_btnSubmit")).click();


        //Confirmation
        String confirmation = driver.findElement(By.id("MainContent_lblTransactionResult")).getText();
        System.out.println(confirmation);

        //Close Browser
        driver.close();
    }
}
