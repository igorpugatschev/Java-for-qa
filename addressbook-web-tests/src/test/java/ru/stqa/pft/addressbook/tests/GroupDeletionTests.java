package ru.stqa.pft.addressbook.tests;// Generated by Selenium IDE

import org.junit.Test;

public class GroupDeletionTests extends TestBase {

  @Test
  public void testGroupDeletion() {

    gotoGroupPage();
    // 9 | click | xpath=//input[@name='selected[]'] | 
    selectGroup();
    // 10 | click | xpath=//input[@name='delete'] | 
    deleteGroup();
    // 11 | click | xpath=//a[contains(text(),'group page')] | 
    returnToGroupPage();

  }

}
