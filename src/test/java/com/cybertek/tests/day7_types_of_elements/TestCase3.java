package com.cybertek.tests.day7_types_of_elements;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TestCase3 {

    /*1.Open chrome browser
    2.Goto http://www.seleniumeasy.com/test/basic-checkbox-demo.html
    3.Verif "Check All" button text is "Check All"
    4.Click to "Check All" button
    5.Verify all check boxes are checked
    6.Verify button text changed to "Uncheck All"
     */

    @Test
    public void test1(){

        //Open chrome browser,        Goto http://www.seleniumeasy.com/test/basic-checkbox-demo.html
        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.get("http://www.seleniumeasy.com/test/basic-checkbox-demo.html");

        //Verif "Check All" button text is "Check All"
        WebElement checkAll = driver.findElement(By.id("check1"));
        System.out.println("checkAll.getAttribute() = " + checkAll.getAttribute("value"));
        Assert.assertEquals(checkAll.getAttribute("value"),"Check All");

        //Click to "Check All" button
        checkAll.click();

        //Verify all check boxes are checked
        WebElement allChecked = driver.findElement(By.xpath("//input[@id='isChkd'][@value='true']"));
        Assert.assertEquals(allChecked.getAttribute("id"), "isChkd");
        Assert.assertEquals(allChecked.getAttribute("value"), "true");

        //Verify button text changed to "Uncheck All"
        System.out.println("checkAll.getAttribute() = " + checkAll.getAttribute("value"));
        Assert.assertEquals(checkAll.getAttribute("value"),"Uncheck All");


        driver.quit();
    }
}
