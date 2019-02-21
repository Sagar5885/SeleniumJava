package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {

    WebDriver driver;

    public void setUserName(String userName){
        driver.findElement(By.id("MainContent_txtUserName")).sendKeys(userName);
    }

    public void setPassword(String password){
        driver.findElement(By.id("MainContent_txtPassword")).sendKeys(password);
    }

    public void submit(){
        driver.findElement(By.id("MainContent_btnLogin")).click();
    }

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }
}
