package api.utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class UtilsMethods {
    public static String getValue(String value){
        Properties properties = new Properties();
        try{
            FileInputStream fileInputStream = new FileInputStream("src\\test\\resources\\userData.properties");
            properties.load(fileInputStream);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        String data = properties.getProperty(value);
        try{
            data = new String();
        }catch (Exception e) {
            e.printStackTrace();
        }
        return data;
    }
}
