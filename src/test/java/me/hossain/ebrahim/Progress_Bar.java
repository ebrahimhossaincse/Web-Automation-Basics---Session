package me.hossain.ebrahim;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class Progress_Bar {
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


    @Test(priority = 0)
    public void openURL() throws InterruptedException {
        driver.get("http://uitestingplayground.com/progressbar");
    }

    @Test(priority = 1)
    public void progressbar() throws InterruptedException {
        WebElement startButton = driver.findElement(By.id("startButton"));
        WebElement stopButton = driver.findElement(By.id("stopButton"));
        WebElement progressBar = driver.findElement(By.id("progressBar"));

        startButton.click();

        while(true){
            int percentage = Integer.parseInt(progressBar.getText().replace("%", ""));
            if(percentage >= 80){
                stopButton.click();
//                ((JavascriptExecutor)driver).executeScript("arguments[0].click()", stopButton);
                break;
            }
        }

        Thread.sleep(5000);

    }
}
