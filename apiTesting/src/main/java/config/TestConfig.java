package config;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.BeforeClass;
import io.restassured.RestAssured;

import static constants.Constants.RunVeriable.server;
import static constants.Constants.RunVeriable.path;
import static constants.Constants.Servers.REQUESTBIN_URL;

public class TestConfig {

    protected RequestSpecification requestSpecificationFXml = new RequestSpecBuilder()
            .addHeader("Content-Type","application/xml")
            .addCookie("testCookieXML")
            .setBaseUri(REQUESTBIN_URL)
            .build();
    @BeforeClass
    public void setUp(){
        RestAssured.baseURI = server;
        RestAssured.basePath = path;
        RequestSpecification requestSpecificationJson = new RequestSpecBuilder()
                .addHeader("Content-Type","application/json")
                .addCookie("testCookieJSON")
                .build();
        RestAssured.requestSpecification = requestSpecificationJson;
    }
}
