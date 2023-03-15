import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;
import static org.assertj.core.api.Assertions.assertThat;

import java.io.File;


public class SearchTest {

    @Test
    public void openGoogleComInFireFoxTest() throws InterruptedException {
        File file = new File("src/test/resources/geckodriver.exe");//подключаем драйвер браузера
        System.setProperty("webdriver.chrome.driver", file.getAbsolutePath());//передаём путь к драйверу в системные переменные


        WebDriver driver = new FirefoxDriver();//создаём объект драйвер
        //используем FireFox
        //Google Chrome - не запускается
        driver.get("https://www.google.com/");//переход по указанной ссылке
        //driver.get("https://www.google.com/");//то же, что driver.navigate().to()
        System.out.println(driver.getTitle());//выводим в консоль заголовок страницы

        //Scenario with Search 'selenium java' & Enter button

        WebElement searchField = driver.findElement(By.xpath("//input[@name='q']"));
        searchField.click();
        searchField.sendKeys("selenium java");
        searchField.sendKeys(Keys.ENTER);
        Thread.sleep(3000);

        WebElement resultRow = driver.findElement(By.xpath("//div[@class='g']//h3"));
        assertThat(resultRow.isDisplayed()).as("Element has not been displayed!").isTrue();
        assertThat(resultRow.getText()).as("Wrong text has been displayed!").isEqualTo("The Selenium Browser Automation Project");
        assertThat(resultRow.getAttribute("class")).as("Wrong attribute text").contains("LC20lb MBeuO DKV0Md");

/**
        assertTrue(resultRow.isDisplayed(), "Element has not been displayed!");
        assertEquals(resultRow.getText(), "The Selenium Browser Automation Project", "Wrong text has been displayed!");
        assertEquals(resultRow.getAttribute("class"), "LC20lb MBeuO DKV0Md", "Wrong attribute text");
         */






        driver.quit();//выйти и закрыть все окна

    }
}
