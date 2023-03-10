package ru.stqa.pft.addressbook.tests.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class NavigationHelper {
    private WebDriver driver;
    public NavigationHelper(WebDriver driver) {
        this.driver = driver;

    }

    public void gotoGroupPage() {
       
        driver.findElement(By.xpath("//a[contains(text(),\'groups\')]")).click();
    }

    public void gotoHomePage() {
       driver.findElement(By.xpath("//a[contains(text(),\'home\')]")).click();
    }



    }
