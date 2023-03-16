package pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SearchPage extends BasePage {

    @FindBy(xpath = ("//input[@name='q']"))
    private WebElement searchField;

    public SearchPage() {
        super();
    }

    public void fillSearchField(String text) {
        searchField.click();
        searchField.sendKeys(text);
    }

    public void pressEnter() {
        searchField.sendKeys(Keys.ENTER);
    }
}
