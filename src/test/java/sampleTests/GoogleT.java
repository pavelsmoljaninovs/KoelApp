package sampleTests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class GoogleT {

    private WebDriver driver;

    @BeforeMethod
    public void startUp(){
        System.setProperty("webdriver.chrome.driver", "chromedriver");
        driver = new ChromeDriver();
        driver.get("https://google.com");
    }
    @AfterMethod
    public void tearDown() throws InterruptedException {
        Thread.sleep(1000);
        driver.quit();
    }
    @Test
    public void findSeleniumInGoogle_AssertResult() throws InterruptedException {
        WebElement searchField = driver.findElement(By.cssSelector("[name='q']"));
        WebElement searchButton = driver.findElement(By.cssSelector("[name='btnK']"));

        searchField.sendKeys("Search");
        Thread.sleep(1000);
        searchButton.click();

        Assert.assertEquals(driver.getTitle(), "Search - Google Search");
    }

    @Test
    public void findJavaInGoogle_AssertResult() throws InterruptedException {
        WebElement searchField = driver.findElement(By.cssSelector("[name='q']"));
        WebElement searchButton = driver.findElement(By.cssSelector("[name='btnK']"));

        searchField.sendKeys("Test1");
        Thread.sleep(1000);
        searchButton.click();

        Assert.assertEquals(driver.getTitle(), "Test1 - Google Search");
    }

    @Test
    public void findMavenInGoogle_AssertResult() throws InterruptedException {
        WebElement searchField = driver.findElement(By.cssSelector("[name='q']"));
        WebElement searchButton = driver.findElement(By.cssSelector("[name='btnK']"));

        searchField.sendKeys("Test2");
        Thread.sleep(1000);
        searchButton.click();

        Assert.assertEquals(driver.getTitle(), "Test2 - Google Search");
    }
}
