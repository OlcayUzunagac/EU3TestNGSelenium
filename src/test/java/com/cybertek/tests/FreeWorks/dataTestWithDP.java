package com.cybertek.tests.FreeWorks;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class dataTestWithDP {


    WebDriver driver;

    @Test(dataProvider = "wordPressData")
    public void Test(String username, String password) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

        driver.get("http://demosite.center/wordpress/wp-login.php");
        driver.findElement(By.id("user_login")).sendKeys(username);
        driver.findElement(By.id("user_pass")).sendKeys(password);
        driver.findElement(By.id("wp-submit")).click();

        Thread.sleep(3000);

        Assert.assertTrue(driver.getTitle().contains("Dashboard"));
        System.out.println("You are successfully loged in");

    }

    @DataProvider(name= "wordPressData")
    public Object[][] data(){

        return new Object[][]{
                {"admin1","demo1"},
                {"admin","demo123"},
                {"admin2","demo1234"}};
    }
    @AfterMethod
    public void tearDown(){
        driver.quit();
    }

}
