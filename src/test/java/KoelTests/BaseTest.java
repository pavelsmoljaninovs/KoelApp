package koelTests;

import enums.BrowserType;
import helpers.BrowserFabric;
import helpers.GetScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

public class BaseTest {
    protected WebDriver driver;

    @Parameters({"browser"})
    @BeforeMethod
    public void startUp(String browserName) throws NoSuchFieldException {
        BrowserType browserType;
        switch (browserName) {
            case "CHROME": browserType = BrowserType.CHROME;
            break;
            case "FIREFOX": browserType = BrowserType.FIREFOX;
            break;
            default: browserType = BrowserType.EDGE;
        }
        driver = BrowserFabric.getDriver(browserType);
    }
    @AfterMethod
    public void tearDown(ITestResult iTestResult) throws InterruptedException {
        if(iTestResult.getStatus()==iTestResult.FAILURE){
            GetScreenshot.capture(driver,iTestResult.getName());
        }
        Thread.sleep(5000);
        driver.quit();
    }
}
