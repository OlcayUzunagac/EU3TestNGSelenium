package com.cybertek.tests.HomeWork;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class TestCases9_12 {
	/*
    Test case #9
Step 1. Go to “https://practicecybertekschool.herokuapp.com”
Step 2. And click on “Status Codes”.
Step 3. Then click on “200”.
Step 4. Verify that following message is displayed:
“This page returned a 200 status code”
*/
    WebDriver driver;
    @BeforeMethod
    public void setUp(){
        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        // Step 1. Go to “https://practicecybertekschool.herokuapp.com”
        driver.get("https://practice-cybertekschool.herokuapp.com");
        //Step 2. And click on “Status Codes”.
        driver.findElement(By.linkText("Status Codes")).click();
    }
    @AfterMethod
    public void tearDown(){
        //driver.quit();
    }
    @Test(dataProvider = "TestCase9_12")
    public void Test(String code){
        //Step 3. Then click on “200”.
        driver.findElement(By.linkText(code)).click();

        //Step 4. Verify that following message is displayed:
        WebElement actual = driver.findElement(By.tagName("p"));
        Assert.assertTrue(actual.isDisplayed());



    }
    @DataProvider(name="TestCase9_12")
    public Object[][] passData() {

        Object[][] obj = new Object[4][1];
        obj[0][0]="200";
        obj[1][0]="301";
        obj[2][0]="404";
        obj[3][0]="500";

        return obj;
        //return new Object[][] {{"200"},{"301"}, {"404"},{"500"}};     //-->easy way

    }
}



