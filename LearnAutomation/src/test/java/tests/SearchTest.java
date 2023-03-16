package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import pages.SearchPage;
import pages.SearchResultPage;

import static org.assertj.core.api.Assertions.assertThat;


public class SearchTest extends BaseTest {



    @Test(dataProvider = "dataProvider")
    public void openGoogleComInFireFoxTest1(String text) throws InterruptedException {

        SearchPage searchPage = new SearchPage();
        searchPage.fillSearchField(text);
        searchPage.pressEnter();

        Thread.sleep(3000);

        SearchResultPage searchResultPage = new SearchResultPage();
        searchResultPage.assertThatTopResultContainsCorrectText("Пишем автотест с использованием Selenium Webdriver ...");
        searchResultPage.assertThatTopResultContainsProperAttributeText("LC20lb MBeuO DKV0Md");



    }


}
