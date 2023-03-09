package ru.stqa.pft.addressbook.tests;// Generated by Selenium IDE

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.HashMap;
import java.util.Map;

public class GroupCreationTests {
    private WebDriver driver;
    private Map<String, Object> vars;
    JavascriptExecutor js;

    @Before
    public void setUp() {
        driver = new FirefoxDriver();
        js = (JavascriptExecutor) driver;
        vars = new HashMap<String, Object>();
        driver.get("http://127.0.0.1/addressbook/");
        driver.manage().window().setSize(new Dimension(855, 952));
        login("admin", "secret");
    }

    private void login(String username, String password) {

        driver.findElement(By.xpath("//input[@name=\'user\']")).click();
        driver.findElement(By.xpath("//input[@name=\'user\']")).sendKeys(username);
        driver.findElement(By.xpath("//input[@name=\'user\']")).click();
        driver.findElement(By.xpath("//input[@name=\'pass\']")).sendKeys(password);
        driver.findElement(By.xpath("//input[@value=\'Login\']")).click();
    }

    @Test
    public void testGroupCreation() {

        gotoGroupPage();
        initGroupCreation();
        fillGroupForm(new GroupData("group 1", "header of group 1", "footer of group 1"));
        submitGroupCreation();
        returnToGroupPage();

    }

    private void returnToGroupPage() {
        driver.findElement(By.xpath("//a[contains(text(),\'group page\')]")).click();
    }

    private void submitGroupCreation() {
        driver.findElement(By.xpath("//input[@name=\'submit\']")).click();
    }

    private void fillGroupForm(GroupData groupData) {
        driver.findElement(By.xpath("//input[@name=\'group_name\']")).click();
        driver.findElement(By.xpath("//input[@name=\'group_name\']")).sendKeys(groupData.getName());
        driver.findElement(By.xpath("//textarea[@name=\'group_header\']")).click();
        driver.findElement(By.xpath("//textarea[@name=\'group_header\']")).sendKeys(groupData.getHeader());
        driver.findElement(By.xpath("//textarea[@name=\'group_footer\']")).click();
        driver.findElement(By.xpath("//textarea[@name=\'group_footer\']")).sendKeys(groupData.getFooter());
    }

    private void initGroupCreation() {
        driver.findElement(By.xpath("//input[@name=\'new\']")).click();
    }

    private void gotoGroupPage() {
        driver.findElement(By.xpath("//a[contains(text(),\'groups\')]")).click();
    }


    @After

    public void tearDown() {
        driver.quit();
    }

    public static boolean isAlertPresent(FirefoxDriver driver) {
        try {
            driver.switchTo().alert();
            return true;
        } catch (NoAlertPresentException e) {
            return false;
        }
    }

}
