package ru.stqa.pft.homework.appmanager;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxBinary;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.BrowserType;
import ru.stqa.pft.homework.model.LoginData;

import java.io.File;
import java.util.concurrent.TimeUnit;

/**
 * Created by Summoner on 27.02.2017.
 */
public class ApplicationManager {
    WebDriver wd;

    private NavigationHelper navigationHelper;
    private GroupHelper groupHelper;
    private PersonHelper personHelper;
    private SessionHelper sessionHelper;
    private String browser;

    public ApplicationManager(String browser) {

        this.browser = browser;
    }

    public void init() {
        if (browser.equals(BrowserType.FIREFOX)){
            //Если не находится исполняемый файл браузера то
            //FirefoxBinary bin = new FirefoxBinary(new File("c:\\Program Files (x86)\\Mozilla Firefox\\firefox.exe"));
            //wd = new FirefoxDriver(bin, new FirefoxProfile());
            wd = new FirefoxDriver();
        }else if (browser.equals(BrowserType.CHROME)){
            wd = new ChromeDriver();
        }else if (browser.equals(BrowserType.IE)){
            wd = new InternetExplorerDriver();
        }

        //wd = new FirefoxDriver();
        wd.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
        wd.get("http://localhost/addressbook/");

        navigationHelper = new NavigationHelper(wd);
        groupHelper = new GroupHelper(wd, navigationHelper);
        personHelper = new PersonHelper(wd, groupHelper, navigationHelper);
        sessionHelper = new SessionHelper(wd);
        sessionHelper.login(new LoginData("admin", "secret"));
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
