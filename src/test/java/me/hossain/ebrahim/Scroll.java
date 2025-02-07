package me.hossain.ebrahim;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Scroll {
    WebDriver driver;

    @BeforeClass
    public void setup(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @Test
    public void scroll() throws InterruptedException {
        driver.get("http://www.automationpractice.pl/index.php");
        Thread.sleep(2000);

        String script_for_scrolldown = "window.scrollTo(0, document.body.scrollHeight);";
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript(script_for_scrolldown);
        Thread.sleep(2000);

        String script_for_scrollup = "window.scrollTo(0, 0);";
        js.executeScript(script_for_scrollup);
        Thread.sleep(2000);


    }

    @AfterClass
    public void quit(){
        driver.quit();
    }
}
