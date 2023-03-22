package constants;

import static constants.Constants.Path.SWAPI_PATH;
import static constants.Constants.Servers.SWAPI_URL;

public class Constants {
    public static class RunVeriable {
        public static String server = SWAPI_URL;
        public static String path = SWAPI_PATH;
    }

    public static class Servers {
        public static String SWAPI_URL = "https://swapi.dev/";
        public static String QA_MESTO_URL = "https://qa-mesto.praktikum-services.ru/";
    }

    public static class Path {
        public static String SWAPI_PATH = "api/";
        public static String QA_MESTO_PATH;
    }

    public static class Actions {
        //SWAPI
        public static String SWAPI_GET_PEOPLE = "people/";
        //QA_MESTO_PRAKTIKUM_SERVICES
        public static String QA_MESTO_POST_SIGNIN;
        public static String QA_MESTO_GET_USERS_ME;
    }
}
