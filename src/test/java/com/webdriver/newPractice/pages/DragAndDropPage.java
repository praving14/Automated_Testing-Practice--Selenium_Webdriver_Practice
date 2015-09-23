package com.webdriver.newPractice.pages;

import com.sun.scenario.effect.Effect;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;

/**
 * Created by Pravin on 9/16/2015.
 */
public class DragAndDropPage {

    private final WebDriver driver;

    public DragAndDropPage(WebDriver driver){
        this.driver = driver;
    }


    By headerLocator = By.xpath("/html/body/div[2]/div/div/h3");
    By sourceLocator = By.id("column-a");
    By destinationLocator = By.id("column-b");


    public String getHeader() {
       String Header =  driver.findElement(headerLocator).getText();
        return Header;
    }


    public void dragIt(){
        Actions builder = new Actions(driver);
        String pre_src = driver.findElement(sourceLocator).getText();
        String pre_dest = driver.findElement(destinationLocator).getText();
        System.out.println(pre_src + " to " + pre_dest);
        builder.moveToElement(driver.findElement(sourceLocator)).clickAndHold().moveToElement(driver.findElement(destinationLocator)).perform();
    }
}
