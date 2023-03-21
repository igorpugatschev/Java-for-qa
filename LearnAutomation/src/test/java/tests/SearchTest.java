package tests;

import org.testng.annotations.Test;

public class SearchTest extends BaseTest {
    @Test(dataProvider = "dataProvider")
    public void openGoogleComInBrowserTest(String text) throws InterruptedException {

        steps.executeSearchByKeyword(text)
                .verifyThatTopResultContainsCorrectText("Selenium Webdriver")
                .verifyThatTopResultContainsProperAttributeText("LC20lb");
        }
    @Test
    public void verifySearchByVoiceTooltipOnGoogle(){
        steps.openTooltip()
                .verifyThatTooltipContainsPropperText("Голосовой поиск");
    }
}
