package apiTests;

import org.testng.Assert;

public class KoelPlaylistManagement {

    private String token;
    private int playlistId;
    @BeforeClass
    public void runBeforeClassOnlyOneTime(){
        token = Token.get();
    }
    @AfterMethod
    public void tearDown(){
        given()
                .baseUri("https://koelapp.testpro.io/")
                .basePath("api/playlist/"+playlistId)
                .header("Authorization","Bearer "+token)
                .delete();
    }
    @Test
    public void createPlaylist(){
        String newName = RandomGenerator.randomStringGenerator(8);
        System.out.println(newName);
        Playlist newPlaylist = new Playlist(newName);
        Response response =
                given()
                        .baseUri("https://koelapp.testpro.io/")
                        .basePath("api/playlist")
                        .header("Content-Type","application/json")
                        .header("Authorization","Bearer "+token)
                        .body(newPlaylist)
                        .when()
                        .post()
                        .then()
                        .statusCode(200)
                        .extract()
                        .response();

        JsonPath jsonPath = response.jsonPath();
        Playlist playlistResponse = jsonPath.getObject("$",Playlist.class);
        playlistId = playlistResponse.id;
        Assert.assertEquals(newName,playlistResponse.name);

        Playlist playlistFromDatabase = DbAdapter.getPlaylistById(playlistId);
        Assert.assertEquals(newName,playlistFromDatabase.name);
    }

    @Test
    public void getAllPlaylists(){
        Response response =
                given()
                        .baseUri("https://koelapp.testpro.io/")
                        .basePath("api/playlist")
                        .header("Authorization","Bearer "+token)
                        .when()
                        .get()
                        .then()
                        .statusCode(200)
                        .extract()
                        .response();
        JsonPath jsonPath = response.jsonPath();
        Playlist[] playlistResponse = jsonPath.getObject("$",Playlist[].class);
        List<Playlist> playlistsFromApi= new ArrayList<Playlist>(Arrays.asList(playlistResponse));
        List<Playlist> playlistsFromDb = DbAdapter.getAllPlaylists();

        Assert.assertEquals(playlistsFromApi.size(),playlistsFromDb.size());

//        for(Playlist plApi: playlistsFromApi){
//            Playlist plDb = playlistsFromDb.stream().filter(x->x.id==plApi.id).findAny().orElse(null);
//            Assert.assertNotNull(plDb);
//            Assert.assertEquals(plDb.name,plApi.name);
//        }
        for (Playlist plApi : playlistsFromApi){
            boolean indicator = false;
            for (Playlist plDb: playlistsFromDb){
                if(plApi.id==plDb.id){
                    Assert.assertEquals(plApi.name,plDb.name);
                    indicator=true;
                }
            }
            Assert.assertTrue(indicator);
        }
    }
}
