package com.webdriver.newPractice.test;
import com.webdriver.newPractice.pages.BrokenImagesPage;
import com.webdriver.newPractice.pages.CheckBoxPage;
import com.webdriver.newPractice.pages.DragAndDropPage;
import com.webdriver.newPractice.pages.LogInPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;


/**
 * Created by Pravin on 9/16/2015.
 */
public class TestSuite1 {

   // This test was to test log in
    @Test (priority = 2)
    public void loginTest(){
        WebDriver driver = new FirefoxDriver();
        driver.get("https://the-internet.herokuapp.com/login");
        driver.manage().window().maximize();
        LogInPage l = new LogInPage(driver);
       // l.typeUsername("tomsmith");
        l.LogIn("tomsmith", "SuperSecretPassword!");
       String title=  driver.getTitle();
        String URL = driver.getCurrentUrl();
        System.out.println("Tiltle : " + title + "  URL : " + URL );
        driver.close();
    }

    @Test (priority = 3)
    public void dragAndDropTest() {
        WebDriver driver = new FirefoxDriver();
        driver.get("https://the-internet.herokuapp.com/drag_and_drop");
        driver.manage().window().maximize();
        DragAndDropPage dad = new DragAndDropPage(driver);
        String Header2 = dad.getHeader();
        Assert.assertEquals(Header2, "Drag and Drop", "Could not verify the header of the page");
        By sourceLocator = By.xpath(".//*[@id='column-a']");
        By destinationLocator = By.xpath(".//*[@id='column-b']");
        String pre_src = driver.findElement(sourceLocator).getText();
        String pre_dest = driver.findElement(destinationLocator).getText();
        System.out.println(pre_src + " to " + pre_dest);
        // dad.dragIt();
        WebElement src = driver.findElement(sourceLocator);
        WebElement dest = driver.findElement(destinationLocator);
        Actions builder = new Actions(driver);
        Action dragandDrop = builder.clickAndHold(src).moveToElement(dest).release(dest).build();
        dragandDrop.perform();
        // It doesnot drag and drop i donot know why????
    }
/*

    @Test (priority = 4)
    public void brokenImageTest() throws Exception{
    WebDriver driver = new FirefoxDriver();
    driver.get("https://the-internet.herokuapp.com/broken_images");
    driver.manage().window().maximize();
        BrokenImagesPage broken = new BrokenImagesPage(driver);
        int brokenImage = 0;
        List<WebElement> listOfImages = driver.findElements(By.tagName("img"));
        System.out.println("Total number of images : " + listOfImages.size());
        for (WebElement images :listOfImages ){
            if (images != null){
                broken.verifyImageStatus(images, brokenImage);
            }
        }
        // This test is not working!! Fix this as soon as possible

    driver.close();
        }

*/

    @Test (priority = 1)// test to see if we can check both the check box;
    public void checkBoxTest(){
        WebDriver driver = new FirefoxDriver();
        driver.get("http://the-internet.herokuapp.com/checkboxes");
        CheckBoxPage check = new CheckBoxPage(driver);
        check.clickBox();
       if (driver.findElement(By.xpath(".//*[@id='checkboxes']/input[1]")).isSelected() == true && driver.findElement(By.xpath(".//*[@id='checkboxes']/input[2]")).isSelected() ==true){
           System.out.print("The test was succesful!!!");
       }
        driver.close();
    }



// Iterate through the links and get the text fro each Link

    @Test (priority = 0)
    public void checkLinks() throws Exception{
        WebDriver driver = new InternetExplorerDriver();
        driver.manage().window().maximize();
        driver.get("https://the-internet.herokuapp.com/");
        List<WebElement> links = driver.findElements(By.tagName("a"));
        int NumberOfLinks = links.size();
        System.out.println("There are " + NumberOfLinks + " links in ths page");
        for (int i=0 ; i < NumberOfLinks; i++){
            int a =i+1;
            System.out.println("[" + a + "]: " + links.get(i).getText());
        }

    }


// Write test scripts each day as you learn to do each everyday
}
