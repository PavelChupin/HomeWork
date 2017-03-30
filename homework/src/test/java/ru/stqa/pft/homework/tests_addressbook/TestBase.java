package ru.stqa.pft.homework.tests_addressbook;

import org.openqa.selenium.remote.BrowserType;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import ru.stqa.pft.homework.appmanager.ApplicationManager;

//import sun.plugin2.util.BrowserType;

/**
 * Created by Summoner on 26.02.2017.
 */
public class TestBase {
    /*
    //Переменная для использования браузера дефолтная
    protected static final ApplicationManager app = new ApplicationManager(BrowserType.CHROME);
    */

    //Переменная для использования браузера из настроек свойств, настройка устанавливается в
    // EditConfiguration файла теста в поле VM Option через ключь -Dfirefox
    protected static final ApplicationManager app =
            new ApplicationManager(System.getProperty("browser",BrowserType.CHROME));

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
