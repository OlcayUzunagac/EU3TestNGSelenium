package com.cybertek.tests.HomeWork;

import com.cybertek.utilities.WebDriverFactory;
import com.github.javafaker.Faker;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;
import java.util.Locale;
import java.util.Random;
import java.util.concurrent.TimeUnit;

public class TestCase1_5 {

    WebDriver driver;
    @BeforeMethod
    public void setup(){
        driver = WebDriverFactory.getDriver("chrome");
        //driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
       // driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
       // driver.manage().deleteAllCookies();
        driver.get("https://practice-cybertekschool.herokuapp.com/");
        driver.findElement(By.linkText("Registration Form")).click();
        // driver.findElement(By.xpath("//a[.='Registration Form']")).click();


    }
    @AfterMethod
    public void tearDown(){
       driver.quit();
    }

    @Test
    public void test1() throws InterruptedException {


        driver.findElement(By.xpath("//input[@placeholder='MM/DD/YYYY']")).sendKeys("wrong_dob");

        Assert.assertTrue(driver.findElement(By.cssSelector("[name='birthday']")).isDisplayed(),
                "The date of birth is not valid");

        String actual = driver.findElement(By.xpath("//*[.='The date of birth is not valid']")).getText();
        String expected = "The date of birth is not valid";
        Assert.assertEquals(expected,actual,"verify that displayed message ist:The date of birth is not valid");

        Thread.sleep(2000);

    }
      @Test
      public void test2() throws InterruptedException {

        /*
        Step 3. Verify that following options forprogramming languages are displayed: c++, java,JavaScript
         */

          List<WebElement> languages = driver.findElements(By.cssSelector("[class='form-check form-check-inline']"));
          System.out.println("languages.size=" + languages.size());
          String expected = "C++, Java, JavaScript";
          String actual="";
          boolean flag=false;

          for (WebElement language : languages) {
              if(!flag) {
                  actual += language.getText();
                  flag=true;
              }else{
                  actual += ", "+language.getText();

              }
          }

          //Step 3. Verify that following options forprogramming languages are displayed: c++, java,JavaScript
          Assert.assertEquals(actual,expected, "verify that displayed languages are c++," +
                  "java, JavaScript");
          Thread.sleep(2000);

      }

      @Test
    public void test3() throws InterruptedException {
        /*
        Test case #3
        Step 3. Enter only one alphabetic character into first name input box.
        Step 4. Verify that warning message is displayed:
        “first name must be more than 2 and less than 64
         characters long”
         */


          Random rnd = new Random();
          char ch = (char) ('a' + rnd.nextInt(26));

          driver.findElement(By.cssSelector("[name='firstname']")).sendKeys(""+ch);
          String expected = "first name must be more than 2 and less than 64 characters long";
          String actual = driver.findElement(By.xpath("//*[.='first name must be more than 2 and less than 64 characters long']")).getText();

          Assert.assertTrue(driver.findElement(By.xpath("//small[.='first name must be more than 2 and less than 64 characters long']")).isDisplayed());
          Assert.assertEquals(actual,expected,"verify that displayed message is:first name must be more than 2 and less than 64\n" +
                  "         characters long");
          Thread.sleep(2000);

    }

    @Test
    public void test4() throws InterruptedException {
         /*
        Step 3. Enter only one alphabetic character into last name input box.
        Step 4. Verify that warning message is displayed: “The last name must be more than 2 and less than
        64 characters long”
        */
        Random rnd = new Random();
        char ch = (char) ('a' + rnd.nextInt(26));

        driver.findElement(By.cssSelector("[name='lastname']")).sendKeys(""+ch);
        Assert.assertTrue(driver.findElement(By.xpath("//small[.='The last name must be " +
                "more than 2 and less than 64 characters long']")).isDisplayed());
        Thread.sleep(2000);

    }
    @Test
    public void test5() throws InterruptedException {
        /*
        Step 3. Enter any valid first name.
        Step 4. Enter any valid last name.
        Step 5. Enter any valid user name.
        Step 6. Enter any valid email adress.
        Step 7. Enter any valid password.
        Step 8. Enter any valid phone number.
        Step 9. Select gender.
        Step 10. Enter any valid date of birth.
        Step 11. Select any department.
        Step 12. Enter any job title.
        Step 13. Select java as a programming language.
        Step 14. Click Sign up.
        Step 15. Verify that following success message isdisplayed: “You've successfully completed
                   registration!”
         */

        driver.findElement(By.cssSelector("[name='firstname']")).sendKeys("mike");
        driver.findElement(By.cssSelector("[name='lastname']")).sendKeys("smith");
        driver.findElement(By.cssSelector("[name='username']")).sendKeys("mikesmith");
        driver.findElement(By.cssSelector("[name='email']")).sendKeys("mikesmith@gmail.com");
        driver.findElement(By.cssSelector("[name='password']")).sendKeys("123456789");
        driver.findElement(By.cssSelector("[name='phone']")).sendKeys("456-789-1234");
        driver.findElement(By.cssSelector("[name='gender']")).click();
        driver.findElement(By.cssSelector("[name='birthday']")).sendKeys("04/12/2014");
        //Step 11. Select any department.
        WebElement dropdownDepartment = driver.findElement(By.name("department"));
        Select stateDepartment = new Select(dropdownDepartment);
        List<WebElement> options = stateDepartment.getOptions();
        System.out.println("options.size() = " + options.size());
        for (WebElement option : options) {
            System.out.println(option.getText());
        }
        stateDepartment.selectByVisibleText("MPDC");
        String expected = "MPDC";
        String actual = stateDepartment.getFirstSelectedOption().getText();
        Assert.assertEquals(actual,expected,"verify first selection");

        //Step 12. Enter any job title.
        WebElement dropdownJob = driver.findElement(By.name("job_title"));
        Select stateJob = new Select(dropdownJob);
        List<WebElement> optionsJob = stateJob.getOptions();
        for (WebElement option : optionsJob) {
            System.out.println(option.getText());
        }
        stateJob.selectByIndex(4);
        String expectedJob = "QA";
        String actualJob = stateJob.getFirstSelectedOption().getText();
        Assert.assertEquals(actual,expected, "verify first Job");

        //Step 13. Select java as a programming language.
        driver.findElement(By.id("inlineCheckbox2")).click();

        //Step 14. Click Sign up.
        driver.findElement(By.id("wooden_spoon")).click();

        //Step 15. Verify that following success message isdisplayed: “You've successfully completed
        //registration!”

        String expectedMessage = "You've successfully completed registration!";
        String actualMessage = driver.findElement(By.cssSelector(".alert.alert-success>p")).getText();
        Assert.assertEquals(actualMessage,expectedMessage,"verify the last screen Message");


        Thread.sleep(2000);




    }


}
