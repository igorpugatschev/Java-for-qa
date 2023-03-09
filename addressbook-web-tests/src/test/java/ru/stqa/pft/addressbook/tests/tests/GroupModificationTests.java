package ru.stqa.pft.addressbook.tests.tests;

import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.tests.model.GroupData;

public class GroupModificationTests extends TestBase{

    @Test
    public void testGroupModification(){
        app.getNavigationHelper().gotoGroupPage();
        app.getGroupHelper().selectGroup();
        app.getGroupHelper().initGroupModification();
        app.getGroupHelper().fillGroupForm(new GroupData("group 1 edited", "header of group 1 edited", "footer of group 1 edited"));
        app.getGroupHelper().submitGroupModification();
        app.getGroupHelper().returnToGroupPage();
    }
}
