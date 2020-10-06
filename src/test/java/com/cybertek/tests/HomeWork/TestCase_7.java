package com.cybertek.tests.HomeWork;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class TestCase_7 {
    /*
    Test case #7
    Step 1. Go to “https://practicecybertekschool.herokuapp.com”
    Step 2. And click on “File Upload".
    Step 3. Upload any file with .txt extension from your computer.
    Step 4. Click “Upload” button.
    Step 5. Verify that subject is: “File Uploaded!”
    Step 6. Verify that uploaded file name is displayed.
    Note: use element.sendKeys(“/file/path”) with
    specifying path to the file for uploading. Run this
    method against “Choose File” button.
     */

    WebDriver driver;
    @BeforeMethod
    public void setUp() {
        driver = WebDriverFactory.getDriver("Chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
    }
    @AfterMethod
    public void tearDown(){
        //driver.quit();
    }
    @Test
    public void test(){
        //Step 1. Go to “https://practice-cybertekschool.herokuapp.com”
        driver.get("https://practice-cybertekschool.herokuapp.com");

        //Step 2. And click on “File Upload".
        driver.findElement(By.linkText("File Upload")).click();

        //Step 3. Upload any file with .txt extension from your computer.
        WebElement chooseFile = driver.findElement(By.id("file-upload"));

        String projectPath = System.getProperty("user.dir");
        String filePath = "src/test/resources/ödev";
        String fullPath = projectPath + "/" + filePath;
        chooseFile.sendKeys(fullPath);

        //Step 4. Click “Upload” button.
        driver.findElement(By.id("file-submit")).click();

        //Step 5. Verify that subject is: “File Uploaded!”
        String actualMessage = driver.findElement(By.xpath("//*[.='File Uploaded!']")).getText();
        String expectedMeassage = "File Uploaded!";
        Assert.assertEquals(actualMessage,expectedMeassage,"verify that File Uploaded! is displayed");

        //Step 6. Verify that uploaded file name is displayed.
        WebElement ödev = driver.findElement(By.id("uploaded-files"));
        Assert.assertTrue(ödev.isDisplayed());









    }












}
