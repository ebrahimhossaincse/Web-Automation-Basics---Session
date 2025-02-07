package me.hossain.ebrahim;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class MouseHover {
    WebDriver driver;

    @BeforeClass
    public void setup(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    //@Test
    public void mouseHover() throws InterruptedException {
        driver.get("http://www.automationpractice.pl/index.php");
        WebElement women = driver.findElement(By.xpath("//a[@title='Women']"));

        Actions action = new Actions(driver);
        action.moveToElement(women).perform();
        Thread.sleep(2000);

        WebElement summer_dress = driver.findElement(By.xpath("//a[@title='Summer Dresses']"));
        summer_dress.click();
        Thread.sleep(2000);
    }

    @Test
    public void mouseHover2() throws InterruptedException {
        driver.get("http://www.automationpractice.pl/index.php");
        WebElement women = driver.findElement(By.xpath("//a[@title='Women']"));
        hover(women);
        Thread.sleep(2000);

        WebElement summer_dress = driver.findElement(By.xpath("//a[@title='Summer Dresses']"));
        summer_dress.click();
        Thread.sleep(2000);
    }

    @AfterClass
    public void quit(){
        driver.quit();
    }

    public void hover(WebElement element){
        Actions action = new Actions(driver);
        action.moveToElement(element).perform();
    }

}
