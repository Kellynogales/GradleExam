package com.examples;

import com.examples.bind.BaseApiResponse;
import io.restassured.RestAssured;
import io.restassured.response.ValidatableResponse;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.config;
import static io.restassured.config.LogConfig.logConfig;
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


        RestAssured
                .given()
                .queryParam("format", "json")
                .config(config().logConfig(logConfig().enableLoggingOfRequestAndResponseIfValidationFails()))
                .when()
                .get("https://swapi.dev/api")
                .then()
                .assertThat()
                .statusCode(is(equalTo(200)));


    }

}
