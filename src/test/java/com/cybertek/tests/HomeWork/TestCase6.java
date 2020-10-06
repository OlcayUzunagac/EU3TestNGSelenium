package com.cybertek.tests.HomeWork;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class TestCase6 {
     /*
    Test case #6
    Step 1. Go to "https://www.tempmailaddress.com/"
    Step 2. Copy and save email as a string.
    Step 3. Then go to “https://practice-cybertekschool.herokuapp.com/”
    Step 4. And click on “Sign Up For Mailing List".
    Step 5. Enter any valid name.
    Step 6. Enter email from the Step 2.
    Step 7. Click Sign Up
    Step 8. Verify that following message is displayed:
    “Thank you for signing up. Click the button below toreturn to the home page.”
    Step 9. Navigate back to the “https://www.tempmailaddress.com/”
    Step 10. Verify that you’ve received an email from“do-not-reply@practice.cybertekschool.com”
    Step 11. Click on that email to open it.
    Step 12. Verify that email is from: “do-notreply@practice.cybertekschool.com”
    Step 13. Verify that subject is: “Thanks for
    subscribing to practice.cybertekschool.com!”
     */
    WebDriver driver;
    @BeforeMethod
    public void setUp(){
        driver = WebDriverFactory.getDriver("Chrome");
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
        driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);

    }
    @AfterMethod
    public void tearDown(){
        driver.quit();
    }
    @Test
    public void Test() throws InterruptedException {
        // Step 1. Go to "https://www.tempmailaddress.com/"
        driver.get("https://www.tempmailaddress.com/");

        //Step 2. Copy and save email as a string.
        String email = driver.findElement(By.id("email")).getText();
        System.out.println(email);

        //Step 3. Then go to “https://practicecybertekschool.herokuapp.com”
        driver.get("https://practice-cybertekschool.herokuapp.com/");

        //Step 4. And click on “Sign Up For Mailing List"
        driver.findElement(By.xpath("//a[.='Sign Up For Mailing List']")).click();

        //Step 5. Enter any valid name.
        driver.findElement(By.name("full_name")).sendKeys("MikeSmith");

        //Step 6. Enter email from the Step 2.
        driver.findElement(By.name("email")).sendKeys(email);

        //Step 7. Click Sign Up
        driver.findElement(By.name("wooden_spoon")).click();

        //Step 8. Verify that following message is displayed:
        //“Thank you for signing up. Click the button below toreturn to the home page.”
        String expected = "Thank you for signing up. Click the button below to return to the home page.";
        String actual = driver.findElement(By.name("signup_message")).getText();
        Assert.assertEquals(actual,expected,"verify that message displaed on the screen");

        //Step 9. Navigate back to the “https://www.tempmailaddress.com/”
        driver.get("https://www.tempmailaddress.com/");

        //Step 10. Verify that you’ve received an email from“do-not-reply@practice.cybertekschool.com”
        WebElement actualEmail = driver.findElement(By.cssSelector("#schranka"));
        String emailsText = actualEmail.getText();
        Assert.assertTrue(emailsText.contains("do-not-reply@practice.cybertekschool.com"));

        //Step 11. Click on that email to open it.
        WebElement email_do_not = driver.findElement(By.xpath("//span[text()='do-not-reply@practice.cybertekschool.com']"));
        JavascriptExecutor executor = (JavascriptExecutor)driver;
        executor.executeScript("arguments[0].click();", email_do_not);

        //Step 12. Verify that email is from: “do-notreply@practice.cybertekschool.com”
        String actualMail = driver.findElement(By.id("odesilatel")).getText();
        String expectedMail = "do-not-reply@practice.cybertekschool.com";
        Assert.assertEquals(actualMail,expectedMail,"verify that mail comes from cybertek");

        //Step 13. Verify that subject is: “Thanks for subscribing to practice.cybertekschool.com!”
        String expectedSubject = "Thanks for subscribing to practice.cybertekschool.com!";
        String actualSubject = driver.findElement(By.id("predmet")).getText();
        Assert.assertEquals(actualSubject,expectedSubject,"verify that Subject is the same");


        Thread.sleep(5000);


    }
}
