package ru.stqa.pft.homework.tests_addressbook;

import org.testng.annotations.*;
import ru.stqa.pft.homework.appmanager.ApplicationManager;
//import sun.plugin2.util.BrowserType;
import org.openqa.selenium.remote.BrowserType;
/**
 * Created by Summoner on 26.02.2017.
 */
public class TestBase  {

    protected static final ApplicationManager app = new ApplicationManager(BrowserType.CHROME);

   /* public TestBase (String browserType){
        app = new ApplicationManager(browserType);
    }
*/
    @BeforeSuite
    public void setUp() throws Exception {
        app.init();
    }

    @AfterSuite
    public void tearDown() {
        app.stop();
    }

    public ApplicationManager getApp() {
        return app;
    }

}
