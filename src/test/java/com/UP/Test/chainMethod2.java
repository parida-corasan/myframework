package com.UP.Test;

import com.UP.POJO.Spartans;
import com.google.gson.Gson;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import org.junit.Assert;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.hamcrest.Matchers.*;
import static io.restassured.matcher.RestAssuredMatchers.* ;

import java.util.List;
import java.util.Map;
import static io.restassured.module.jsv.JsonSchemaValidator.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static io.restassured.RestAssured.* ;

public class chainMethod2 {

    @BeforeAll
    public static void SpartanBaseSetUp(){
        RestAssured.baseURI="http://3.80.73.88";
        RestAssured.port=8000;
        RestAssured.basePath="/api";
    }



    //http://54.174.216.245:8000/api/spartans/search?gender=male&nameContains=ea
    @Test
    public void spartanChaining3logAll(){

        given()
                .log().all()
                .queryParam("gender","male")
                .queryParam("nameContains","ea")
        .when()
                .get("/spartans/search")
        .then()
                .log().all()
                .statusCode(is(200))
                .body("numberOfElements",is(2));

    }


    @Test
    public void spartanChaining4(){

        given()
                .header("Accept","application/json")
                .log().all()
        .when()
             .get("/spartans")
        .then()
                .statusCode(is(200))
                .header("Content-Type",equalTo("application/json"))
                .log().all();



    }


    @Test
    public void spartanChaining5(){


        given()
                .log().all()
        .when()
           .get("/spartans/{id}",34)
        .then()
            .statusCode(is(200))
            .body("id",is(34))   ;



    }


    @Test
    public void spartanChaining6(){


        given()
                .log().all()
                .pathParam("id",34)
       .when()
                .get("/spartans/{id}")
       .then()
                .statusCode(is(200))
                .body("id",is(34))
                .body("name",is("Tucky"))
                .body("gender",is("Male"))
                .body("phone",is(2935099804l))
                .assertThat().body(matchesJsonSchemaInClasspath("spartanJsonSchema.json"));

    }




    @Test
    public void spartanChaining7spartanPOST(){
        String newBody="{\n" +
                "        \"name\": \"belluci\",\n" +
                "        \"gender\": \"Female\",\n" +
                "        \"phone\": 5712345430\n" +
                "    }";

      given()
                .contentType(ContentType.JSON)
                .body(newBody)
                .log().body()
        .when()
           .post("/spartans")
        .then()
           .statusCode(is(201))      //201 is sucessfully created
           .body("success",equalTo("A Spartan is Born!"))
           .contentType(ContentType.JSON);






    }




    @Test
    public void spartanChaining7spartanPOST2(){
        String newBody1="{\n" +
                "        \"name\": \"Tom\",\n" +
                "        \"gender\": \"male\",\n" +
                "        \"phone\": 571234543\n" +
                "    }";
      Response response=  given()
                .body(newBody1 )
        .when()
            .post("/spartans") ;


       // System.out.println("response.body().prettyPeek() = " + response.body().prettyPeek());
          //return hashxode


        System.out.println("response.body().prettyPrint() = " + response.body().prettyPrint());

        System.out.println("response.statusCode() = " + response.statusCode());



    }




    @Test
    public void spartanChaining7spartanDelete1(){


        given()
                .log().all()
        .when()
                .delete("/spartans/9")
        .then()
           .statusCode(is(204))      ;
     //204 is  success for delete request mean "no content"

    }


    @Test
    public void spartanChaining8spartan(){

   Response response= given()
               .accept(ContentType.JSON)
               .queryParam("gender","Male")
               .log().body()
       .when()
              .get("/spartans");


   //response.prettyPrint();
        String spartan0=response.path("name[0]");
        System.out.println("spartan0 = " + spartan0);
        List<Integer> genderList=response.path("gender");


        System.out.println(genderList);

        Assert.assertTrue(!genderList.contains("Female"));








    }




    @Test
    public void spartanChaining9spartan(){

        Response response=given().queryParam("nameContains","w").and().
                accept(ContentType.JSON).get("/spartans");

        JsonPath jasonData=response.jsonPath();

      List<String> nameList= jasonData.getList("name");

        System.out.println(nameList);
        System.out.println("=========================================================");


        //de-serialization: conver json to java collection
        // for tah t we need Gson dependency
        List<Map<String,Object>>  ListMap1=jasonData.getList("");


        System.out.println("ListMap1 = " + ListMap1);

        System.out.println("===================================================================");
        List<Map<String,Object>> ListMap2=response.body().as(List.class);

        for (Map<String,Object> map: ListMap2){

            System.out.println("map = " + map);
        }




    }


    @Test
    public void spartanChaining10De_serelization(){

        Response response=given().accept(ContentType.JSON)
                        .pathParam("id",8)
                       .and().when().get("spartans/{id}");

          // how we gonna convert
        // Gson work here
    Map<String,Object> spartanMap= response.body().as(Map.class);

        System.out.println("spartanMap.get(\"name\") = " + spartanMap.get("name"));





    }


    @Test
    public void Spartan_Serialization(){

        Response response=given().pathParam("id",6)
                           .when().get("/spartans/{id}");

        // how to convert json to POJO class

        Spartans spartan=response.body().as(Spartans.class);
        System.out.println("================================================================");
        System.out.println(spartan.toString());

        System.out.println("spartan.getName() = " + spartan.getName());
        System.out.println("spartan.getGender() = " + spartan.getGender());
        System.out.println("spartan.getId() = " + spartan.getId());

        System.out.println("===================================================================");
        Gson gson=new Gson();

        String myJsonBody="{\n" +
                "    \"id\": 56,\n" +
                "    \"name\": \"Ewan\",\n" +
                "    \"gender\": \"Male\",\n" +
                "    \"phone\": 5733729948\n" +
                "}";
// using gson method to deserilize gson body
        Spartans spartanMeta=gson.fromJson(myJsonBody,Spartans.class);
        System.out.println("spartanMeta.toString() = " + spartanMeta.toString());


 // serelization  java Object ----> Json

  Spartans spartan_JavaObject=new Spartans(78,"buyut","Male",1234567890l);

  String JsonFromPOJO=gson.toJson(spartan_JavaObject);

        System.out.println("JsonFromPOJO = " + JsonFromPOJO);


    }



























}
