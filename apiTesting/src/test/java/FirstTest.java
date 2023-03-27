import config.TestConfig;
import io.restassured.http.Headers;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import java.util.List;
import java.util.Map;

import static constants.Constants.Actions.SWAPI_GET_PEOPLE;
import static constants.Constants.Path.SWAPI_PATH;
import static constants.Constants.Servers.REQUESTBIN_URL;
import static io.restassured.RestAssured.*;
//import static io.restassured.matcher.RestAssuredMatchers.matchesXsdInClasspath;
import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;
import static org.hamcrest.Matchers.equalTo;

public class FirstTest extends TestConfig {
    @Test
    public void myFirstTest(){
        given().log().uri()
                .when().get(SWAPI_GET_PEOPLE + "1")
                .then().log().body().statusCode(200);
    }

    @Test
    public void getSomeFieldInResponseAssertion(){
        given().spec(requestSpecificationForSwapiTests).log().uri()
                .when().get(SWAPI_PATH)
                .then().body("people",equalTo("https://swapi.dev/api/people/")).log().body();
    }

    @Test
    public void getSomeFieldInResponseWithIndexAssertion(){
        given().spec(requestSpecificationForSwapiTests).log().uri()
                .when().get(SWAPI_PATH+SWAPI_GET_PEOPLE)
                .then()
                .body("count",equalTo(82))
                .body("results.name[0]",equalTo("Luke Skywalker"))
                .log().body();
    }

    @Test
    public void getAllDataFromRequest(){
        Response response =
                given().spec(requestSpecificationForSwapiTests).log().uri()
                        .when().get(SWAPI_PATH)
                        .then().extract().response();
        String jsonResponseAsString = response.asString();;
        System.out.println(jsonResponseAsString);
    }

    @Test
    public void getCookieFromResponse(){
        Response response =
                given().spec(requestSpecificationForSwapiTests).log().uri()
                        .when().get(SWAPI_PATH)
                        .then().extract().response();
        Map<String,String> allCookie = response.getCookies();
        System.out.println("allCookie--> " + allCookie);
    }

    @Test
    public void getHeadersFromResponse() {
        Response response =
                given().spec(requestSpecificationForSwapiTests).log().uri()
                        .when().get(SWAPI_PATH)
                        .then().extract().response();
        Headers headers = response.getHeaders();
        System.out.println("headers--> " + headers);
        String contentType = response.getContentType();
        System.out.println("contenetType--> "+ contentType);
    }

    /**@Test
    public void validateXmlSchema(){
        given().log().uri()
                .when().get("ввести запрос")
                .then().body(matchesXsdInClasspath("xmlSchema.xsd")).log().body();

    }
    */

    @Test
    public void exampleJsonValidate(){
        String postBodyXml = "<employees>\n" +
                "\t<employee>\n" +
                "\t\t<id>1</id>\n" +
                "\t\t<firstName>Leonardo</firstName>\n" +
                "\t\t<lastName>DiCaprio</lastName>\n" +
                "\t\t<photo>http://1.bp.blogspot.com/-zvS_6Q1IzR8/T5l6qvnRmcI/AAAAAAAABcc/HXO7HDEJKo0/s200/Leonardo+Dicaprio7.jpg</photo>\n" +
                "\t</employee>\n" +
                "\t<employee>\n" +
                "\t\t<id>2</id>\n" +
                "\t\t<firstName>Johnny</firstName>\n" +
                "\t\t<lastName>Depp</lastName>\n" +
                "\t\t<photo>http://4.bp.blogspot.com/_xR71w9-qx9E/SrAz--pu0MI/AAAAAAAAC38/2ZP28rVEFKc/s200/johnny-depp-pirates.jpg</photo>\n" +
                "\t</employee>\n" +
                "\t<employee>\n" +
                "\t\t<id>3</id>\n" +
                "\t\t<firstName>Hritik</firstName>\n" +
                "\t\t<lastName>Roshan</lastName>\n" +
                "\t\t<photo>https://upload.wikimedia.org/wikipedia/commons/3/32/Hrithik_Roshan_in_2001.jpg</photo>\n" +
                "\t</employee>\n" +
                "</employees>";

        given().spec(requestSpecificationFXml).body(postBodyXml).log().uri()
                .when().post(REQUESTBIN_URL)
                .then().body(matchesJsonSchemaInClasspath("jsonSchema.json"))
                .log().body();

    }


    //получение параметра по ключу
    @Test
    public void getMapOfElementsWithSomekey(){
        Response response =
                given().spec(requestSpecificationForSwapiTests).log().uri()
                        .when().get(SWAPI_PATH + SWAPI_GET_PEOPLE);
        System.out.println("response --> " + response.asString());
        Map<String, ?> someObject = response
                .path("results.find{it.name = 'Luke Skywalker'}");
        System.out.println("someObject--> " + someObject);
    }

    @Test
    public void getSingleElementWithSomekey(){
        Response response =
                given().spec(requestSpecificationForSwapiTests).log().uri()
                        .when().get(SWAPI_PATH + SWAPI_GET_PEOPLE);
        System.out.println("response --> " + response.asString());
        String url = response
                .path("results.find{it.name = 'Luke Skywalker'}.url");
        System.out.println("url--> " + url);
    }

    @Test
    public void getAllElementWithSomekey() {
        Response response =
                given().spec(requestSpecificationForSwapiTests).log().uri()
                        .when().get(SWAPI_PATH + SWAPI_GET_PEOPLE);
        System.out.println("response --> " + response.asString());
        List films = response
                .path("results.findAll{it.films}.name");
        System.out.println("films--> " + films);
    }
}
