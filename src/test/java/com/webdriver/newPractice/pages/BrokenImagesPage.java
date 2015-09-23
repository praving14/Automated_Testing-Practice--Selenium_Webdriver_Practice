package com.webdriver.newPractice.pages;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.tools.ant.taskdefs.condition.Http;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.io.IOException;

/**
 * Created by Pravin on 9/16/2015.
 */
public class BrokenImagesPage {
   private final WebDriver driver;

    public BrokenImagesPage(WebDriver driver){
         this.driver = driver;
     }

   public int verifyImageStatus(WebElement image, int brokenImage) throws IOException {
       HttpClient httpClient = HttpClientBuilder.create().build();
       HttpGet httpRequest = new HttpGet(image.getAttribute("src"));

       HttpResponse response = httpClient.execute(httpRequest);
       int number = response.getStatusLine().getStatusCode();

       if (number != 200){

           brokenImage = brokenImage + 1;
           System.out.print("The image " + brokenImage + " is broken.");
       }

       return brokenImage;
   }





}
