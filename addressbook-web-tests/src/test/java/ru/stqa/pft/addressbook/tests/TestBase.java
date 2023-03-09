package ru.stqa.pft.addressbook.tests;

import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.HashMap;
import java.util.Map;

public class TestBase {

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

    @Before
    public void setUp() {
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


    protected void returnToGroupPage() {
        driver.findElement(By.xpath("//a[contains(text(),\'group page\')]")).click();
    }

    protected void submitGroupCreation() {
        driver.findElement(By.xpath("//input[@name=\'submit\']")).click();
    }

    protected void fillGroupForm(GroupData groupData) {
        driver.findElement(By.xpath("//input[@name=\'group_name\']")).click();
        driver.findElement(By.xpath("//input[@name=\'group_name\']")).sendKeys(groupData.getName());
        driver.findElement(By.xpath("//textarea[@name=\'group_header\']")).click();
        driver.findElement(By.xpath("//textarea[@name=\'group_header\']")).sendKeys(groupData.getHeader());
        driver.findElement(By.xpath("//textarea[@name=\'group_footer\']")).click();
        driver.findElement(By.xpath("//textarea[@name=\'group_footer\']")).sendKeys(groupData.getFooter());
    }

    protected void initGroupCreation() {
        driver.findElement(By.xpath("//input[@name=\'new\']")).click();
    }

    protected void gotoGroupPage() {
        driver.findElement(By.xpath("//a[contains(text(),\'groups\')]")).click();
    }

    @After


    public void tearDown() {
        //logOut();
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

    protected void deleteGroup() {
      driver.findElement(By.xpath("//input[@name=\'delete\']")).click();
    }

    protected void selectGroup() {
      driver.findElement(By.xpath("//input[@name=\'selected[]\']")).click();
    }
}
