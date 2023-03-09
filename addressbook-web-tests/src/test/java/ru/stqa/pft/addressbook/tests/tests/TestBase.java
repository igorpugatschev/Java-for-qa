package ru.stqa.pft.addressbook.tests.tests;

import org.junit.After;
import org.junit.Before;
import ru.stqa.pft.addressbook.tests.appmanager.ApplicationManager;

public class TestBase {

    protected final ApplicationManager app = new ApplicationManager();

    @Before
    public void setUp() throws Exception {
        app.init();
    }


    @After
    public void tearDown() {
        app.stop();
    }

}
