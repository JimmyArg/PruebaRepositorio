/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pages;


import java.util.List;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

/**
 *
 * @author SQA
 */
public class PageLogin {
    private WebDriver driver;
    private By userField;
    private By passwordField;
    private By loginButton;
    private By fields;
    
    
    public PageLogin(WebDriver driver){
        this.driver = driver;
        userField = By.name("userName");
        passwordField = By.name("password");
        loginButton = By.name("login");
        fields = By.tagName("input");
        
    }
    public void login(String user, String pass){
        driver.findElement(userField).sendKeys(user);
        driver.findElement(passwordField).sendKeys(pass);
        driver.findElement(loginButton).click();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        /*Helpers helper = new Helpers();
        helper.sleepSeconds(4);*/
    }
    
    public void verifyFields(){
        List<WebElement> loginFields = driver.findElements(fields);
        System.out.println(loginFields.size());
        Assert.assertTrue(loginFields.size()==5);
    }
}