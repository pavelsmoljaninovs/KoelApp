package KoelTest;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class JustTest {
    private WebDriver driver;

    private static Logger logger = LogManager.getLogger();
    @BeforeMethod
    public void startUp() throws NoSuchFieldException {
        driver = BrowserFabric.getDriver(BrowserType.CHROME);
    }
    @AfterMethod
    public void tearDown(ITestResult iTestResult) throws InterruptedException {
        if(iTestResult.getStatus()==iTestResult.FAILURE){
            GetScreenshot.capture(driver,iTestResult.getName());
        }
        Thread.sleep(5000);
        driver.quit();
    }
    @Test
    public void playlistTest_loginToKoel() {
        logger.info("Test started");
        LoginPage loginPage = new LoginPage(driver);
        logger.info("Logging page created");
        loginPage.openPage();
        logger.info("Browser opened URL");
        String user = "testpro.user04@testpro.io";
        String password = "te$t$tudent1";
        MainPage mainPage = loginPage.loginToKoel(user,password);
        logger.warn("Logging " + user + " " + password);
        try {
            Assert.assertTrue(mainPage.isMain());
        } catch (AssertionError err) {
            logger.fatal("Test failed "+err.getMessage());
            throw err;
        }

        logger.warn("Assert Made");
    }
}
