import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import static org.assertj.core.api.Assertions.assertThat;


public class SearchTest extends BaseTest {



    @Test(dataProvider = "dataProvider")
    public void openGoogleComInFireFoxTest1(String text) throws InterruptedException {

        System.out.println(driver.getTitle());//выводим в консоль заголовок страницы
        WebElement searchField = driver.findElement(By.xpath("//input[@name='q']"));
        searchField.click();
        searchField.sendKeys(text);
        searchField.sendKeys(Keys.ENTER);
        Thread.sleep(3000);
        WebElement resultRow = driver.findElement(By.xpath("//h3"));
        assertThat(resultRow.isDisplayed()).as("Element has not been displayed!").isTrue();
        assertThat(resultRow.getText()).as("Wrong text has been displayed!").isEqualTo("Пишем автотест с использованием Selenium Webdriver ...");
        assertThat(resultRow.getAttribute("class")).as("Wrong attribute text").contains("LC20lb MBeuO DKV0Md");


    }


}
