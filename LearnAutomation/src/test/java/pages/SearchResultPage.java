package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;

public class SearchResultPage extends BasePage {

    @FindBy(xpath = "//h3")
    private WebElement resultRow;

    @FindBy(xpath = "//h3")
    private List<WebElement> resultRows;

    public SearchResultPage() {
        super();
    }

    public void assertThatTopResultContainsCorrectText(String expected) {
        assertThat(resultRow.isDisplayed()).as("Element has not been displayed!").isTrue();
        assertThat(resultRows.stream().map(e->e.getText()).collect(Collectors.toList()).toString())
                .as("Wrong text has been displayed!").contains(expected);
    }

    public void assertThatTopResultContainsProperAttributeText(String expected) {

        assertThat(resultRow.getAttribute("class")).as("Wrong attribute text").contains(expected);


    }
}
