package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

import static tests.BaseTest.getDriver;

public abstract class BasePage {

    WebDriver driver;
    WebDriverWait wait;
    public BasePage() {
        this.driver = getDriver();
        PageFactory.initElements(driver, this);
        wait = new WebDriverWait(driver, Duration.ofSeconds(5));
    }

    boolean isElementFound(By by, int timeout) throws InterruptedException {
        List<WebElement> elements = driver.findElements(by);
        for(int i =0; (i < timeout) && (elements.size()==0); i++) {
            Thread.sleep(1000);
            elements = driver.findElements(by);

        }
        return elements.size() > 0;

    }
}
