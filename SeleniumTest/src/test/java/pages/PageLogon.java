/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

/**
 *
 * @author SQA
 */
public class PageLogon {
    private WebDriver driver;
    private By titleText;
    public PageLogon(WebDriver driver){
        this.driver = driver;
        titleText = By.xpath("/html/body/div/table/tbody/tr/td[2]/table/tbody/tr[4]/td/table/tbody/tr/td[2]/table/tbody/tr[3]/td/p/font/b");
    }
    
    public void assertLogonPage(){
        Assert.assertTrue(driver.findElement(titleText).getText().contains("Welcome back to"));
    }
}
