package helpers;

public class Token {

    public static String get(){
        var body = new LoginPostRequest("testpro.user04@testpro.io","te$t$tudent");
        var response =
                given()
                        .baseUri("https://koelapp.testpro.io/")
                        .basePath("api/me")
                        .header("Content-Type","application/json")
                        .body(body)
                        .when()
                        .post()
                        .then()
                        .statusCode(200)
                        .extract()
                        .response();
        var jsonPath = response.jsonPath();
        var token = jsonPath.getObject("$", TokenResponse.class);
        return token.getToken();
    }


}
