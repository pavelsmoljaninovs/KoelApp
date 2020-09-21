package apiTests;

public class petStorePost {

    private long petId;
    @AfterMethod
    public void tearDown(){
        given()
                .baseUri("https://petstore.swagger.io/v2/")
                .basePath("pet/"+petId)
                .when()
                .delete()
                .then()
                .extract()
                .response();
    }
    @Test
    public void postPet(){
        PostPetRequest petRequest = RandomGenerator.petRequestGenerator();
        Response response =
                given()
                        .baseUri("https://petstore.swagger.io/v2/")
                        .basePath("pet")
                        .header("Content-Type","application/json")
                        .body(petRequest)
                        .when()
                        .post()
                        .then()
                        .statusCode(200)
                        .extract()
                        .response();

        JsonPath jsonPath = response.jsonPath();
        PetResponse petResponse = jsonPath.getObject("$",PetResponse.class);
        petId = petResponse.getId();
        Assert.assertEquals(petRequest.getName(),petResponse.getName());
    }

    @Test
    public void getPetByStatus(){
        Response response =
                given()
                        .baseUri("https://petstore.swagger.io/v2/")
                        .basePath("pet/findByStatus")
                        .header("Content-Type","application/json")
                        .queryParam("status","pending")
                        .when()
                        .get()
                        .then()
                        .statusCode(200)
                        .extract()
                        .response();
        JsonPath path = response.jsonPath();
        PetResponse[] pets = path.getObject("$",PetResponse[].class);
        System.out.println(pets.length);
    }




}
