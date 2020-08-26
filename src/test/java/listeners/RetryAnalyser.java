package listeners;

public class RetryAnalyser implements IRetryAnalyzer {


    private int retryCount = 0;
    private static final int maxRetryCount = 4;
    @Override
    public boolean retry(ITestResult result) {
        if (retryCount < maxRetryCount) {
            retryCount++;
            return true;
        }
        return false;
    }




}
