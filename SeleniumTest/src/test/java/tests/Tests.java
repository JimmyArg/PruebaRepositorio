/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package tests;



import helpers.Helpers;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.PageLogin;
import pages.PageLogon;
import pages.PageReservation;




/**
 *
 * @author SQA
 */
public class Tests {
    private WebDriver driver;  
    @BeforeMethod
    
    public void setUp(){
        DesiredCapabilities caps = new DesiredCapabilities();
        System.setProperty("webdriver.chrome.driver", "Drivers/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.navigate().to("http://newtours.demoaut.com/");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);        
        /*Helpers helper = new Helpers();
        helper.sleepSeconds(4);*/
    }
    
    @Test
    public void pruebaUno(){
        PageLogin pageLogin = new PageLogin(driver);
        PageLogon pageLogon = new PageLogon(driver);
        pageLogin.login("user", "user");
        pageLogon.assertLogonPage();
        /*driver.findElement(By.name("userName")).sendKeys("user");
        driver.findElement(By.name("password")).sendKeys("user");
        driver.findElement(By.name("login")).click();
        Helpers helper = new Helpers();
        helper.sleepSeconds(5);
        Assert.assertTrue(driver.findElement(By.xpath("/html/body/div/table/tbody/tr/td[2]/table/tbody/tr[4]/td/table/tbody/tr/td[2]/table/tbody/tr[3]/td/p/font/b")).getText().contains("Welcome back to"));*/
        
    }
    
    @Test
    public void pruebaDos(){
        PageLogin pageLogin = new PageLogin(driver);
        PageReservation pageReservation = new PageReservation(driver);
        pageLogin.login("mercury", "mercury");
        pageReservation.assertPage();
        /*driver.findElement(By.name("userName")).sendKeys("user");
        driver.findElement(By.name("password")).sendKeys("user");
        driver.findElement(By.name("login")).click();
        Helpers helper = new Helpers();
        helper.sleepSeconds(4);
        Assert.assertTrue(driver.findElement(By.xpath("/html/body/div/table/tbody/tr/td[2]/table/tbody/tr[4]/td/table/tbody/tr/td[2]/table/tbody/tr[3]/td/font")).getText().contains("Flight Finder to search"));*/
    }
    
    @Test
    public void pruebaTres(){
        PageLogin pageLogin = new PageLogin(driver);
        PageReservation pageReservation = new PageReservation(driver);
        pageLogin.login("mercury", "mercury");
        pageReservation.assertPage();
        pageReservation.selectPassengers(2);
        pageReservation.selectFromPort(3);
        pageReservation.selectToPort("London");
    }
    
    @Test
    public void pruebaCuatro(){
        PageLogin pageLogin = new PageLogin(driver);
        pageLogin.verifyFields(); 
    }
    
    @AfterMethod
    public void tearDown(){
        driver.close();
    }
    
}