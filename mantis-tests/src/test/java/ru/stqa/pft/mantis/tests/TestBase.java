package ru.stqa.pft.mantis.tests;

import org.openqa.selenium.remote.BrowserType;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import ru.lanwen.verbalregex.VerbalExpression;
import ru.stqa.pft.mantis.appmanager.ApplicationManager;
import ru.stqa.pft.mantis.model.MailMessage;

import java.io.File;
import java.io.IOException;
import java.util.List;

//import sun.plugin2.util.BrowserType;

/**
 * Created by Summoner on 26.02.2017.
 */
public class TestBase {

    protected static final ApplicationManager app =
            new ApplicationManager(System.getProperty("browser",BrowserType.FIREFOX));


    @BeforeSuite
    public void setUp() throws Exception {
        app.init();
        app.ftp().upload(new File("src/test/resources/config_inc.php"),"config_inc.php","config_inc.php.bak");
    }

    @AfterSuite
    public void tearDown() throws IOException {
        app.ftp().restore("config_inc.php.bak","config_inc.php");
        app.stop();
    }



}
