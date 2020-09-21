package KoelTests;

public class BaseTest {

    protected WebDriver driver;

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
}
