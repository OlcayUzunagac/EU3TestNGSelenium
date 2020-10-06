package com.cybertek.tests.day5_xpath;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.Arrays;

public class TestCase3 {
    public static void main(String[] args) {

        /*Go to wikipedia.org (Links to an external site.)
        enter search term `selenium webdriver`
        click on search button
        click on search result `Selenium (software)`
        verify url ends with `Selenium_(software)'
        */

        //Go to wikipedia.org (Links to an external site.)

        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.get("http://www.wikipedia.com");
        driver.manage().window().maximize();

        //enter search term `selenium webdriver`
        //driver.findElement(By.xpath("//input[@id='searchInput'][@name='search']")).sendKeys("selenium webdriver");
        driver.findElement(By.xpath("//input[@style='padding-right: 64px;']")).sendKeys("selenium webdriver");

        //click on search button
        //driver.findElement(By.xpath("(//input[@type='hidden'])[3]/../button/i")).click();
        driver.findElement(By.xpath("//i[@class='sprite svg-search-icon']")).click();

        //click on search result `Selenium (software)`
        //driver.findElement(By.xpath("(//span[.='Selenium'])[1]")).click();
        driver.findElement(By.xpath("//a[@href='/wiki/Selenium_(software)']")).click();

        //verify url ends with `Selenium_(software)'
        String expected = "Selenium_(software)";
        String currentUrl = driver.getCurrentUrl();
        System.out.println(currentUrl);



        if(currentUrl.endsWith(expected)){
            System.out.println("PASS");
        }else{
            System.out.println("FAIL");
            System.out.println("expectedResult = " + expected);
            System.out.println("currentUrl = " + currentUrl);
        }

        driver.quit();
    }
}
