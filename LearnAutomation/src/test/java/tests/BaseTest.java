package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;

import java.io.File;

public abstract class BaseTest {


    private static WebDriver driver;
    public static WebDriver getDriver() {
        return driver;
    }
    @BeforeClass
    public void setUp(){
        File file = new File("src/test/resources/geckodriver.exe");//подключаем драйвер браузера
        System.setProperty("webdriver.Firefox.driver", file.getAbsolutePath());//передаём путь к драйверу в системные переменные
        driver = new FirefoxDriver();//создаём объект драйвер
        driver.get("https://www.google.com/");//переход по указанной ссылке
        System.out.println(driver.getTitle());//выводим в консоль заголовок страницы
        }


    @AfterClass
    public void tearDown(){
        driver.quit();//выйти и закрыть все окна
        }

    @AfterMethod
    public void goBack(){ driver.navigate().back();}

    @DataProvider(name = "dataProvider")
    public Object[][]dataProviderMethod(){
        return new Object[][]{{"selenium java"}, {"selenium javaScript"}};

    }

}

