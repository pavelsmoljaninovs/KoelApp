package KoelTests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTest {
    public class dLoginTest extends BaseTest{

        @Test
        public void loginToKoel() {
            LoginPage loginPage = new LoginPage(driver);
            loginPage.openPage();
            MainPage mainPage = loginPage.loginToKoel("testpro.user04@testpro.io","te$t$tudent");
            Assert.assertTrue(mainPage.isMain());
        }
        @Test
        public void createPlaylist() {
            var loginPage = new LoginPage(driver);
            loginPage.openPage();
            var mainPage = loginPage.loginToKoel("testpro.user04@testpro.io","te$t$tudent");
            String playlistId = mainPage.createNewPlaylist("xxxTestPLAYllllliiist");
            Assert.assertTrue(mainPage.isPlaylistExist(playlistId));
        }
        @Test(enabled=true, retryAnalyzer = RetryAnalyzer.class)
        public void playlist7003exist(){
            var loginPage = new LoginPage(driver);
            loginPage.openPage();
            var mainPage = loginPage.loginToKoel("testpro.user04@testpro.io","te$t$tudent");
            mainPage.isMain();
            Assert.assertTrue(mainPage.isPlaylistExist("70003"));
        }
        @Test
        public void wrongLogin(){
            var loginPage = new LoginPage(driver);
            loginPage.openPage();
            loginPage.loginToKoel("testpro.user04@testpro.io","wrongPassword");
            Assert.assertTrue(loginPage.isWrongLogin());
        }
        @Test
        public void loginToKoel1() {
            LoginPage loginPage = new LoginPage(driver);
            loginPage.openPage();
            MainPage mainPage = loginPage.loginToKoel("testpro.user04@testpro.io","te$t$tudent");
            Assert.assertTrue(mainPage.isMain());
        }
        @Test
        public void createPlaylist1() {
            var loginPage = new LoginPage(driver);
            loginPage.openPage();
            var mainPage = loginPage.loginToKoel("testpro.user04@testpro.io","te$t$tudent");
            String playlistId = mainPage.createNewPlaylist("xxxTestPLAYllllliiist");
            Assert.assertTrue(mainPage.isPlaylistExist(playlistId));
        }
        @Test(enabled=false)
        public void playlist7003exist1(){
            var loginPage = new LoginPage(driver);
            loginPage.openPage();
            var mainPage = loginPage.loginToKoel("testpro.user04@testpro.io","te$t$tudent");
            mainPage.isMain();
            Assert.assertTrue(mainPage.isPlaylistExist("7003"));
        }
        @Test
        public void wrongLogin1(){
            var loginPage = new LoginPage(driver);
            loginPage.openPage();
            loginPage.loginToKoel("testpro.user04@testpro.io","wrongPassword");
            Assert.assertTrue(loginPage.isWrongLogin());
        }
        @Test
        public void loginToKoel2() {
            LoginPage loginPage = new LoginPage(driver);
            loginPage.openPage();
            MainPage mainPage = loginPage.loginToKoel("testpro.user04@testpro.io","te$t$tudent");
            Assert.assertTrue(mainPage.isMain());
        }
        @Test
        public void createPlaylist2() {
            var loginPage = new LoginPage(driver);
            loginPage.openPage();
            var mainPage = loginPage.loginToKoel("testpro.user04@testpro.io","te$t$tudent");
            String playlistId = mainPage.createNewPlaylist("xxxTestPLAYllllliiist");
            Assert.assertTrue(mainPage.isPlaylistExist(playlistId));
        }
        @Test
        public void wrongLogin2(){
            var loginPage = new LoginPage(driver);
            loginPage.openPage();
            loginPage.loginToKoel("testpro.user04@testpro.io","wrongPassword");
            Assert.assertTrue(loginPage.isWrongLogin());
        }

}
