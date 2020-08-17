package sampleTests;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class KoelLogin {
    private WebDriver driver;
    private WebDriverWait webDriverWait;
    private FluentWait<WebDriver> fluentWait;

    @BeforeMethod
    public void startUp(){
        System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
        driver = new ChromeDriver();
//        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        webDriverWait = new WebDriverWait(driver,20);
        fluentWait = new FluentWait<WebDriver>(driver)
                .pollingEvery(Duration.ofMillis(50))
                .withTimeout(Duration.ofSeconds(20))
                .ignoring(ElementClickInterceptedException.class)
                .ignoring(StaleElementReferenceException.class)
                .ignoring(NoSuchElementException.class);

        driver.get("https://koelapp.testpro.io");
    }
    @AfterMethod
    public void tearDown() throws InterruptedException {
        Thread.sleep(5000);
        driver.quit();
    }
    @Test
    public void findSeleniumInGoogle_AssertResult() throws InterruptedException {
//        Thread.sleep(2000);
//        webDriverWait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("[type='email']")));
//        fluentWait.until(x->x.findElement(By.cssSelector("[type='email']")).isDisplayed());

        WebElement emailField = null;
        boolean xx = true;
        double maxTime = 0;

        while(xx) {
            try {
                emailField = driver.findElement(By.cssSelector("[type='email']"));
                xx=false;
            } catch (NoSuchElementException ex) {
                try {
                    Thread.sleep(200);
                    maxTime +=0.2;
                    if(maxTime >= 20.0){
                        throw new NoSuchElementException("Element not found blah-blah");
                    }
                } catch (InterruptedException ee){

                }
            }
        }

        WebElement passwordField = driver.findElement(By.xpath("//*[@type='password']"));
        WebElement loginButton = driver.findElement(By.cssSelector("[type='submit']"));

        emailField.sendKeys("testpro.user04@testpro.io");
        passwordField.sendKeys("te$t$tudent");
        loginButton.click();

        webDriverWait.until(ExpectedConditions.elementToBeClickable(By.id("playerControls")));
        WebElement playerControl = driver.findElement(By.id("playerControls"));
        Assert.assertTrue(playerControl.isDisplayed());

    }
}
