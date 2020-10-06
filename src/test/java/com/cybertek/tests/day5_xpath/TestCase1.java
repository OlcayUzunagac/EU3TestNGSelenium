package com.cybertek.tests.day5_xpath;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class TestCase1 {
    public static void main(String[] args) throws InterruptedException {
      /*  Go to Ebay
        enter search term
        click on search button
        print number of results
        */

        //goto ebay
        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.get("http://www.ebay.com");

        //enter search term
        driver.findElement(By.xpath("//input[@class='gh-tb ui-autocomplete-input']")).sendKeys("selenium");
        Thread.sleep(2000);

        //click on search button
       driver.findElement(By.xpath("//input[@class='btn btn-prim gh-spr']")).click();
        Thread.sleep(2000);

       // print number of results

        System.out.println(driver.findElement(By.xpath("//h1[@class='srp-controls__count-heading']")).getText());









        driver.quit();

    }
}
