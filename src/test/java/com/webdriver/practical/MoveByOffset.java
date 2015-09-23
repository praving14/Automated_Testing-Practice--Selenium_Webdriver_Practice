package com.webdriver.practical;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;
import java.util.concurrent.TimeUnit;


/**
 * Created by Pravin on 8/23/2015.
 */

// Mouse and Keyboard based interaction:

public class MoveByOffset {
    // Playing with movebyoffset, actions, build actions,
   @Test
   public void letsTest(){
       WebDriver driver = new InternetExplorerDriver();
       driver.manage().window().maximize();

       driver.get("http://www.usairways.com/default.aspx");
       WebElement vacations = driver.findElement(By.linkText("VACATIONS"));
       WebElement hotels = driver.findElement(By.linkText("HOTELS"));
       WebElement cars = driver.findElement(By.linkText("CARS"));
       WebElement searchby = driver.findElement(By.id("ctl00_phMain_ctlVacationsWidget_ddlVacationsSearchBy"));
       // getting co-ordinates
       // System.out.println("X -coordinate: " + vacations.getLocation().getX() + " Y-coordinate: " + vacations.getLocation().getY());
       // Action is the interface that has only perform() method;

// build the composite action
       Actions builder = new Actions(driver);
       // builder.moveByOffset(vacations.getLocation().getX(), vacations.getLocation().getY()).click();
       builder.click(vacations);
       builder.perform();
       driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

       // Use Select to select from dropdown options;
       Select dropdown = new Select(searchby);
       dropdown.selectByValue("LFF");
       driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

/*
        builder.click(hotels);
        builder.build().perform();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        builder.click(cars);
        builder.build().perform();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        builder.click(vacations).click(hotels).click(cars);
        builder.build().perform(); */


       // We can also use clickAndHold to do drag and drop
       // also use of release() to release the hold
// we also have moveToElement
       driver.close();
   }
}