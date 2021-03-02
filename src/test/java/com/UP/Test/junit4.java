package com.UP.Test;
/*
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
 */
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import org.junit.*;
import org.junit.jupiter.api.DisplayName;

import java.util.Arrays;
import java.util.List;

public class junit4 {

    @Before
    public  void t1(){
        System.out.println(" @Before");
    }

@BeforeClass
    public  static void t2(){
    System.out.println("@BeforeClass");
    }



@DisplayName("support collection")
    @Test
    public  void t4(){
        System.out.println(" @Test1");

        List<Integer> numList= Arrays.asList(2,3,4,5,6,7);
         assertThat(numList,hasSize(6));
         assertThat(numList,contains(2));
         assertThat(numList,hasItem(3));
         assertThat(numList,containsInAnyOrder(2,3,4));

    }


    @Test
    public  void t41(){
        System.out.println(" @Test2");
    }


    @Test
    public  void t412(){
        System.out.println(" @Test3");
    }




    @After
    public  void t5(){
        System.out.println(" @After");
    }

@AfterClass
    public  static void t6(){
    System.out.println(" @AfterClass");
    }

















}
