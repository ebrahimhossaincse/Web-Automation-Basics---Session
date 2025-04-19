package me.hossain.ebrahim;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class ManageSSLIssue {
    WebDriver driver;

    // Driver Setup & Browser Configuration
    @BeforeSuite
    public void startBrowser(){
        ChromeOptions options = new ChromeOptions();
        options.setAcceptInsecureCerts(true);

        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver(options);
        driver.manage().window().maximize();
    }

    // Driver Close
    @AfterSuite
    public void stopBrowser(){
        driver.close();
    }


    @Test(priority = 0)
    public void openURL() throws InterruptedException {
        driver.get("https://expired.badssl.com/");

    }

    @Test(priority = 1)
    public void sslHandling() throws InterruptedException {
        Thread.sleep(5000);

    }
}
