package ru.stqa.pft.mantis.appmanager;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.BrowserType;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

/**
 * Created by Summoner on 27.02.2017.
 */
public class ApplicationManager {
    private final Properties properties;
    private WebDriver wd;

    private String browser;
    private RegistrationHelper registrationHelper;
    private FtpHelper ftp;
    private MailHelper mailHelper;
    private ReplasePasswordHelper replasePasswordHelper;
    private DbHelper dbHelper;


    public ApplicationManager(String browser) {

        this.browser = browser;
        properties = new Properties();

    }

    public void init() throws IOException {
        //Создаем конфигурационный файл
        String target = System.getProperty("target", "local");
        properties.load(new FileReader(new File(String.format("src/test/resources/%s.properties", target))));

    }


    public void stop() {
        if (wd != null) {
            wd.quit();
        }
    }

    //Инициализация помошника HttpSession
    public HttpSession newSession() {
        //На вход помошнику при создании передаем ссылку на ApplicationManager
        return new HttpSession(this);
    }

    //Инициализация помошника HttpSession
    public FtpHelper ftp() {
        if (ftp == null) {ftp = new FtpHelper(this);}
        return ftp;
    }

    public String getProperty(String key) {
        return properties.getProperty(key);
    }


    public RegistrationHelper registration() {
        if (registrationHelper == null) {
            registrationHelper = new RegistrationHelper(this);
        }
        return registrationHelper;
    }

    public ReplasePasswordHelper replasePassword() {
        if (replasePasswordHelper == null) {
            replasePasswordHelper = new ReplasePasswordHelper(this);
        }
        return replasePasswordHelper;
    }
    public WebDriver getDriver() {
        if (wd == null) {
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
        }
        return wd;
    }

    public MailHelper mail(){
        if (mailHelper == null){
            mailHelper = new MailHelper(this);
        }
        return mailHelper;
    }

    public DbHelper db(String typeConnection) {
        if (dbHelper == null){
            //dbHelper = new DbHelper(this);
            dbHelper = new DbHelper(this,typeConnection);
        }
        return dbHelper;
    }
}
