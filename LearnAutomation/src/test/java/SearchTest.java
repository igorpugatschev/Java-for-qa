import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

import java.io.File;
import java.util.List;

public class SearchTest {

    @Test
    public void openGoogleComInChromeTest() throws InterruptedException {
        File file = new File("src/test/resources/geckodriver.exe");//подключаем драйвер браузера
        System.setProperty("webdriver.chrome.driver", file.getAbsolutePath());//передаём путь к драйверу в системные переменные


        WebDriver driver = new FirefoxDriver();//создаём объект драйвер
        //используем FireFox
        //Google Chrome - не запускается
        driver.get("https://www.google.com/");//переход по указанной ссылке
        //driver.get("https://www.google.com/");//то же, что driver.navigate().to()
        System.out.println(driver.getTitle());//выводим в консоль заголовок страницы

        //Scenario with Search 'selenium java' & Enter button

        WebElement searchField = driver.findElement(By.xpath("/html/body/div[1]/div[3]/form/div[1]/div[1]/div[1]/div/div[2]/input"));
        searchField.click();
        searchField.sendKeys("selenium java");
        searchField.sendKeys(Keys.ENTER);
        Thread.sleep(3000);

        WebElement resultRow = driver.findElement(By.xpath("/html/body/div[7]/div/div[11]/div/div[2]/div[2]/div/div/div[1]/div/div/div[1]/div/a/h3"));
        System.out.println(resultRow.getText());
        System.out.println(resultRow.getAttribute("class"));




        driver.quit();//выйти и закрыть все окна

    }
}
