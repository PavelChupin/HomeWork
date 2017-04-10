package ru.stqa.pft.homework.tests_addressbook;

import org.apache.xpath.operations.Bool;
import org.hamcrest.CoreMatchers;
import org.openqa.selenium.remote.BrowserType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import ru.stqa.pft.homework.appmanager.ApplicationManager;
import ru.stqa.pft.homework.model.GroupData;
import ru.stqa.pft.homework.model.Groups;
import ru.stqa.pft.homework.model.PersonData;
import ru.stqa.pft.homework.model.Persons;

import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.stream.Collectors;

import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.*;

//import sun.plugin2.util.BrowserType;

/**
 * Created by Summoner on 26.02.2017.
 */
public class TestBase {

    //Настроим логирование
    Logger logger = LoggerFactory.getLogger(GroupCreationHome.class);
    //Конец
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

    //Предобработка для логирования
    @BeforeMethod
    public void logTestStart(Method m, Object[] p){
        //Настраиваем логирование начало
        logger.info("Start test " + m.getName() + " with parametrs " + Arrays.asList(p));

    }

    //Окончание логирования
    @AfterMethod (alwaysRun = true)
    public void logTestStop(Method m){
        //Настраиваем логирование конец
        logger.info("Stop test " + m.getName());
    }
    //Метод отключения проверки через интерфейс и переход на проверки через базу.
    public void verifyGroupListInUI() {
        //Проверка отключения свойства
        if (Boolean.getBoolean("verifyUI")) {
            //Загружаемый список из Базы данных
            Groups dbGroups = app.db().groups();
            //Загружаемый список из интерфейса
            Groups uiGroups = app.group().all();
            //Сравниваем множества. Для множества из базы делаем упрощение так как у него больше сравниваемых параметров.
            assertThat(uiGroups, equalTo(dbGroups.stream()
                    .map((g) -> new GroupData().withId(g.getId()).withName(g.getName()))
                    .collect(Collectors.toSet())));
        }
        }

    //Метод отключения проверки через интерфейс и переход на проверки через базу.
    public void verifyPersonListInUI() {
        //Проверка отключения свойства
        if (Boolean.getBoolean("verifyUI")) {
            //Загружаемый список из Базы данных
            Persons dbPersons = app.db().persons();
            //Загружаемый список из интерфейса
            Persons uiPersons = app.persone().all();
            //Сравниваем множества. Для множества из базы делаем упрощение так как у него больше сравниваемых параметров.
            assertThat(uiPersons, equalTo(dbPersons.stream()
                    .map((g) -> new PersonData().withId(g.getId()).withFirstname(g.getFirstname())
                            .withLastname(g.getLastname()).withAllPhones(g.getAllPhones()).withAddress(g.getAddress()).withAllEmail(g.getAllEmail()))
                    .collect(Collectors.toSet())));
        }
    }
}
