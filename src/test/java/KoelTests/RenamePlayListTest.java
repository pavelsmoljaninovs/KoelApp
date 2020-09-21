package koelTests;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pageObjects.LoginPage;

public class RenamePlaylistTest extends BaseTest{

    @Parameters({"email","password"})
    @Test
    public void renamePlaylist(String username, String pwd){
        var loginPage = new LoginPage(driver);
        loginPage.openPage();
        var mainPage = loginPage.loginToKoel(username,pwd);
        String playlistId = mainPage.createNewPlaylist("xxxTestPLAYllllliiist");

        mainPage.renamePlaylist(playlistId, "NewPlaylistNameXX");

    }
}
