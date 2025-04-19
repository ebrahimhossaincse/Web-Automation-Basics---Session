package me.hossain.ebrahim;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class Authentication {
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
        driver.get("https://the-internet.herokuapp.com/basic_auth");
        Thread.sleep(3000);

    }

    @Test(priority = 1)
    public void authenticationHandling() throws InterruptedException {

        ((HasAuthentication) driver).register(()-> new UsernameAndPassword("admin", "admin"));
        driver.get("https://the-internet.herokuapp.com/basic_auth");

        WebElement text = driver.findElement(By.xpath("//p[contains(text(),'Congratulations! You must have the proper credenti')]"));
        System.out.println("text: " + text.getText());

    }
}
