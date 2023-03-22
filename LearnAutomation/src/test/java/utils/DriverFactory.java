package utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.io.File;


public class DriverFactory {

    private final static String DRIVER_PATH = "src/test/resources/";
    private static WebDriver driver;

    public static WebDriver getDriver(Browser browser) {
        File file;

        switch (browser) {
            case CHROME:
                ChromeOptions options = new ChromeOptions();
                options.addArguments("--remote-allow-origins=*");
                file = new File(DRIVER_PATH + "chromedriver.exe");//подключаем драйвер браузера
                System.setProperty("webdriver.http.factory", "jdk-http-client");
                System.setProperty("webdriver.chrome.driver", file.getAbsolutePath());//передаём путь к драйверу в системные переменные
                driver = new ChromeDriver(options);//создаём объект драйвер
                break;

            case FIREFOX:
                file = new File(DRIVER_PATH + "geckodriver.exe");//подключаем драйвер браузера
                System.setProperty("webdriver.gecko.driver", file.getAbsolutePath());//передаём путь к драйверу в системные переменные
                driver = new FirefoxDriver();//создаём объект драйвер

                break;

            case EDGE:
                file = new File(DRIVER_PATH + "msedgedriver.exe");//подключаем драйвер браузера
                System.setProperty("webdriver.edge.driver", file.getAbsolutePath());//передаём путь к драйверу в системные переменные
                driver = new EdgeDriver();//создаём объект драйвер
                break;

        }
        driver.manage().window().maximize();
        return driver;
    }


}
