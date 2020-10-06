package com.cybertek.tests.day10_actions_js;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class HoverTest {

    WebDriver driver;

    @BeforeMethod
    public void setUp(){
        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

    }

    @AfterMethod
    public void tearDown() throws InterruptedException {
        Thread.sleep(2000);
        driver.quit();
    }

    /**
     * hover over each image in the website
     * verify each name:user text is displayed
     */

    @Test
    public void Test1() {
        driver.get("http://practice.cybertekschool.com/hovers");

        List<WebElement> figures = driver.findElements(By.xpath("//div[@class='figure']"));

        int figureSize= figures.size();
        Actions action = new Actions(driver);

        int count=1;
        for (WebElement element : figures) {
            if(count<= figureSize) {
                    String str = "(//h5)["+count+"]";
                System.out.println(str);
                    action.moveToElement(element).perform();
                    WebElement name = driver.findElement(By.xpath(str));
                System.out.println(name.getText());
                    Assert.assertTrue(name.isDisplayed(), "vrify that name is displayed");
                    count++;
            }else{
                break ;
            }
        }

    }


}