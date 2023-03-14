import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.io.File;

public class SearchTest {

    @Test
    public void openGoogleComInChromeTest() {
        File file = new File("src/test/resources/chromedriver.exe");//подключаем драйвер браузера
        System.setProperty("webdriver.chrome.driver", file.getAbsolutePath());//передаём путь к драйверу в системные переменные
        //System.setProperty("webdriver.http.factory", "jdk-http-client");
        WebDriver driver = new ChromeDriver();//создаём объект драйвер
        driver.navigate().to("https://www.google.com/");//переход по указанной ссылке
        //driver.get("https://www.google.com/");//то же, что driver.navigate().to()
        driver.navigate().refresh();//обновить текущую страницу
        System.out.println(driver.getTitle());//выводим в консоль заголовок страницы
        driver.quit();//выйти и закрыть все окна

    }
}
