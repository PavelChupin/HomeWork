package ru.stqa.pft.homework.tests_addressbook;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import ru.stqa.pft.homework.appmanager.ApplicationManager;

/**
 * Created by Summoner on 26.02.2017.
 */
public class TestBase  {

    protected final ApplicationManager app = new ApplicationManager();

    @BeforeMethod
    public void setUp() throws Exception {
        app.init();
    }

    @AfterMethod
    public void tearDown() {
        app.stop();
    }

    public ApplicationManager getApp() {
        return app;
    }

}
