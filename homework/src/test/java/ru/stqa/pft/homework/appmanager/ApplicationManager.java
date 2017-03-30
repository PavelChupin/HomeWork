package ru.stqa.pft.homework.appmanager;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.BrowserType;
import ru.stqa.pft.homework.model.LoginData;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

/**
 * Created by Summoner on 27.02.2017.
 */
public class ApplicationManager {
    private final Properties properties;
    WebDriver wd;

    private NavigationHelper navigationHelper;
    private GroupHelper groupHelper;
    private PersonHelper personHelper;
    private SessionHelper sessionHelper;
    private String browser;

    public ApplicationManager(String browser) {

        this.browser = browser;
        properties = new Properties();

    }

    public void init() throws IOException {
        //Создаем конфигурационный файл
        String target = System.getProperty("target","local");
        properties.load(new FileReader(new File(String.format("src/test/resources/%s.properties", target))));

        if (browser.equals(BrowserType.FIREFOX)) {
            //Если не находится исполняемый файл браузера то
            //FirefoxBinary bin = new FirefoxBinary(new File("c:\\Program Files (x86)\\Mozilla Firefox\\firefox.exe"));
            //wd = new FirefoxDriver(bin, new FirefoxProfile());
            wd = new FirefoxDriver();
        } else if (browser.equals(BrowserType.CHROME)) {
            wd = new ChromeDriver();
        } else if (browser.equals(BrowserType.IE)) {
            wd = new InternetExplorerDriver();
        }

        //wd = new FirefoxDriver();
        wd.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
        //wd.get("http://localhost/addressbook/");
        //Используем свойства из конфигурационного файла
        wd.get(properties.getProperty("web.baseUrl"));
        navigationHelper = new NavigationHelper(wd);
        groupHelper = new GroupHelper(wd, navigationHelper);
        personHelper = new PersonHelper(wd, groupHelper, navigationHelper);
        sessionHelper = new SessionHelper(wd);
        //sessionHelper.login(new LoginData("admin", "secret"));
        //Используем свойства из конфигурационного файла
        sessionHelper.login(new LoginData(properties.getProperty("web.adminLogin"), properties.getProperty("web.adminPassword")));
    }


    public void stop() {
        wd.quit();
    }

    public GroupHelper group() {
        return groupHelper;
    }

    public PersonHelper persone() {
        return personHelper;
    }

    public NavigationHelper goTo() {
        return navigationHelper;
    }
}
