package com.webdriver.newPractice.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.*;

/**
 * Created by Pravin on 9/19/2015.
 */
public class CheckBoxPage {
    private final WebDriver driver;

    public CheckBoxPage(WebDriver driver) {
        this.driver = driver;
    }


    public void clickBox() {
        WebElement checkbox1 = driver.findElement(By.xpath(".//*[@id='checkboxes']/input[1]"));
        if (checkbox1.isSelected() == false) {
            checkbox1.click();
        }
        WebElement checkbox2 = driver.findElement(By.xpath(".//*[@id='checkboxes']/input[2]"));
        if (checkbox2.isSelected() == false) {
            checkbox2.click();
        }


    }


}


