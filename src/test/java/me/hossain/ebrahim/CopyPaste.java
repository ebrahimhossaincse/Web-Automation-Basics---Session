package me.hossain.ebrahim;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class CopyPaste {
    WebDriver driver;

    @BeforeClass
    public void setup(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @Test
    public void copyAndPaste() throws InterruptedException {
        driver.get("https://www.tutorialspoint.com/selenium/practice/register.php");
        Thread.sleep(2000);
        Actions action = new Actions(driver);

        WebElement lastName = driver.findElement(By.id("lastname"));
        lastName.sendKeys("Tutorial");
        Thread.sleep(2000);

        //Select
        action.keyDown(Keys.CONTROL);
        action.sendKeys("a");
        action.keyUp(Keys.CONTROL);
        action.build().perform();
        Thread.sleep(2000);

        //Copy
        action.keyDown(Keys.CONTROL);
        action.sendKeys("c");
        action.keyUp(Keys.CONTROL);
        action.build().perform();

        //Tab
        action.sendKeys(Keys.TAB);
        action.build().perform();
        Thread.sleep(2000);

        //Paste
        action.keyDown(Keys.CONTROL);
        action.sendKeys("v");
        action.keyUp(Keys.CONTROL);
        action.build().perform();

        Thread.sleep(4000);


    }

    @AfterClass
    public void quit(){
        driver.quit();
    }
}
