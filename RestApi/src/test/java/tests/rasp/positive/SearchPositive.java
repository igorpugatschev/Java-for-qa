package tests.rasp.positive;

import api.models.reqres.RaspYandexModel;
import base.BaseTest;
import io.restassured.http.Method;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static constants.Constants.APIKEY;

public class SearchPositive extends BaseTest {

    @Test(description = "search some object", dataProvider = "searchText")
    public void searchPlaceWithText(String apikey, String format, String from, String to) {
        RaspYandexModel.RequestModel requestModel = RaspYandexModel.RequestModel.builder()
                .apikey(apikey)
                .format(format)
                .from(from)
                .to(to)
                .build();
        apiManager.getRaspYandexModel().search(requestModel, Method.GET, 200);
    }

    @DataProvider
    public Object[][] searchText() {
        return new Object[][]{
                {APIKEY, "JSON", "c146", "c213"}
        };
    }
}
