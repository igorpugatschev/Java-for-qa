package constants;

import static constants.Constants.Path.SWAPI_PATH;
import static constants.Constants.Servers.JSON_PLACEHOLDER_URL;
import static constants.Constants.Servers.SWAPI_URL;

public class Constants {
    public static class RunVeriable {
        public static String server = JSON_PLACEHOLDER_URL;
        public static String path = "";
    }

    public static class Servers {
        public static String SWAPI_URL = "https://swapi.dev/";
        public static String JSON_PLACEHOLDER_URL = "https://jsonplaceholder.typicode.com/";
        public static String QA_MESTO_URL = "https://qa-mesto.praktikum-services.ru/";
        public static String REQUESTBIN_URL = "https://eop64490uintq41.m.pipedream.net";
    }

    public static class Path {
        public static String SWAPI_PATH = "api/";
        public static String QA_MESTO_PATH = "api/";
    }

    public static class Actions {
        //SWAPI
        public static String SWAPI_GET_PEOPLE = "people/";
        //QA_MESTO_PRAKTIKUM_SERVICES
        public static String QA_MESTO_POST_SIGNIN = "signin/";
        public static String QA_MESTO_GET_USERS_ME = "users/";
        //JSON_PLACEHOLDER
        public static String JSON_PLACEHOLDER_GET = "comments/";
        public static String JSON_PLACEHOLDER_PUT = "posts/1/";
        public static String JSON_PLACEHOLDER_DELETE = "posts/1/";
        public static String JSON_PLACEHOLDER_POST = "posts/";
    }
}
