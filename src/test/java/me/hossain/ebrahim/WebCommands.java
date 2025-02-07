package me.hossain.ebrahim;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class WebCommands {

    WebDriver driver;

    @BeforeClass
    public void setup(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    //@Test
    public void fetchCurrentURL() throws InterruptedException {
        driver.get("https://www.tutorialspoint.com/selenium/practice/selenium_automation_practice.php");
        Thread.sleep(2000);
        WebElement home = driver.findElement(By.xpath("//a[@href='https://www.tutorialspoint.com']"));
        home.click();
        Thread.sleep(2000);
        String currentUrl = driver.getCurrentUrl();
        System.out.println("Current URL: " + currentUrl);
    }

    //@Test
    public void fetchTitle() throws InterruptedException {
        driver.get("https://www.tutorialspoint.com/selenium/practice/selenium_automation_practice.php");
        Thread.sleep(2000);
        WebElement home = driver.findElement(By.xpath("//a[@href='https://www.tutorialspoint.com']"));
        home.click();
        Thread.sleep(2000);
        String title = driver.getTitle();
        System.out.println("Title: " + title);
    }

    @Test
    public void sendValues() throws InterruptedException {
        driver.get("https://www.tutorialspoint.com/selenium/practice/selenium_automation_practice.php");
        Thread.sleep(2000);
        WebElement firstName = driver.findElement(By.id("name"));
        firstName.sendKeys("Ebrahim Hossain");
        Thread.sleep(2000);
        firstName.clear();
        firstName.sendKeys("Jishan");
        Thread.sleep(2000);

        String attributeValue = firstName.getAttribute("placeholder");
        System.out.println("Attribute Value: " + attributeValue);

        String cssValues = firstName.getCssValue("color");
        System.out.println("CSS Value: " + cssValues);

        WebElement text = driver.findElement(By.xpath("//h1[contains(text(),'Selenium - Automation Practice Form')]"));
        System.out.println("Text Value: " + text.getText());
    }

    @AfterClass
    public void quit(){
        driver.quit();
    }
}
