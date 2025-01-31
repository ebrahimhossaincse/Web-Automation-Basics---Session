package me.hossain.ebrahim;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class ChromeBrowser {

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
    @Test
    public void openURL(){
        driver.get("https://www.daraz.com.bd");
    }

//    public static void main(String[] args){
//        ChromeBrowser browser = new ChromeBrowser();
//        browser.startBrowser();
//        browser.openURL();
//        browser.stopBrowser();
//    }

}
