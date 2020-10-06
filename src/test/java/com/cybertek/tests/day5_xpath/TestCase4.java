package com.cybertek.tests.day5_xpath;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class TestCase4 {

    public static void main(String[] args) throws InterruptedException {

       /* 1. Open Chrome browser
        2. Go to http://practice.cybertekschool.com/forgot_password Links to an external site.
        3. Locate all the WebElements on the page using XPATH locator only (total of 6)
        a. “Home” link
        b. “Forgot password” header
        c. “E-mail” text
        d. E-mail input box
        e. “Retrieve password” button

        4.Print text of a,b,c,e and put some email to d

        */

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        driver.get("http://practice.cybertekschool.com/forgot_password");
        driver.manage().window().maximize();

        //a. “Home” link
        driver.findElement(By.xpath("//nav[contains(@class,'navbar navbar-expand-sm bg-light')]/ul")).click();
        Thread.sleep(2000);
        driver.navigate().back();
        //b. “Forgot password” header
        driver.findElement(By.xpath("//div[@class='example']/h2")).click();
        //c. “E-mail” text
        driver.findElement(By.xpath("//div[@class='large-6 small-12 columns']/label"));
        //d. E-mail input box
        driver.findElement(By.xpath("//input[@type='text'][@name='email']")).sendKeys("mike@gmail.com");




    }
}
