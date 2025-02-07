package me.hossain.ebrahim;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class AssertionExamples {
    WebDriver driver;

    @BeforeClass
    public void setup(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    //@Test
    public void hardAssertion() throws InterruptedException {
        driver.get("https://www.tutorialspoint.com/selenium/practice/selenium_automation_practice.php");
        Thread.sleep(2000);
        String expected_Title = "Selenium Practice - Student Registration For";
        String actual_title = driver.getTitle();
        Assert.assertEquals(actual_title, expected_Title);
        System.out.println("Current URL: " + driver.getCurrentUrl());
    }

    @Test
    public void softAssertion() throws InterruptedException {
        driver.get("https://www.tutorialspoint.com/selenium/practice/selenium_automation_practice.php");
        Thread.sleep(2000);
        String expected_Title = "Selenium Practice - Student Registration For";
        String actual_title = driver.getTitle();
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(actual_title, expected_Title);
        System.out.println("Current URL: " + driver.getCurrentUrl());
        softAssert.assertAll();
    }

    @AfterClass
    public void close(){
        driver.close();
    }
}
