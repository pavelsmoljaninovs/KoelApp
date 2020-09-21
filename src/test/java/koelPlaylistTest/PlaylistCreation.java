package koelPlaylistTest;

import helpers.DbAdapter;
import helpers.RandomGenerator;
import helpers.Token;
import koelTests.BaseTest;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import pageObjects.LoginPage;

import static io.restassured.RestAssured.given;

public class PlaylistCreation extends BaseTest {
    private int playlistId;
    @AfterMethod
    public void tearDown(){
        String token = Token.get();
        given()
                .baseUri("https://koelapp.testpro.io/")
                .basePath("api/playlist/"+playlistId)
                .header("Authorization","Bearer "+token)
                .delete();
    }
    @Test
    public void createPlaylist_PlaylistCreated(){
        String playlistName = RandomGenerator.randomStringGenerator(8);
        System.out.println(playlistName);
        var loginPage = new LoginPage(driver);
        loginPage.openPage();
        var mainPage = loginPage.loginToKoel("testpro.user04@testpro.io","te$t$tudent");
        playlistId = Integer.parseInt(mainPage.createNewPlaylist(playlistName));
        var playlistFromDb = DbAdapter.getPlaylistById(playlistId);
        Assert.assertEquals(playlistName,playlistFromDb.name);
    }
}
