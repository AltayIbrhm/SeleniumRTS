package com.Selenium.tests;
import com.Selenium.utilities.Driver;
import com.Selenium.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;


import java.util.concurrent.TimeUnit;

public class RTS_Labs  {
        WebDriver driver;
    @BeforeMethod
    public void setUpMethod(){
        driver = WebDriverFactory.getDriver("chrome");
        driver.get("https://www.google.com/");
        driver.manage().window();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

    }



    @Test
    public void RTSLab(){

        WebElement searchbutton = driver.findElement(By.xpath("//input[@name='q']"));
        searchbutton.sendKeys("rtslabs"+ Keys.ENTER);
        WebElement rtslink = driver.findElement(By.xpath("//a[@href='https://rtslabs.com/']"));
        rtslink.click();

       String actual=driver.getCurrentUrl();
       String expected = "https://rtslabs.com/";
//
       Assert.assertEquals(actual,expected);

    }


    @AfterMethod
    public void teardownMethod() throws InterruptedException {
        Thread.sleep(5000);
        driver.close();
    }


}
