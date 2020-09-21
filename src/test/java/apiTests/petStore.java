package apiTests;


import helpers.RandomGenerator;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import models.*;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class petStore {
    private Pet pet;
    public long petId;

    @BeforeMethod
    public void startUp(){
        PostPetRequest petRequest = (PostPetRequest) RandomGenerator.petRequestGenerator();
        pet = petRequest;
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
    }
    @AfterMethod
    public void tearDown(){
                given()
                        .baseUri("https://petstore.swagger.io/v2/")
                        .basePath("pet/"+petId)
                        .when()
                        .delete()
                        .then()
                        .statusCode(200)
                        .extract()
                        .response();
    }
    @Test
    public void getPetById(){
        Response response =
                given()
                    .baseUri("https://petstore.swagger.io/v2/")
                    .basePath("pet/"+petId)
                .when()
                    .get()
                .then()
                    .statusCode(200)
                    .extract()
                    .response();

        JsonPath jsonResponse = response.jsonPath();
        PetResponse petResponse = jsonResponse.getObject("$", PetResponse.class);

        Assert.assertEquals(petResponse.getName(),pet.getName());
        Assert.assertEquals(petResponse.getCategory().getName(),pet.getCategory().getName());
    }

    @Test
    public void updatePet(){
        PutPetRequest petRequest = RandomGenerator.petUpdateRequestGenerator();
        petRequest.setId(petId);

        Response response =
                given()
                        .baseUri("https://petstore.swagger.io/v2/")
                        .basePath("pet")
                        .header("Content-Type","application/json")
                        .body(petRequest)
                        .when()
                        .put()
                        .then()
                        .statusCode(200)
                        .extract()
                        .response();
        JsonPath jsonPath = response.jsonPath();
        PetResponse petResponse = jsonPath.getObject("$",PetResponse.class);
        Assert.assertEquals(petResponse.getName(),petRequest.getName());
    }
}
