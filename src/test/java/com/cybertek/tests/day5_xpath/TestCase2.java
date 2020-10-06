package com.cybertek.tests.day5_xpath;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class TestCase2 {
    public static void main(String[] args) throws InterruptedException {

        /*Go to Ebay
        search Selenium
        click on search button
        verify title contains Selenium

         */
        //Go to Ebay
        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.get("http://www.ebay.com");
        driver.manage().window().maximize();

        //search Selenium
        driver.findElement(By.xpath("//input[@class='gh-tb ui-autocomplete-input']")).sendKeys("selenium");

        //click on search button
        driver.findElement(By.xpath("//input[@class='btn btn-prim gh-spr']")).click();
        //driver.findElement(By.xpath("//td[@class='gh-td gh-sch-btn']/input")).click();-->parent tan asagiya inme

        //verify title contains Selenium
        String title = driver.getTitle();

        if(title.contains("selenium")){
            System.out.println("PASS");
        }else{
            System.out.println("FAIL");
        }

        driver.quit();


    }
}
