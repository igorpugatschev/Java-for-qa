import config.TestConfig;
import org.testng.annotations.Test;

import static constants.Constants.Actions.*;
import static constants.Constants.Servers.REQUESTBIN_URL;
import static io.restassured.RestAssured.given;

public class JsonPlaceHolderTest extends TestConfig {
    @Test
    public void GET(){
        given()
                .queryParam("postId", 1).log().uri()
                .when().get(JSON_PLACEHOLDER_GET)
                .then().spec(responseSpecificationForGet)
                .log().body();
    }
    @Test
    public void PUT(){
        String putBodyJson = "{\n" +
                "\"id\":1,\n" +
                "\"title\":\"foo\",\n" +
                "\"body\":\"bar\",\n" +
                "\"userId\":1\n" +
                "}";

        given()
                .body(putBodyJson)
                .log().uri()
                .when().put(JSON_PLACEHOLDER_PUT)
                .then().spec(responseSpecificationForGet)
                .log().body().statusCode(200);
    }

    @Test
    public void DELETE(){
        given()
                .log().uri()
                .when().delete(JSON_PLACEHOLDER_DELETE)
                .then().spec(responseSpecificationForGet)
                .log().body();
    }

    @Test
    public void PostWithJson(){
        String postBodyJson = "{\n" +
                "    \"title\": \"foo\",\n" +
                "    \"body\": \"bar\",\n" +
                "    \"userId\": 1\n" +
                "  }";

        given()
                .body(postBodyJson)
                .log().all()
                .when().post(JSON_PLACEHOLDER_POST)
                .then().spec(responseSpecificationForPost)
                .log().body();
    }

    @Test
    public void PostWithXml(){
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
                .then().spec(responseSpecificationForGet)
                .log().body();
    }

}
