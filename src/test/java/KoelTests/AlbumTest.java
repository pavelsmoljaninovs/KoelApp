package koelTests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.LoginPage;
import pageObjects.MainPage;

public class AlbumTest extends BaseTest{

    @Test
    public void album_playlistTest_loginToKoel() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.openPage();
        MainPage mainPage = loginPage.loginToKoel("testpro.user04@testpro.io","te$t$tudent");
        Assert.assertTrue(mainPage.isMain());
    }
    @Test
    public void album_playlistTest_createPlaylist() {
        var loginPage = new LoginPage(driver);
        loginPage.openPage();
        var mainPage = loginPage.loginToKoel("testpro.user04@testpro.io","te$t$tudent");
        String playlistId = mainPage.createNewPlaylist("xxxTestPLAYllllliiist");
        Assert.assertTrue(mainPage.isPlaylistExist(playlistId));
    }
    @Test
    public void album_playlistTest_playlist7003exist(){
        var loginPage = new LoginPage(driver);
        loginPage.openPage();
        var mainPage = loginPage.loginToKoel("testpro.user04@testpro.io","te$t$tudent");
        mainPage.isMain();
        Assert.assertTrue(mainPage.isPlaylistExist("7003"));
    }
    @Test
    public void album_playlistTest_wrongLogin(){
        var loginPage = new LoginPage(driver);
        loginPage.openPage();
        loginPage.loginToKoel("testpro.user04@testpro.io","wrongPassword");
        Assert.assertTrue(loginPage.isWrongLogin());
    }
    @Test
    public void album_playlistTest_loginToKoel1() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.openPage();
        MainPage mainPage = loginPage.loginToKoel("testpro.user04@testpro.io","te$t$tudent");
        Assert.assertTrue(mainPage.isMain());
    }
    @Test
    public void album_playlistTest_createPlaylist1() {
        var loginPage = new LoginPage(driver);
        loginPage.openPage();
        var mainPage = loginPage.loginToKoel("testpro.user04@testpro.io","te$t$tudent");
        String playlistId = mainPage.createNewPlaylist("xxxTestPLAYllllliiist");
        Assert.assertTrue(mainPage.isPlaylistExist(playlistId));
    }
    @Test
    public void album_playlistTest_playlist7003exist1(){
        var loginPage = new LoginPage(driver);
        loginPage.openPage();
        var mainPage = loginPage.loginToKoel("testpro.user04@testpro.io","te$t$tudent");
        mainPage.isMain();
        Assert.assertTrue(mainPage.isPlaylistExist("7003"));
    }
    @Test
    public void album_playlistTest_wrongLogin1(){
        var loginPage = new LoginPage(driver);
        loginPage.openPage();
        loginPage.loginToKoel("testpro.user04@testpro.io","wrongPassword");
        Assert.assertTrue(loginPage.isWrongLogin());
    }
    @Test
    public void album_playlistTest_loginToKoel2() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.openPage();
        MainPage mainPage = loginPage.loginToKoel("testpro.user04@testpro.io","te$t$tudent");
        Assert.assertTrue(mainPage.isMain());
    }
    @Test
    public void album_playlistTest_createPlaylist2() {
        var loginPage = new LoginPage(driver);
        loginPage.openPage();
        var mainPage = loginPage.loginToKoel("testpro.user04@testpro.io","te$t$tudent");
        String playlistId = mainPage.createNewPlaylist("xxxTestPLAYllllliiist");
        Assert.assertTrue(mainPage.isPlaylistExist(playlistId));
    }
    @Test
    public void album_playlistTest_wrongLogin2(){
        var loginPage = new LoginPage(driver);
        loginPage.openPage();
        loginPage.loginToKoel("testpro.user04@testpro.io","wrongPassword");
        Assert.assertTrue(loginPage.isWrongLogin());
    }
}
