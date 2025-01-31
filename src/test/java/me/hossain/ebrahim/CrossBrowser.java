package me.hossain.ebrahim;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class CrossBrowser {

    WebDriver driver;

    @BeforeSuite
    public void startBrowser() {
        String browserName = "chrome";  //Config data read
        if(browserName.equalsIgnoreCase("chrome")) {
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
            driver.manage().window().maximize();
        }else if(browserName.equalsIgnoreCase("firefox")) {
            WebDriverManager.firefoxdriver().setup();
            driver = new FirefoxDriver();
            driver.manage().window().maximize();
        }else if(browserName.equalsIgnoreCase("ie")) {
            WebDriverManager.iedriver().setup();
            driver = new InternetExplorerDriver();
            driver.manage().window().maximize();
        }else if(browserName.equalsIgnoreCase("safari")) {
            WebDriverManager.safaridriver().setup();
            driver = new SafariDriver();
            driver.manage().window().maximize();
        }else{
            System.out.println("Browser not supported");
        }
    }

    // Driver Close
    @AfterSuite
    public void stopBrowser(){
        driver.close();
    }

    //Test
    @Test
    public void openURL(){
        startBrowser();
        driver.get("https://www.daraz.com.bd");
    }

//    public static void main(String[] args){
//        ChromeBrowser browser = new ChromeBrowser();
//        browser.startBrowser();
//        browser.openURL();
//        browser.stopBrowser();
//    }

}
