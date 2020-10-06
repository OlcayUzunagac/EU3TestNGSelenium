package com.cybertek.tests.day2_webdriver_basics;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class GetTitleAndUrl {

    public static void main(String[] args) {

        //task: open chrome and navigate http://practice.cybertekschool.com

        WebDriverManager.chromedriver().setup();

        WebDriver driver = new ChromeDriver();

    //    driver.get("http://practice.cybertekschool.com");

        driver.navigate().to("http://practice.cybertekschool.com");

        //getting title with selenium

        //System.out.println(driver.getTitle());

        //shortcut for creating variable
        //ALT + enter enter
        //getTitle()-->get you the title of the page
        String title = driver.getTitle();


        System.out.println("title" + title);

        //soutv +enter to print variable name and value
        System.out.println("title = " + title);

        String currentUrl = driver.getCurrentUrl();
        System.out.println("currentUrl = " + currentUrl);

        String pageSource = driver.getPageSource();
        System.out.println("pageSource = " + pageSource);




    }
}
