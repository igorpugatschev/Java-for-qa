package ru.stqa.pft.addressbook.tests.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SessionHelper {
    private WebDriver driver;

    public SessionHelper(WebDriver driver) {

        this.driver = driver;
    }

    public void login(String username, String password) {
        // 3 | click | xpath=//input[@name='user'] |
        driver.findElement(By.xpath("//input[@name=\'user\']")).click();
        driver.findElement(By.xpath("//input[@name=\'user\']")).sendKeys(username);
        // 4 | type | xpath=//input[@name='user'] |
        driver.findElement(By.xpath("//input[@name=\'user\']")).click();
        driver.findElement(By.xpath("//input[@name=\'pass\']")).sendKeys(password);
        // 7 | click | xpath=//input[@value='Login'] |
        driver.findElement(By.xpath("//input[@value=\'Login\']")).click();

    }
}
