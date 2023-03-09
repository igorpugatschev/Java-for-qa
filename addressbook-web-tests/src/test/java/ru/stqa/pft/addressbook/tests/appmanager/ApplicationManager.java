package ru.stqa.pft.addressbook.tests.appmanager;

import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import ru.stqa.pft.addressbook.tests.model.GroupData;

import java.util.HashMap;
import java.util.Map;

public class ApplicationManager {
    JavascriptExecutor js;
    private WebDriver driver;
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
        js = (JavascriptExecutor) driver;
        vars = new HashMap<String, Object>();
        getToURL("http://127.0.0.1/addressbook/");
        login("admin", "secret");
    }

    private void getToURL(String url) {
        // Test name: GroupDeleteTest
        // Step # | name | target | value
        // 1 | open | /addressbook/ |
        driver.get(url);
        // 2 | setWindowSize | 855x952 |
        driver.manage().window().setSize(new Dimension(855, 952));
    }

    private void login(String username, String password) {
        // 3 | click | xpath=//input[@name='user'] |
        driver.findElement(By.xpath("//input[@name=\'user\']")).click();
        driver.findElement(By.xpath("//input[@name=\'user\']")).sendKeys(username);
        // 4 | type | xpath=//input[@name='user'] |
        driver.findElement(By.xpath("//input[@name=\'user\']")).click();
        driver.findElement(By.xpath("//input[@name=\'pass\']")).sendKeys(password);
        // 7 | click | xpath=//input[@value='Login'] |
        driver.findElement(By.xpath("//input[@value=\'Login\']")).click();


    }

    public void returnToGroupPage() {
        driver.findElement(By.xpath("//a[contains(text(),\'group page\')]")).click();
    }

    public void submitGroupCreation() {
        driver.findElement(By.xpath("//input[@name=\'submit\']")).click();
    }

    public void fillGroupForm(GroupData groupData) {
        driver.findElement(By.xpath("//input[@name=\'group_name\']")).click();
        driver.findElement(By.xpath("//input[@name=\'group_name\']")).sendKeys(groupData.getName());
        driver.findElement(By.xpath("//textarea[@name=\'group_header\']")).click();
        driver.findElement(By.xpath("//textarea[@name=\'group_header\']")).sendKeys(groupData.getHeader());
        driver.findElement(By.xpath("//textarea[@name=\'group_footer\']")).click();
        driver.findElement(By.xpath("//textarea[@name=\'group_footer\']")).sendKeys(groupData.getFooter());
    }

    public void initGroupCreation() {
        driver.findElement(By.xpath("//input[@name=\'new\']")).click();
    }

    public void gotoGroupPage() {
        driver.findElement(By.xpath("//a[contains(text(),\'groups\')]")).click();
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

    public void deleteGroup() {
      driver.findElement(By.xpath("//input[@name=\'delete\']")).click();
    }

    public void selectGroup() {
      driver.findElement(By.xpath("//input[@name=\'selected[]\']")).click();
    }
}
