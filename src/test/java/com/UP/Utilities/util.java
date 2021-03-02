package com.UP.Utilities;

public class util {

public static void wait(int second){
    try {
        Thread.sleep(second);
    } catch (InterruptedException e) {
        e.printStackTrace();
    }
}


}
