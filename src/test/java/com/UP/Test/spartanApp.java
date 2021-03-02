package com.UP.Test;

import io.restassured.response.Response;
import org.apache.http.conn.util.PublicSuffixList;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.DisplayName;
import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

public class spartanApp {
    Response response;

 @Before
    public void setUPSpartan(){
        response=get("http://18.207.93.96:8000/api/hello");
    }



@DisplayName("first attemp")
    @Test
public  void practice1(){

    // MAKE SURE YOUR REQUEST WORKS IN POSTMAN
    // IF ANYTHING DOES NOT WORK MANNUALY IT WILL NOT WORK IN HERE EITHER

    //RestAssured.get("URL HERE")
    // SINCE WE DID THE STATIC IMPORT
        /*
        import static io.restassured.RestAssured.*;
        import static io.restassured.matcher.RestAssuredMatchers.*;
         import static org.hamcrest.Matchers.*;
         */

    // we can directly call the get method
    // after we send the request
    // we can save the result in to a type called Response
    // need this  import io.restassured.response.Response;


  //  response.statusCode() and response.getStatusCode() return same thing
    System.out.println("response.statusCode() = " + response.statusCode());
    System.out.println("response.getStatusCode() = " + response.getStatusCode());

    // return same
    System.out.println("response.statusLine() = " + response.statusLine());
    System.out.println("response.getStatusLine() = " + response.getStatusLine());


    //return same
    System.out.println("response.contentType() = " + response.contentType());
    System.out.println("response.getContentType() = " + response.getContentType());

    System.out.println("response.header(\"Data\") = " + response.header("Data"));
    System.out.println("response.getHeader(\"Data\") = " + response.getHeader("Data"));

    System.out.println("response.header(\"Content-Type\") = " + response.header("Content-Type"));
    System.out.println("response.header(\"Content-Length\") = " + response.header("Content-Length"));


    System.out.println("response.getContentType() = " + response.getContentType());
    System.out.println("response.contentType() = " + response.contentType());


}



@Test
public void testHelloSpartan(){
    System.out.println(response.asString());

    System.out.println(response.body().asString());

    String hellobody=response.body().asString();


    Assert.assertEquals(response.body().asString(),hellobody);
    Assert.assertEquals(response.header("Content-length"),"17");






}



@Test
    public void helloApartanPrint(){
    System.out.println("response.peek()");
    System.out.println(response.peek());
    System.out.println("response.peek().getCookies() = " + response.peek().getCookies());
    System.out.println("===================================================================");
    System.out.println("response.prettyPrint()");
    System.out.println(response.prettyPrint());
    System.out.println("=====================================================================");
    System.out.println("response.print()");
    System.out.println(response.print());

}
























}
