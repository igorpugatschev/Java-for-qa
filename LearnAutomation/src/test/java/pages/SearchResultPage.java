package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static org.assertj.core.api.Assertions.assertThat;

public class SearchResultPage extends BasePage {

    @FindBy(xpath = "//h3")
    private WebElement resultRow;

    public SearchResultPage() {
        super();
    }

    public void assertThatTopResultContainsCorrectText(String expected) {
        assertThat(resultRow.isDisplayed()).as("Element has not been displayed!").isTrue();
        assertThat(resultRow.getText()).as("Wrong text has been displayed!").isEqualTo(expected);


    }

    public void assertThatTopResultContainsProperAttributeText(String expected) {

        assertThat(resultRow.getAttribute("class")).as("Wrong attribute text").contains(expected);


    }
}
