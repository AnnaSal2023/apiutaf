package com.trello.steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;

public class TelloSteps {

    private String baseUrl ;
    private String token ;
    private String key ;
    private String name ;
    private String endPoint ;
    private String newBoardName;


    @Given("I have base url {string}")
    public void iHaveBaseUrl(String baseUlt) {
        this.baseUrl = baseUlt;
    }

    @And("token {string}")
    public void token(String token) {
        this.token = token;
    }

    @And("api key {string}")
    public void apiKey(String key) {
        this.key = key;
    }

    @When("I send POST request to endpoint {string}")
    public void iSendPOSTRequestToEndpoint(String endPoint) {
        this.endPoint = endPoint;
    }

    @And("set name for new board as {string}")
    public void setNameForNewBoardAs(String boardName) {
        this.name = boardName;
    }

    @Then("I should get response with status code {int}")
    public void iShouldGetResponseWithStatusCode(int code) {
        RestAssured.baseURI = this.baseUrl;

        RestAssured.given()
                .contentType(ContentType.JSON)
                .queryParam("key", this.key)
                .queryParam("token", this.token)
                .queryParam("name", this.name)
                .when()
                .post(endPoint)
                .then()
                .statusCode(code);

    }

    @And("set new name for new board as {string}")
    public void setNewNameForNewBoardAs(String newBoardName) {
        this.newBoardName = newBoardName;


    }

    @Then("I should get response of updating with status code {int}")
    public void iShouldGetResponseOfUpdatingWithStatusCode(int statusCode) {
        RestAssured.baseURI = this.baseUrl;
        RestAssured.given()
                .contentType(ContentType.JSON)
                .queryParam("key", this.key)
                .queryParam("token", this.token)
                .queryParam("name", this.newBoardName)
                .pathParam("id", "5c4f33509050cd5b4c3d98db")
                .when()
                .put(endPoint)
                .then()
                .statusCode(200);

    }
}
