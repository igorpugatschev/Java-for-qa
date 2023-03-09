package ru.stqa.pft.addressbook.tests.appmanager;

import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.HashMap;
import java.util.Map;

public class ApplicationManager {
    private WebDriver driver;
    private NavigationHelper navigationHelper;
    private GroupHelper groupHelper;
    private SessionHelper sessionHelper;
    JavascriptExecutor js;
    private Map<String, Object> vars;

    public static boolean isAlertPresent(FirefoxDriver driver) {
        try {
            driver.switchTo().alert();
            return true;
        } catch (NoAlertPresentException e) {
            return false;
        }
    }

    public void init() {
        driver = new FirefoxDriver();
        js = (JavascriptExecutor)driver;
        vars = new HashMap<String, Object>();
        groupHelper = new GroupHelper(driver);
        navigationHelper = new NavigationHelper(driver);
        sessionHelper = new SessionHelper(driver);
        getToURL("http://127.0.0.1/addressbook/");
        sessionHelper.login("admin", "secret");
    }

    private void getToURL(String url) {
        // Test name: GroupDeleteTest
        // Step # | name | target | value
        // 1 | open | /addressbook/ |
        driver.get(url);
        // 2 | setWindowSize | 855x952 |
        driver.manage().window().setSize(new Dimension(855, 952));
    }



    public void stop() {
        driver.quit();
    }

    private void logOut() {
        // 12 | click | xpath=//a[contains(text(),'home')] |
        driver.findElement(By.xpath("//a[contains(text(),\'home\')]")).click();
        // 13 | click | xpath=//a[contains(text(),'Logout')] |
        driver.findElement(By.xpath("//a[contains(text(),\'Logout\')]")).click();
        // 14 | close |  |
        driver.close();
    }

    public GroupHelper getGroupHelper() {
        return groupHelper;
    }

    public NavigationHelper getNavigationHelper() {
        return navigationHelper;
    }
}
