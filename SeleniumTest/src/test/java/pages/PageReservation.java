/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

/**
 *
 * @author SQA
 */
public class PageReservation {
    private WebDriver driver;
    private By titleText;
    private By passengerDrop;
    private By fromDrop;
    private By toDrop;
    
    public PageReservation(WebDriver driver){
        this.driver = driver;
        titleText = By.xpath("/html/body/div/table/tbody/tr/td[2]/table/tbody/tr[4]/td/table/tbody/tr/td[2]/table/tbody/tr[3]/td/font");
        passengerDrop = By.name("passCount");
        fromDrop = By.name("fromPort");
        toDrop = By.name("toPort");
        
    }
    public void assertPage(){
        Assert.assertTrue(driver.findElement(titleText).getText().contains("Flight Finder to search"));
    }
    
    public void selectPassengers(int cant){
        WebDriverWait wait = new WebDriverWait(driver, 10);
        WebElement passengersCount = wait.until(ExpectedConditions.presenceOfElementLocated(passengerDrop));
        Select selectPassengers = new Select(passengersCount);
        selectPassengers.selectByVisibleText(Integer.toString(cant));
    }
    
    public void selectFromPort(int index){
        Select selectFromPort = new Select(driver.findElement(fromDrop));
        selectFromPort.selectByIndex(index);
    }
    public void selectToPort(String city){
        Select selectToPort = new Select(driver.findElement(toDrop));
        selectToPort.selectByValue(city);
    }
}
