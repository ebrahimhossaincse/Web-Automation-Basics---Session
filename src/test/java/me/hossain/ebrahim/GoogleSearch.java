package me.hossain.ebrahim;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;

public class GoogleSearch {
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
        driver.get("https://www.google.com");
    }

    @Test(priority = 1)
    public void fetchLongestResult() throws InterruptedException {
        WebElement searchbox = driver.findElement(By.name("q"));
        searchbox.clear();
        searchbox.sendKeys("SQA");
        Thread.sleep(5000);

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        wait.until(ExpectedConditions.presenceOfElementLocated(By.className("wM6W7d")));

        try{
            List<WebElement> suggestions = driver.findElements(By.className("wM6W7d"));

            if(suggestions.isEmpty()){
                System.out.println("No suggestions found");
            }else{
                for(WebElement suggestion : suggestions){
                    System.out.println(suggestion.getText());
                }
            }

            String longestSuggestion= "";
            for(WebElement suggestion : suggestions){
                String text = suggestion.getText();
                if(text != null && !text.isEmpty()){
                    if(text.length() > longestSuggestion.length()){
                        longestSuggestion = text;
                    }
                }
            }
            System.out.println("Longest Suggestion: " + longestSuggestion);

        } catch (Exception e) {
            System.out.println("Error occured while fetching longest result");
        }



    }
}
