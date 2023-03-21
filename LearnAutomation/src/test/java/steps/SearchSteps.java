package steps;

import pages.SearchPage;

public class SearchSteps {

    private SearchPage searchPage = new SearchPage();

    public SearchResultSteps executeSearchByKeyword(String keyword) throws InterruptedException {
        //searchPage.fillSearchField(keyword);
        searchPage.pasteToSearchField(keyword);
        searchPage.clickSearchButtonOrPressEnter();
        return new SearchResultSteps();
    }

}
