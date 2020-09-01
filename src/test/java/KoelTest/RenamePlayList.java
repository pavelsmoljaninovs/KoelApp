package KoelTest;

public class RenamePlayList {

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
