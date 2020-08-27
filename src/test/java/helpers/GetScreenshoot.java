package helpers;

public class GetScreenshoot {


    public static void capture(WebDriver driver, String filename){
        try {
            TakesScreenshot takesScreenshot = (TakesScreenshot) driver;
            File file = takesScreenshot.getScreenshotAs(OutputType.FILE);
            FileUtils.copyFile(file, new File("./screenshots/" + filename + ".png"));
        } catch (IOException error) {
            System.out.println("i/o problem");
        }
    }




}
