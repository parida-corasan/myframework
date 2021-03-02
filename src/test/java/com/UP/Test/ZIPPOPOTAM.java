package com.UP.Test;

import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.apache.commons.lang3.builder.ToStringExclude;
import org.junit.jupiter.api.BeforeAll;
import io.restassured.RestAssured;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import static io.restassured.RestAssured.* ;
import static java.util.Arrays.*;
import static org.hamcrest.Matchers.*;
public class ZIPPOPOTAM {



    @Test
    public void getAndorra(){

        given()
             .baseUri("http://api.zippopotam.us")
        .when()
                .get("/AD/AD100")
        .then()
              .statusCode(is(200))
                .log().body()
                .body("'post code'",equalTo("AD100"))
                .body("places[0].longitude",is("1.6667"))
                .body("places[0].'place name'",equalTo("Canillo"));



    }




    @Test
    public void getMovie(){
        Response response=  given()
                               //.log().all()
                               .baseUri("http://www.omdbapi.com")
                               .queryParam("apiKey","2b8ca714")
                               .queryParam("t","Boss Baby")
                           .when()
                                 .get();


        System.out.println(response.statusCode());

        String title=response.path("Title");
        System.out.println("title = " + title);


        ArrayList<String> ratingList=new ArrayList<>();
        ratingList=response.path("Ratings");
        System.out.println("ratingList = " + ratingList);

        // we cant do this step
       // System.out.println("ratingList.get(0) = " + ratingList.get(0));

        String firstRatingSrc = response.path("Ratings[0].Source");
        System.out.println("firstRatingSrc = " + firstRatingSrc);

        JsonPath jp=response.jsonPath();
      //  System.out.println("jp = " + jp);//jp = io.restassured.path.json.JsonPath@3e3315d9



        // store the entire response as Map<String , Object>
        // Since our result is a Json Object with key value pair
        // we can directly call getMap method and provide the path
        // store the whole thing into a Map object
        // "" as jsonpath means the root path
        // we can also use dollar sign "$" to specify rootpath
        Map<Object,String>   responseMap=jp.getMap("$");

        System.out.println("responseMap = " + responseMap);


        List<String> sourceList=jp.getList("Ratings.Source");
        System.out.println("sourceList = " + sourceList);

    }


















}
