package constants;

import api.utils.UtilsMethods;

public class Constants {
    //https://api.rasp.yandex.net/v3.0/search/?
    //domain name
    public static class ServerName{
        public static String YANDEX_RASP_SERVER = "https://api.rasp.yandex.net/";
    }

    //path
    public static class Path{
        public static String YANDEX_RASP_PATH = "v3.0/";
    }
    //endpoint
    public static class Endpoint{
        public static String YANDEX_RASP_ENDPOINT_SEARCH = "search/";
    }

    public  static final String APIKEY = UtilsMethods.getValue("TOKEN");
}
