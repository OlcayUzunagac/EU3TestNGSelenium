package com.cybertek.tests.day4_basic_locators;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class nameLocatorTest {

    public static void main(String[] args) {
        /*//duplicate olabilir.radio buttonlarda cok basimiza gelebilir.arama
        yaparak kac tane olduguna bakmamiz gerekir. ilk bastakini kistas almamiz gerekir.
                */
        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.get("http://practice.cybertekschool.com/sign_up");

        //make browser fullscreen
        driver.manage().window().maximize();

        WebElement putFullName = driver.findElement(By.name("full_name"));
        putFullName.sendKeys("Olcay Uzunagac");

        //put some email and click signUp button

        //proper way
        WebElement putEmail = driver.findElement(By.name("email"));
        putEmail.sendKeys("Mike_Smith@gmail.com");
        //lazy way
        //driver.findElement(By.name("email")).sendKeys("Olcay@gmail.com");


        //proper way
        WebElement clickSignUp = driver.findElement(By.name("wooden_spoon"));
        clickSignUp.click();
        //lazy way
        //driver.findElement(By.name("wooden_spoon")).click();











    }
}
