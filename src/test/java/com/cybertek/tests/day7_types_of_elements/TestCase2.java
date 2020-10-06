package com.cybertek.tests.day7_types_of_elements;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TestCase2 {

    /*1.Open chrome browser
    2.Goto http://www.seleniumeasy.com/test/basic-checkbox-demo.html
    3.Verif "Success-check box is checked" message is NOT displayed
    4.Click to check box under "Single ChockBox Demo" section
    5.Verify "Success-Check box is checked" message IS displayed
     */

    @Test
    public void test1() throws InterruptedException {
        //Open chrome browser,Goto http://www.seleniumeasy.com/test/basic-checkbox-demo.html
        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.get("http://www.seleniumeasy.com/test/basic-checkbox-demo.html");
        driver.manage().window().maximize();

        //Verif "Success-check box is checked" message is NOT displayed

        WebElement successCheckBox = driver.findElement(By.id("txtAge"));
        System.out.println("successCheckBox.isDisplayed() = " + successCheckBox.isDisplayed());
        Assert.assertFalse(successCheckBox.isDisplayed(),"'verify that Success-check box is checked' message in not displayed");

        //Click to check box under "Single ChockBox Demo" section
        driver.findElement(By.id("isAgeSelected")).click();
        Thread.sleep(6000);

        //Verify "Success-Check box is checked" message IS displayed
        Assert.assertTrue(successCheckBox.isDisplayed(),"Verify \"Success-Check box is checked\" message IS displayed");

        driver.quit();
    }



}
