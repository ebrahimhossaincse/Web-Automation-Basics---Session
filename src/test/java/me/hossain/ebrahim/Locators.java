package me.hossain.ebrahim;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import java.util.List;

public class Locators {
    WebDriver driver;

    // Driver Setup & Browser Configuration
    @BeforeSuite
    public void startBrowser(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    // Driver Close
    @AfterSuite
    public void stopBrowser(){
        driver.close();
    }

    //Test
    @Test(priority = 0)
    public void openURL() throws InterruptedException {
        driver.get("https://www.tutorialspoint.com/selenium/practice/selenium_automation_practice.php");
    }

   // @Test(priority = 1)
    public void locateById() throws InterruptedException {
        WebElement firstName = driver.findElement(By.id("name"));
        firstName.sendKeys("Tutorial");
        Thread.sleep(5000);
    }

    //@Test(priority = 2)
    public void locateByName() throws InterruptedException {
        WebElement email = driver.findElement(By.name("email"));
        email.sendKeys("test@gmail.com");
        Thread.sleep(5000);
    }

   // @Test(priority = 3)
    public void locateByLinkText() throws InterruptedException {
        driver.navigate().to("https://www.facebook.com/");
        WebElement forgot_pass = driver.findElement(By.linkText("Forgotten password?"));
        forgot_pass.click();
        Thread.sleep(5000);
    }

    //@Test(priority = 4)
    public void locateByPartialLinkText() throws InterruptedException {
        driver.navigate().to("https://www.facebook.com/");
        WebElement forgot_pass = driver.findElement(By.partialLinkText("Forgotten"));
        forgot_pass.click();
        Thread.sleep(5000);
    }

    // @Test(priority = 5)
    public void locateByTagName() throws InterruptedException {
        driver.navigate().to("https://www.facebook.com/");
        List<WebElement> links = driver.findElements(By.tagName("a"));
        System.out.println(links.size());
        for (WebElement link : links) {
            System.out.println(link.getText());
        }
    }

    public void locateByXPath() throws InterruptedException {
        driver.navigate().to("https://www.facebook.com/");
    }
}
