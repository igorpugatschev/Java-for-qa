package config;
import org.testng.annotations.BeforeClass;
import io.restassured.RestAssured;

import static constants.Constants.RunVeriable.server;
import static constants.Constants.RunVeriable.path;

public class TestConfig {
    @BeforeClass
    public void setUp(){
        RestAssured.baseURI = server;
        RestAssured.basePath = path;

    }
}
