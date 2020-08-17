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
        System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
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

        searchField.sendKeys("Selenium");
        searchButton.click();

        Assert.assertEquals(driver.getTitle(), "Selenium - Google Search");
    }

    @Test
    public void findJavaInGoogle_AssertResult() throws InterruptedException {
        WebElement searchField = driver.findElement(By.cssSelector("[name='q']"));
        WebElement searchButton = driver.findElement(By.cssSelector("[name='btnK']"));

        searchField.sendKeys("Java");
        searchButton.click();

        Assert.assertEquals(driver.getTitle(), "Java - Google Search");
    }

    @Test
    public void findMavenInGoogle_AssertResult() throws InterruptedException {
        WebElement searchField = driver.findElement(By.cssSelector("[name='q']"));
        WebElement searchButton = driver.findElement(By.cssSelector("[name='btnK']"));

        searchField.sendKeys("Maven");
        searchButton.click();

        Assert.assertEquals(driver.getTitle(), "Maven - Google Search");
    }
}
