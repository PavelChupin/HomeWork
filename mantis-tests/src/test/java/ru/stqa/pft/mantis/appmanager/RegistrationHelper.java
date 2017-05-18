package ru.stqa.pft.mantis.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import ru.stqa.pft.mantis.tests.TestBase;

/**
 * Created by Summoner on 03.05.2017.
 */
public class RegistrationHelper extends HelperBase{
    //private final ApplicationManager app;
    //private WebDriver wd;

    public RegistrationHelper(ApplicationManager app) {
        super(app);
        //this.app = app;
        //wd = app.getDriver();
    }

    public void start(String username, String email) {
        //Переходим на страницу регистрации нового пользователя
        wd.get(app.getProperty("web.baseUrl") + "/signup_page.php");
        //Вводим логин и пароль
        type(By.name("username"),username);
        type(By.name("email"),email);
        click(By.cssSelector("input[value='Signup']"));

    }

    public void finish(String confirmationLink, String password) {
        //Переходм по ссылке полученной в письме
        wd.get(confirmationLink);
        //Вводим логин и пароль
        type(By.name("password"),password);
        type(By.name("password_confirm"),password);
        click(By.cssSelector("input[value='Update User']"));
    }
}
