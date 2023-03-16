package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import steps.SearchSteps;
import utils.Browser;
import utils.DriverFactiory;

import java.io.File;

public abstract class BaseTest {


    private static WebDriver driver;
    SearchSteps steps;
    public static WebDriver getDriver() {
        return driver;
    }
    @BeforeClass
    public void setUp() {
        driver = DriverFactiory.getDriver(Browser.CHROME);
        driver.get("https://www.google.com/");//переход по указанной ссылке
        steps = new SearchSteps();
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

