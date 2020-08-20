package PageObject;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class MainPage extends BasePage{
      try {
        getPlayerControl().isDisplayed();
    } catch (TimeoutException xx) {
        return false;
    }
        return true;
}

    public String createNewPlaylist(String playlistName){
        clickOnPlusButton();
        getNewPlaylistNameField().sendKeys(playlistName);
        getNewPlaylistNameField().sendKeys(Keys.ENTER);
        wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(".success.show")));
        String url = driver.getCurrentUrl();
        String[] parts = url.split("/");
        String playlistId = parts[5];
        WebElement newPlaylist = driver.findElement(By.xpath("//*[@href='#!/playlist/"+playlistId+"']"));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", newPlaylist);
        return playlistId;
    }

    public boolean isPlaylistExist(String playlistId) {
        for (int i = 0; i < 50; i++) {
            try {
                driver.findElement(By.xpath("//*[@href='#!/playlist/"+playlistId+"']"));
                return true;
            } catch (NoSuchElementException ignored){     }
        }
        return false;
    }

    public void renamePlaylist(String playlistId, String newName) {
        var playlist = driver.findElement(By.xpath("//*[@href='#!/playlist/"+playlistId+"']"));
        Actions actions = new Actions(driver);
        actions.doubleClick(playlist).perform();
        var editField = driver.findElement(By.xpath("//*[@class='playlist playlist editing']/input"));
        editField.sendKeys(Keys.CONTROL+"a");
        editField.sendKeys(newName);
        editField.sendKeys(Keys.RETURN);

    }
}
