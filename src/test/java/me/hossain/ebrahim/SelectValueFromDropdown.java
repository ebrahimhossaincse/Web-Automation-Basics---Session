package me.hossain.ebrahim;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class SelectValueFromDropdown {

    WebDriver driver;

    @BeforeClass
    public void setup(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @Test
    public void dropdown() throws InterruptedException {
        driver.get("https://www.tutorialspoint.com/selenium/practice/selenium_automation_practice.php");
        Thread.sleep(2000);

        WebElement state = driver.findElement(By.xpath("//select[@id='state']"));
        Select select = new Select(state);
        //Select By Index
        select.selectByIndex(2);
        Thread.sleep(3000);

        //Select By Value
        select.selectByValue("Rajasthan");
        Thread.sleep(3000);

        //Select By Visible Text
        select.selectByVisibleText("NCR");
        Thread.sleep(3000);
    }

    @AfterClass
    public void quit(){
        driver.quit();
    }
}
