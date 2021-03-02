package com.UP.Test;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.matcher.ResponseAwareMatcher;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.* ;
import static io.restassured.matcher.RestAssuredMatchers.* ;
import static org.hamcrest.Matchers.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

public class chaimMethod {

    //http://18.207.93.96:8000/api/hello
   @Test
    public void spartanChaining1(){
//       given().
       // some more information you want to provide other than request url
       // like header , query param , path variable , body
//       when()
       // you send the request GET POST PUT PATCH DELETE
//        then()
       // VALIDATE SOMETHING HERE

       //http://18.207.93.96:8000/api/hello


      when().
           get("http://18.207.93.96:8000/api/hello").
           prettyPeek().
      then().
           statusCode(is(200)).    //Using Hamcrest matcher for assertion
           header("Content-Length",equalTo("17")).////Using Hamcrest matcher for assertion
           body( is("Hello from Sparta"));//using hamrest matcher

   }



    @Test
    public void spartanChaining2get(){

       when()
               .get("http://18.207.93.96:8000/api/spartans/3")
               .prettyPeek()
       .then()
               .statusCode(is(200))
               .header("Content-Type",equalTo("application/json"));





    }





    @Test
    public void spartanChaining3baseURI(){

       given()
               .baseUri("http://18.207.93.96:8000")
               .basePath("/api")
               .log().method()
               .log().params()
               .queryParam("gender","male")
               .accept(ContentType.JSON)
       .when()
            .get("/spartans/search")
       .then()
             .statusCode(is(200))
             .body("numberOfElements",is(51));



    }
























}
