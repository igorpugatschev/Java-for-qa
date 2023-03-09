package ru.stqa.pft.addressbook.tests.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import ru.stqa.pft.addressbook.tests.model.GroupData;

public class GroupHelper {
    private WebDriver driver;

    public GroupHelper(WebDriver driver) {
        this.driver = driver;
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

    public void deleteGroup() {
      driver.findElement(By.xpath("//input[@name=\'delete\']")).click();
    }

    public void selectGroup() {
      driver.findElement(By.xpath("//input[@name=\'selected[]\']")).click();
    }
}
