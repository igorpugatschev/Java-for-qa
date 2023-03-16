package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import static org.assertj.core.api.Assertions.assertThat;

public class SearchResultPage extends BasePage {

    private By resultRow = By.xpath("//h3");

    public SearchResultPage() {
        super();
    }

    public void assertThatTopResultContainsCorrectText(String expected) {
        WebElement resultRowElement = driver.findElement(resultRow);
        assertThat(resultRowElement.isDisplayed()).as("Element has not been displayed!").isTrue();
        assertThat(resultRowElement.getText()).as("Wrong text has been displayed!").isEqualTo(expected);


    }

    public void assertThatTopResultContainsProperAttributeText(String expected) {

        WebElement resultRowElement = driver.findElement(resultRow);
        assertThat(resultRowElement.getAttribute("class")).as("Wrong attribute text").contains(expected);


    }
}
