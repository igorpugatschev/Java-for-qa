package ru.stqa.pft.addressbook.tests.tests;

import org.junit.Test;
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
/*
> Task :test FAILED

Execution failed for task ':test'.
> No tests found for given includes: [ru.stqa.pft.addressbook.tests.tests.GroupModificationTests](--tests filter)

* Try:
> Run with --stacktrace option to get the stack trace.
> Run with --info or --debug option to get more log output.
> Run with --scan to get full insights.
 */