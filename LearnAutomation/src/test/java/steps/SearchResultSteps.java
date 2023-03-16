package steps;

import pages.SearchResultPage;

public class SearchResultSteps {
    private SearchResultPage searchResultPage = new SearchResultPage();

    public SearchResultSteps verifyThatTopResultContainsCorrectText(String text){
        searchResultPage.assertThatTopResultContainsCorrectText(text);
        return this;
    }
    public SearchResultSteps verifyThatTopResultContainsProperAttributeText(String text) {
        searchResultPage.assertThatTopResultContainsProperAttributeText(text);
        return this;
    }

}
