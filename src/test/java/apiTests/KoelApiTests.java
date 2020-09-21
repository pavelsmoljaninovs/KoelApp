package apiTests;

import helpers.Token;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class KoelApiTests {

    private String token;
    @BeforeClass
    public void starOneTime(){
        token = Token.get();
    }

    @Test
    public void getDataCall(){
        var response =
                given()
                        .baseUri("https://koelapp.testpro.io/")
                        .basePath("api/data")
                        .header("Authorization","Bearer "+token)
                        .when()
                        .get()
                        .then()
                        .statusCode(200)
                        .extract()
                        .response();
        var jsonPath = response.jsonPath();
        var data = jsonPath.getObject("$", DataResponse.class);
        System.out.println(data.artists.length);

        var playlists = jsonPath.getObject("playlists", Playlist[].class);
        System.out.println(playlists.length);
    }






}
