package com.examples;

import com.examples.bind.BaseApiResponse;
import io.restassured.RestAssured;
import io.restassured.response.ValidatableResponse;
import org.testng.annotations.Test;

import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.*;


public class SWApiTestWithRestAssured {
    @Test
    public void requestAresourcesThenLinkToReturn(){
//        ValidatableResponse body = RestAssured
//                .given()
//                .baseUri("https://swapi.dev")
//                .and()
//                .queryParam("format", "json")
//                .when()
//                .get()
//                .then()
//                .log().all()
//                .and().assertThat().statusCode(is(equalTo(200)));
        BaseApiResponse baseApiResponse = RestAssured
       // String body = RestAssured
                .given()
                .baseUri("https://swapi.dev/api" +
                        "" +
                        "" +
                        "" +
                        "" +
                        "" +
                        "" +
                        "" +
                        "" +
                        "" +
                        "" +
                        "" +
                        "")
                .and()
                .queryParam("format", "json")
                .when()
                .get("/")
                .then()
                .log().all()
                .and().assertThat().statusCode(is(equalTo(200)))
                .and()
                .body("films", response -> notNullValue())
                .body("vehicles", response -> notNullValue())
                .body("people", response -> notNullValue())
                .body("starships", response -> notNullValue())
                .body("species", response -> notNullValue())
                //.and().extract().body().asString();
                .and().extract().body().as(BaseApiResponse.class);

        RestAssured
                .given()
                .queryParam("format", "json")
                .log().all()
                .when()
                .post(baseApiResponse.getFilms())
                .then()
                .log().all()
                .and()
                .assertThat()
                .statusCode(is(equalTo(405)));


    }



}
