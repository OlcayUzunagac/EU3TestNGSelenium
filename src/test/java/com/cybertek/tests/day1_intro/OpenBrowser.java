package com.cybertek.tests.day1_intro;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class OpenBrowser {

    public static void main(String[] args) {
       // we have to enter this line every time we want to open chrome
        //hey webdriver, can you make chrome ready for me for automation?
        WebDriverManager.chromedriver().setup();

        //Webdriver represent the browser
        //we are creting driver for chrome browser
        //new ChromeDriver()--> this part will open chrome browser
        WebDriver driver = new ChromeDriver();

        //.get(url) method used for navigation to page
        driver.get("https://cybertekschool.com");

        WebDriverManager.firefoxdriver().setup();
        WebDriver driver1 = new FirefoxDriver();
        driver1.get("https://google.com");







    }
}
