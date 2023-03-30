package api.models.reqres;

import api.utils.NetworkCore;
import io.restassured.http.Method;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.HashMap;

import static constants.Constants.Endpoint.YANDEX_RASP_ENDPOINT_SEARCH;
import static constants.Constants.Path.YANDEX_RASP_PATH;
import static constants.Constants.ServerName.YANDEX_RASP_SERVER;

public class RaspYandexModel extends NetworkCore {
    @Setter
    @Getter
    @Builder
    public static class RequestModel{
        private String apikey;
        private String format;
        private String from;
        private String to;
    }
    public RaspYandexModel search(RequestModel model, Method method, int statusCode){
        HashMap requestParams = new HashMap();
        requestParams.put("apikey",model.getApikey());
        requestParams.put("format",model.getFormat());
        requestParams.put("from",model.getFrom());
        requestParams.put("to",model.getTo());
        requestSpecBuilder.setBaseUri(YANDEX_RASP_SERVER + YANDEX_RASP_PATH + YANDEX_RASP_ENDPOINT_SEARCH)
                .addQueryParams(requestParams);
        sendRequestAndGetResponse(method, statusCode);
        return this;

    }

}
