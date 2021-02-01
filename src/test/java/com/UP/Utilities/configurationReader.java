package com.UP.Utilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class configurationReader {

    private static Properties properties=new Properties();

    static{
        String path="Configuration.properties";

        try {
            FileInputStream file=new FileInputStream(path);
            properties.load(file);
            file.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static String getProperty(String keyWord){
        return properties.getProperty(keyWord);
    }




}
