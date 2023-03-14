import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

import java.io.File;
import java.util.List;

public class SearchTest {

    @Test
    public void openGoogleComInChromeTest() {
        File file = new File("src/test/resources/geckodriver.exe");//подключаем драйвер браузера
        System.setProperty("webdriver.chrome.driver", file.getAbsolutePath());//передаём путь к драйверу в системные переменные


        WebDriver driver = new FirefoxDriver();//создаём объект драйвер
        //используем FireFox
        //Google Chrome - не запускается
        driver.navigate().to("https://www.google.com/");//переход по указанной ссылке
        //driver.get("https://www.google.com/");//то же, что driver.navigate().to()
        System.out.println(driver.getTitle());//выводим в консоль заголовок страницы

        WebElement searchField = driver.findElement(By.name("q"));
        searchField.click();

        driver.navigate().refresh();//обновить текущую страницу

        WebElement googleAppsButton = driver.findElement(By.cssSelector("div#gbwa a"));
        googleAppsButton.click();

        driver.navigate().refresh();//обновить текущую страницу
        List<WebElement> googleSubmitButtons = driver.findElements(By.xpath("//input[@name='btnI']"));
        googleSubmitButtons.get(1).click();

        driver.quit();//выйти и закрыть все окна

    }
}
