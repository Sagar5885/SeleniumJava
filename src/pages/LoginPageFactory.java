package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPageFactory {

    WebDriver driver;

    //Define Webelement at class level
    @FindBy(id ="MainContent_txtUserName")
    WebElement userNameBox;

    @FindBy(id ="MainContent_txtPassword")
    WebElement passwordBox;

    @FindBy(id ="MainContent_btnLogin")
    WebElement login;

    //Steps
    public void setUserName(String userName){
        userNameBox.sendKeys(userName);
    }

    public void setPassword(String password){
        passwordBox.sendKeys(password);
    }

    public void submit(){
        login.click();
    }

    //Actions
    public void login(String user, String pass){
        setUserName(user);
        setPassword(pass);
        submit();
    }

    //Constructor
    public LoginPageFactory(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
}
