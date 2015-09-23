package com.webdriver.newPractice.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 * Created by Pravin on 9/16/2015.
 */
public class LogInPage  {
   private final WebDriver driver;

    public LogInPage(WebDriver driver){
        this.driver = driver;
    }

    By usernameLocator = By.id("username");
    By passwordLocator = By.id("password");
    By buttonLocator = By.xpath("/html/body/div[2]/div/div/form/button");
    By loginheaderLocator = By.xpath("/html/body/div[2]/div/div/h2");
    String logInHeader;

/*
    public void logInNow(UserEnum enter){
        String usernm = enter.getUsername();
        String passwd = enter.getPassword();
        driver.findElement(usernameLocator).sendKeys(usernm);
        driver.findElement(passwordLocator).sendKeys(passwd);
        driver.findElement(buttonLocator).click();

    }
   */ public void  LogIn(String usernm, String paswd ){
        this.typeUsername(usernm);
        this.typePassword(paswd);
        this.clickLoginButton();
    };

    public void typeUsername(String usernm){
        driver.findElement(usernameLocator).sendKeys(usernm);
    }

    public void typePassword(String paswd){
        driver.findElement(passwordLocator).sendKeys(paswd);
    }

    public void clickLoginButton() {
        driver.findElement(buttonLocator).click();
    }

    public String getHeaderText(){
      logInHeader = driver.findElement(loginheaderLocator).getText();
        return  logInHeader;
    }

}
